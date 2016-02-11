import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import PublicUtils.AccountManager;
import Beans.PassKeyBean;
import PublicUtils.AccountType;
import accounts.Customer;
import services.*;
import java.util.ArrayList;
import accounts.TechnicalSupport;

public class LoginServlet extends HttpServlet{
	PassKeyBean pkb;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		String loginType = (String)request.getParameter("ltype");
		//System.out.println(loginType);
		String username = (String)request.getParameter("username");
		//System.out.println(username);
		String password = (String)request.getParameter("password");
		//System.out.println(password);
		HttpSession session = request.getSession();
		
		//Fill out pkb from AccountManager using the appropriate account type
		try{
			if(loginType.equals("Customer")){pkb = AccountManager.checkLogIn(AccountType.CUSTOMER, username, password);}
			if(loginType.equals("Manager")){pkb = AccountManager.checkLogIn(AccountType.MANAGER, username, password);}
			if(loginType.equals("Technician")){pkb = AccountManager.checkLogIn(AccountType.TECHNICALSUPPORT, username, password);}
			if(loginType.equals("AccountSpecialist")){pkb = AccountManager.checkLogIn(AccountType.ACCOUNTSPECIALIST, username, password);}
		
			//Examine pkb to see if it is properly filled out and act accordingly
			String test = pkb.getUsername();
			if(test == null || test.equals("INVALID")){response.sendRedirect("LoginFailure");}
			else{
				synchronized(session){
					session.setAttribute("PassKey", pkb);
					if(loginType.equals("Customer")){
						Customer c = AccountManager.retrieveAccount(username);
						//ArrayList<RecurringService> rrrr = c.getRecur();
						//RecurringService rs = null;
						//for(int i = 0; i < rrrr.size(); i++){
							//rs = rrrr.get(i);
							//if(rs == null){System.out.println("Null object in Login Servlet");}
						//}
						
						//if(c == null){System.out.println("C is null in LoginServlet");}
						if(c != null){session.setAttribute("Account", c);}
					}
					if(loginType.equals("Technician")){
						TechnicalSupport t = AccountManager.retrieveTechnician(username);
						if(t != null){session.setAttribute("Tech", t);}
					}
				}
				//Redirect to correct page. 
				if(loginType.equals("Customer")){response.sendRedirect("CustomerLogin");}
				if(loginType.equals("Manager")){response.sendRedirect("ManagerLogin");}
				if(loginType.equals("Technician")){response.sendRedirect("TechnicianLogin");}
				if(loginType.equals("AccountSpecialist")){response.sendRedirect("AccountSpecialistLogin");}
			}
		}catch(ClassNotFoundException c){c.printStackTrace();}
		
	}
}