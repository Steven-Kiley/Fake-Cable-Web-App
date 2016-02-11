package PublicUtils;

import accounts.TechnicalSupport;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import PublicUtils.Account;
import PublicUtils.Unserializer;
import PublicUtils.Ticket;
import java.io.IOException;
import PublicUtils.Serializer;

public class TicketMaker{
	public static String createTicket(String desc) throws ClassNotFoundException, IOException{
		HashMap<String, Account> map = getHashMap();
		Set keys = map.keySet();
		ConcurrentHashMap<String, Ticket> tickets = null;
		Iterator it = keys.iterator();
		TechnicalSupport tech = null;
		String techChoice = "";
		int lowCount = 0;
		String temp = "";
		//Setup
		temp = (String)it.next();
		techChoice = temp;
		tech = (TechnicalSupport)map.get(temp);
		tickets = tech.getTickets();
		lowCount = tickets.size();
		//loop
		while(it.hasNext()){
			temp = (String)it.next();
			tech = (TechnicalSupport)map.get(temp);
			tickets = tech.getTickets();
			if(tickets.size() < lowCount){lowCount = tickets.size(); techChoice = temp;}
		}
		tech = (TechnicalSupport)map.get(techChoice);
		Ticket newTicket = new Ticket(desc);
		tech.setTicket(newTicket);
		String sendMe = newTicket.getID() + "-" + tech.getUsername();
		String filepath = "..\\webapps\\csj\\web-inf\\classes\\SerializedAccounts\\TechnicalSupport\\" + tech.getUsername() + ".ser";
		Serializer.serialize(filepath, tech);
		return sendMe;
	}
	
	private static HashMap<String, Account> getHashMap() throws IOException, ClassNotFoundException{
		HashMap<String, Account> map = Unserializer.deserializeDirectory("..\\webapps\\csj\\web-inf\\classes\\SerializedAccounts\\TechnicalSupport");
		return map;
	}
	
}