import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import accounts.Customer;
import PublicUtils.AccountManager;
import Beans.PassKeyBean;

public class SpecialistOrderPPV extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>\n<body align=\"center\">\n\n" + "<h2>Please enter the username for the customer account you wish to update</h2>\n\n" 
					+"<br><br>\n<fieldset>\n<legend>Enter username</legend>\n<form action=\"SpecialistOrderPPV\" method=\"post\">\n<br><br>" 
					+"Username:<input type=\"text\" name=\"username\">" + "\n<br>"
					+ "<input type=\"submit\" value=\"Submit\"" + "\n<br></form>" + "<br>\n</fieldset>\n</body></html>");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		HttpSession session = request.getSession();
		PassKeyBean pkb = (PassKeyBean)session.getAttribute("PassKey");
		String username = request.getParameter("username");
		int permissions = pkb.getPrivelege();
		if(permissions > 1){
			try{
				Customer cNew = (Customer)AccountManager.retrieveAccount(username);
				synchronized(session){
					session.setAttribute("Account", cNew);
				}
				response.sendRedirect("AddPPVSpecialist");
			}catch(Exception e){e.printStackTrace(); response.sendRedirect("SomethingWentWrong");}
		}
		if(permissions < 2){
			response.sendRedirect("InsufficientPermissions");
		}
	}
}