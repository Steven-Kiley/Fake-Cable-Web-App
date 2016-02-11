import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import PublicUtils.CustomerData;
import accounts.Customer;
import PublicUtils.Serializer;
import PublicUtils.AccountManager;

public class UpdateServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		HttpSession session = request.getSession();
		Customer c = (Customer)session.getAttribute("Account");
		CustomerData data = c.getPersonalInfo();
		try{
			String street = request.getParameter("street");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			int zip  = Integer.parseInt(request.getParameter("zip"));
			int ccn = Integer.parseInt(request.getParameter("ccn"));
			String exp = request.getParameter("exp");
		
			data.setStreet(street);
			data.setCity(city);
			data.setState(state);
			data.setZip(zip);
			data.setCreditCardNum(ccn);
			data.setCreditCardExp(exp);
		
			Serializer.serialize("..\\webapps\\csj\\web-inf\\classes\\SerializedAccounts\\Customer\\"+c.getUsername()+".ser", c);
			
			Customer cNew = (Customer)AccountManager.retrieveAccount(c.getUsername());
			
			synchronized(session){
				session.setAttribute("Account", cNew);
			}
			
		
			response.sendRedirect("UpdateSuccess");
		}catch(Exception e){e.printStackTrace(); response.sendRedirect("SomethingWentWrong");}
		
	}
}