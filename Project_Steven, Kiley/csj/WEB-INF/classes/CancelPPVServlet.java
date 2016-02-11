import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import accounts.Customer;
import PublicUtils.Serializer;
import PublicUtils.AccountManager;
import services.*;
import PublicUtils.ServiceType;
import java.util.ArrayList;
import java.util.Date;

public class CancelPPVServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		HttpSession session = request.getSession();
		
		try{
			Customer c = (Customer)session.getAttribute("Account");
			String eventChoice = request.getParameter("eventchoice");
			Date lastCancelDate = null;
			Date today = new Date();
			ArrayList<SingleService> services = c.getOneTime();
			SingleService temp = null;
			//System.out.println(movieChoice);
			//System.out.println(sportsChoice);
			
			if(!(eventChoice.equals("none"))){
				for(int i = 0; i < services.size(); i++){
					temp = services.get(i);
					if(temp.getName().equals(eventChoice)){
						lastCancelDate = temp.getLastCancelDate();
						boolean test = lastCancelDate.after(today);
						if(test == true){
							services.remove(i);
							Serializer.serialize("..\\webapps\\csj\\web-inf\\classes\\SerializedAccounts\\Customer\\"+c.getUsername()+".ser", c);
							Customer cNew = (Customer)AccountManager.retrieveAccount(c.getUsername());
							synchronized(session){
								session.setAttribute("Account", cNew);
							}
							response.sendRedirect("CancelPPVSuccess");
						}
						if(test == false){
							response.setContentType("text/html");
							PrintWriter out = response.getWriter();
							out.println("<html>\n<body align=\"center\">\n\n" + "<h1>Cannot cancel PPV Event:</h1>\n<br><br>\n" + "<h3>Event in less than 24 hours. Must allow more than 24 hours to cancel event orders.</h3>"
										+ "\n\n<br><br>\n\n" + "<form action=\"CustomerLogin\">\n<br><input type=\"submit\" value=\"Return to Home\">\n</form><br><br>"
										+ "</body>\n</html>");
						}
					}
				}
			}
		
			
		}catch(Exception e){e.printStackTrace(); response.sendRedirect("SomethingWentWrong");}
		
	}
}