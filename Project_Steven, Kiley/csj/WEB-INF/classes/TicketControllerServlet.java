import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import accounts.TechnicalSupport;
import PublicUtils.Serializer;
import PublicUtils.AccountManager;
import java.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import PublicUtils.Ticket;

public class TicketControllerServlet extends HttpServlet{

public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		HttpSession session = request.getSession();
			String schedule = request.getParameter("schedule");
			String update = request.getParameter("update");
			String close = request.getParameter("close");
			String cancel = request.getParameter("cancel");
			TechnicalSupport tech = (TechnicalSupport)session.getAttribute("Tech");
			ConcurrentHashMap<String, Ticket> tickets = tech.getTickets();
			String input = "";
			String ticketID = request.getParameter("ticketID");
			Ticket t = tickets.get(ticketID);
			
			try{
				if(schedule != null){
					input = request.getParameter("scheduledate");
					t.setScheduledDate(input);
					
					Serializer.serialize("..\\webapps\\csj\\web-inf\\classes\\SerializedAccounts\\TechnicalSupport\\"+tech.getUsername()+".ser", tech);
					TechnicalSupport tNew = (TechnicalSupport)AccountManager.retrieveTechnician(tech.getUsername());
			
					synchronized(session){
						session.setAttribute("Account", tNew);
					}
					response.sendRedirect("TicketChangeSuccess");
				}//End of schedule case
			
				if(update != null){
					input = request.getParameter("updatetext");
					t.setTicketLog(input);
					
					Serializer.serialize("..\\webapps\\csj\\web-inf\\classes\\SerializedAccounts\\TechnicalSupport\\"+tech.getUsername()+".ser", tech);
					TechnicalSupport tNew = (TechnicalSupport)AccountManager.retrieveTechnician(tech.getUsername());
			
					synchronized(session){
						session.setAttribute("Account", tNew);
					}
					response.sendRedirect("TicketChangeSuccess");
				}//End of update case
			
				if(close != null){
					input = request.getParameter("finalremark");
					boolean test = tech.closeTicket(ticketID, input);
					if(test == true){
						Serializer.serialize("..\\webapps\\csj\\web-inf\\classes\\SerializedAccounts\\TechnicalSupport\\"+tech.getUsername()+".ser", tech);
						TechnicalSupport tNew = (TechnicalSupport)AccountManager.retrieveTechnician(tech.getUsername());
						
						synchronized(session){
							session.setAttribute("Account", tNew);
						}
						response.sendRedirect("TicketChangeSuccess");
					}
					if(test == false){response.sendRedirect("SomethingWentWrong");}
				}//End of close case
			
				if(cancel != null){
					tech.cancelTicket(ticketID);
					Serializer.serialize("..\\webapps\\csj\\web-inf\\classes\\SerializedAccounts\\TechnicalSupport\\"+tech.getUsername()+".ser", tech);
					TechnicalSupport tNew = (TechnicalSupport)AccountManager.retrieveTechnician(tech.getUsername());
			
					synchronized(session){
						session.setAttribute("Account", tNew);
					}
					response.sendRedirect("TicketChangeSuccess");
				}//End of cancel case
			}catch(Exception e){e.printStackTrace(); response.sendRedirect("SomethingWentWrong");}
	}
}	