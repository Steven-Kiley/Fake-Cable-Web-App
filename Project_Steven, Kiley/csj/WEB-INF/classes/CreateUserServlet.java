import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import PublicUtils.CustomerData;
import accounts.Customer;
import PublicUtils.Serializer;
import PublicUtils.AccountManager;
import services.*;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class CreateUserServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		HttpSession session = request.getSession();
		Customer c = null;
		CustomerData data = new CustomerData();
		HashMap<String, RecurringService> recurs = Services.getRecurs();
		
		Set keys = recurs.keySet();
		Iterator it = keys.iterator();
		String x = null;
		while(it.hasNext()){
			x = (String)it.next();
			System.out.println(x);
		}
		
		try{
			//data for user account login
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			//data for user information
			String street = request.getParameter("street");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			int zip  = Integer.parseInt(request.getParameter("zip"));
			int ccn = Integer.parseInt(request.getParameter("ccn"));
			String exp = request.getParameter("exp");
		
			//data for service choices
			String cablechoice = request.getParameter("cablechoice");
			String internetchoice = request.getParameter("internetchoice");
			
			System.out.println(cablechoice);
			
			data.setStreet(street);
			data.setCity(city);
			data.setState(state);
			data.setZip(zip);
			data.setCreditCardNum(ccn);
			data.setCreditCardExp(exp);
			
			c = new Customer(username, password, data);
			
			if(!(cablechoice.equals("none"))){
				RecurringService cable = recurs.get(cablechoice);
				c.setRecurring(cable);
			}
			if(!(internetchoice.equals("none"))){
				RecurringService internet = recurs.get(internetchoice);
				c.setRecurring(internet);
			}
		
			Serializer.serialize("..\\webapps\\csj\\web-inf\\classes\\SerializedAccounts\\Customer\\"+c.getUsername()+".ser", c);
			
			Customer cNew = (Customer)AccountManager.retrieveAccount(c.getUsername());
			
			synchronized(session){
				session.setAttribute("Account", cNew);
			}
			
		
			response.sendRedirect("CreationSuccess");
		}catch(Exception e){e.printStackTrace(); response.sendRedirect("SomethingWentWrong");}
		
	}
}