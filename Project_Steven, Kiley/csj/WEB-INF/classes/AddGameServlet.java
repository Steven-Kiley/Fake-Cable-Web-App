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

public class AddGameServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		HttpSession session = request.getSession();
		
		try{
			Customer c = (Customer)session.getAttribute("Account");
			HashMap<String, SingleService> recur = Services.getSingles();
			String gameChoice = request.getParameter("gamechoice");
			SingleService temp = null;
			ArrayList<SingleService> services = c.getOneTime();
			//System.out.println(movieChoice);
			//System.out.println(sportsChoice);
			
			if(!(gameChoice.equals("none"))){
				temp = recur.get(gameChoice);
				if(!(services.contains(temp))){services.add(temp);}
			}
		
			Serializer.serialize("..\\webapps\\csj\\web-inf\\classes\\SerializedAccounts\\Customer\\"+c.getUsername()+".ser", c);
			
			Customer cNew = (Customer)AccountManager.retrieveAccount(c.getUsername());
			
			synchronized(session){
				session.setAttribute("Account", cNew);
			}
			
		
			response.sendRedirect("AddGameSuccess");
		}catch(Exception e){e.printStackTrace(); response.sendRedirect("SomethingWentWrong");}
		
	}
}