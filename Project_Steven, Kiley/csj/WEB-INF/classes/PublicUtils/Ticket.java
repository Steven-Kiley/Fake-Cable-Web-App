package PublicUtils;

import java.util.Date;
import java.util.Random;
import java.util.ArrayList;
import java.io.Serializable;

public class Ticket implements Serializable{
	private String ID;
	private String description;
	private Date startDate;
	private String scheduledDate;
	private ArrayList<String> ticketLog;
	
	public Ticket(String desc){
		this.description = desc;
		this.ID = generateID();
		this.startDate = new Date(System.currentTimeMillis());
		this.scheduledDate = "N/A";
		this.ticketLog = new ArrayList<String>();
		setTicketLog(desc);
	}

	private String generateID() {
		char[] alphabet = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		Random rand= new Random();
		StringBuilder x = new StringBuilder();
		int size = alphabet.length;
		x.append(rand.nextInt(500)).append(alphabet[rand.nextInt(size)]).append(rand.nextInt(500)).append(alphabet[rand.nextInt(size)]).append(alphabet[rand.nextInt(size)]).append(alphabet[rand.nextInt(size)]);
		return x.toString();
	}
	
	public String getID(){
		return(ID);
	}
	
	public String getDescription(){
		return(description);
	}
	
	public Date getStartDate(){
		return(startDate);
	}
	
	public String getScheduledDate(){
		return(scheduledDate);
	}
	
	public void setScheduledDate(String sd){
		this.scheduledDate = sd;
	}
	
	public ArrayList<String> getTicketLog(){
		return(ticketLog);
	}
	
	public void setTicketLog(String message){
		Date timestamp = new Date(System.currentTimeMillis());
		message += " - " + "TIMESTAMP: " + timestamp.toString();
		this.ticketLog.add(message);
	}
	
}
