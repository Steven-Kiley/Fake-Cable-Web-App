package accounts;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import PublicUtils.Account;
import PublicUtils.AccountType;
import PublicUtils.Ticket;
import PublicUtils.Serializer;

public class TechnicalSupport implements Account, Serializable{
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private ConcurrentHashMap<String, Ticket> tickets;
	
	public TechnicalSupport(String n, String pw){
		this.username = n;
		this.password = pw;
		this.tickets = new ConcurrentHashMap<String, Ticket>();
		Ticket daily = new Ticket("Daily tasks from the technician's handbook.");
		this.tickets.put(daily.getID(), daily);
	}

	public AccountType getType() {
		return AccountType.TECHNICALSUPPORT;
	}

	public String getPassword() {
		return(password);
	}
	
	public ConcurrentHashMap<String, Ticket> getTickets(){
		return(tickets);
	}
	
	public String getUsername(){
		return(username);
	}
	
	public void setTicket(Ticket t){
		this.tickets.put(t.getID(), t);
	}
	
	
	public boolean closeTicket(String ticketID, String resolutionMessage){
		boolean result = false;
		Ticket temp = null;
		String filepath = "..\\webapps\\csj\\web-inf\\classes\\ResolvedTickets\\";
		if(tickets.containsKey(ticketID)){
			try{
				temp = tickets.get(ticketID);
				temp.setTicketLog(resolutionMessage);
				filepath += temp.getID() + "-" + getUsername() + ".ser";
				result = Serializer.serializeTicket(filepath, temp);
				if(result == true){
					tickets.remove(ticketID);
				}
			}catch(Exception e){e.printStackTrace();}
		}
		return result;
	}

	public void cancelTicket(String ticketID){
		tickets.remove(ticketID);
	}
	
}
