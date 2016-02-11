import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import accounts.Customer;
import PublicUtils.Serializer;
import PublicUtils.AccountManager;
import services.*;
import PublicUtils.ServiceType;
import java.util.HashMap;
import java.util.ArrayList;

public class ChangeServiceServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		HttpSession session = request.getSession();
		
		try{
			Customer c = (Customer)session.getAttribute("Account");
			HashMap<String, RecurringService> recur = Services.getRecurs();
			String tvChoice = request.getParameter("tvchoice");
			String internetChoice = request.getParameter("internetchoice");
			RecurringService temp = null;
			ArrayList<RecurringService> newServices = new ArrayList<RecurringService>();
			System.out.println(tvChoice);
			System.out.println(internetChoice);
			
			if(!(tvChoice.equals("none"))){
				temp = recur.get(tvChoice);
				newServices.add(temp);
			}
			
			if(!internetChoice.equals("none")){
				temp = recur.get(internetChoice);
				newServices.add(temp);
			}
			
			c.setFullRecurring(newServices);
		
			Serializer.serialize("..\\webapps\\csj\\web-inf\\classes\\SerializedAccounts\\Customer\\"+c.getUsername()+".ser", c);
			
			Customer cNew = (Customer)AccountManager.retrieveAccount(c.getUsername());
			
			synchronized(session){
				session.setAttribute("Account", cNew);
			}
			
		
			response.sendRedirect("ChangePlanSuccess");
		}catch(Exception e){e.printStackTrace(); response.sendRedirect("SomethingWentWrong");}
		
	}
}