import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import PublicUtils.AccountManager;
import Beans.PassKeyBean;
import java.util.Enumeration;
import PublicUtils.AccountManager;
import accounts.Customer;

public class ManagerServlet extends HttpServlet{
	PassKeyBean pkb;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		HttpSession session = request.getSession();
		pkb = (PassKeyBean)session.getAttribute("PassKey");
		int privelege = pkb.getPrivelege();
		if(privelege != 3){response.sendRedirect("InsufficientPermissions");}
		Enumeration en = request.getParameterNames();
		String name = "";
		while(en.hasMoreElements()){
			name = (String)en.nextElement();
		}
		synchronized(session){
			session.setAttribute("choice", name);
		}
		response.sendRedirect("GetUser");
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		HttpSession session = request.getSession();
		pkb = (PassKeyBean)session.getAttribute("PassKey");
		int privelege = pkb.getPrivelege();
		if(privelege != 3){response.sendRedirect("InsufficientPermissions");}
		String username = request.getParameter("username");
		String choice = request.getParameter("choice");
		try{
			Customer c = AccountManager.retrieveAccount(username);
			synchronized(session){
				session.setAttribute("Account", c);
			}
		response.sendRedirect("ManagerSelectPage");
		}catch(Exception e){e.printStackTrace();response.sendRedirect("InsufficientPermissions");}
	}
	
}