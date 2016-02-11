package PublicUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import services.RecurringService;
import services.Services;
import services.SingleService;
import Beans.PassKeyBean;
import accounts.AccountSpecialist;
import accounts.Customer;
import accounts.Manager;
import accounts.TechnicalSupport;
import services.*;
import java.util.concurrent.ConcurrentHashMap;

public class AccountManager{
	public static void main(String[] args){
		
		HashMap<String, SingleService> singles = Services.getSingles();
		HashMap<String, RecurringService> recurs = Services.getRecurs();
		
		
		//Generate CustomerData objects for customer accounts
		CustomerData cd1 = new CustomerData();
		cd1.setStreet("123 Fake St"); cd1.setCity("Chicago"); cd1.setState("IL"); cd1.setZip(60645); cd1.setCreditCardNum(123456789); cd1.setCreditCardExp("12/21/18");
		
		CustomerData cd2 = new CustomerData();
		cd2.setStreet("555 Real St"); cd2.setCity("Chicago"); cd2.setState("IL"); cd2.setZip(60601); cd2.setCreditCardNum(852147969); cd2.setCreditCardExp("8/1/17");
		
		CustomerData cd3 = new CustomerData();
		cd3.setStreet("1734 34th St"); cd3.setCity("Chicago"); cd3.setState("IL"); cd3.setZip(60640); cd3.setCreditCardNum(125962369); cd3.setCreditCardExp("5/14/16");
		
		CustomerData cd4 = new CustomerData();
		cd4.setStreet("1745 Lake St"); cd4.setCity("Wilmette"); cd4.setState("IL"); cd4.setZip(60091); cd4.setCreditCardNum(123496789); cd4.setCreditCardExp("10/7/18");
		
		CustomerData cd5 = new CustomerData();
		cd5.setStreet("999 Foster Ave"); cd5.setCity("Chicago"); cd5.setState("IL"); cd5.setZip(60056); cd5.setCreditCardNum(668520045); cd5.setCreditCardExp("2/29/17");
		
		//Create customer objects
		Customer c1 = new Customer("MightyJoe", "goJoe123!", cd1);
		c1.setRecurring(recurs.get("Basic-Package"));
		c1.setRecurring(recurs.get("Speedlane-Internet"));
		c1.setOneTime(singles.get("Hammer_Hands_the_Game"));
		
		Customer c2 = new Customer("LizzyBorden", "axe2grind", cd2);
		c2.setRecurring(recurs.get("Basic-Plus-Package"));
		c2.setRecurring(recurs.get("Lightlane-Internet"));
		c2.setOneTime(singles.get("The_Deer_Chaser"));
		c2.setOneTime(singles.get("Orc"));
		
		Customer c3 = new Customer("Gretel345", "l0stinDaW00d$", cd3);
		c3.setRecurring(recurs.get("Basic-Package"));
		c3.setRecurring(recurs.get("Speedlane-Internet"));
		c3.setOneTime(singles.get("Hammer_Hands"));
		c3.setOneTime(singles.get("Cats"));
		c3.setOneTime(singles.get("NBA_Finals_round_1"));
		c3.setOneTime(singles.get("NBA_Finals_round_2"));
		
		Customer c4 = new Customer("Zeus", "thundergod123", cd4);
		c4.setRecurring(recurs.get("Ultimate-Package"));
		c4.setOneTime(singles.get("NHL_Finals_round_1"));
		
		Customer c5 = new Customer("TitusAndromedon", "pinotNoir", cd5);
		c5.setRecurring(recurs.get("Lightlane-Internet"));
		c5.setOneTime(singles.get("Call_of_Snooty"));
		
		//Serialize customers
		Serializer.serialize(".\\SerializedAccounts\\Customer\\"+c1.getUsername()+".ser", c1);
		Serializer.serialize(".\\SerializedAccounts\\Customer\\"+c2.getUsername()+".ser", c2);
		Serializer.serialize(".\\SerializedAccounts\\Customer\\"+c3.getUsername()+".ser", c3);
		Serializer.serialize(".\\SerializedAccounts\\Customer\\"+c4.getUsername()+".ser", c4);
		Serializer.serialize(".\\SerializedAccounts\\Customer\\"+c5.getUsername()+".ser", c5);
		
		//Generate 2 managers 
		Manager m1 = new Manager("BigBoss", "superImportantGuy");
		Manager m2 = new Manager("littleboss", "lessImportantGuy");
		
		//Serialize managers
		Serializer.serialize(".\\SerializedAccounts\\Manager\\"+m1.getUsername()+".ser", m1);
		Serializer.serialize(".\\SerializedAccounts\\Manager\\"+m2.getUsername()+".ser", m2);
		
		//Generate 3 techies
		TechnicalSupport t1 = new TechnicalSupport("tech1", "mrFixit");
		TechnicalSupport t2 = new TechnicalSupport("tech2", "mrsFixit");
		TechnicalSupport t3 = new TechnicalSupport("tech3", "babyFixit");
		
		//Generate tickets for techies
		Ticket tick1 = new Ticket("Mrs Zavaterro having issues with fuzzy reception on her TV.");
		Ticket tick2 = new Ticket("Low internet connectivity for Zeus.");
		Ticket tick3 = new Ticket("Channel 45 not coming in for Lizzy Borden.");
		Ticket tick4 = new Ticket("Channel 99 fuzzy for Bo Jackson.");
		Ticket tick5 = new Ticket("Zeus unable to play game rental.");
		//Assign tickets to techies
		t1.setTicket(tick1);
		t1.setTicket(tick2);
		t1.setTicket(tick3);
		t2.setTicket(tick4);
		t2.setTicket(tick5);
		
		//Serialize techies
		Serializer.serialize(".\\SerializedAccounts\\TechnicalSupport\\"+t1.getUsername()+".ser", t1);
		Serializer.serialize(".\\SerializedAccounts\\TechnicalSupport\\"+t2.getUsername()+".ser", t2);
		Serializer.serialize(".\\SerializedAccounts\\TechnicalSupport\\"+t3.getUsername()+".ser", t3);
		
		//Generate 3 account specialists
		AccountSpecialist a1 = new AccountSpecialist("becky", "iLoveCable");
		AccountSpecialist a2 = new AccountSpecialist("andy", "iHateCable");
		AccountSpecialist a3 = new AccountSpecialist("ollie", "cablecable");
		
		
		//Serialize account specialists
		Serializer.serialize(".\\SerializedAccounts\\AccountSpecialist\\"+a1.getUsername()+".ser", a1);
		Serializer.serialize(".\\SerializedAccounts\\AccountSpecialist\\"+a2.getUsername()+".ser", a2);
		Serializer.serialize(".\\SerializedAccounts\\AccountSpecialist\\"+a3.getUsername()+".ser", a3);
	
	}
	
	public static PassKeyBean checkLogIn(AccountType act, String un, String pw) throws ClassNotFoundException, IOException{
		PassKeyBean pkb = new PassKeyBean();
		if(act == AccountType.CUSTOMER){
			HashMap<String, Account> customers = Unserializer.deserializeDirectory("..\\webapps\\csj\\web-inf\\classes\\SerializedAccounts\\Customer");
			Customer ct = (Customer)customers.get(un);
			if(ct == null || !(pw.equals(ct.getPassword()))){pkb.setUsername("INVALID");}
			else{pkb.setUsername(un); pkb.setPrivelege(act);}
		}
		if(act == AccountType.MANAGER){
			HashMap<String, Account> managers = Unserializer.deserializeDirectory("..\\webapps\\csj\\web-inf\\classes\\SerializedAccounts\\Manager");
			Manager mg = (Manager)managers.get(un);
			if(mg == null || !(pw.equals(mg.getPassword()))){pkb.setUsername("INVALID");}
			else{pkb.setUsername(un); pkb.setPrivelege(act);}
		}
		if(act == AccountType.ACCOUNTSPECIALIST){
			HashMap<String, Account> acctSpecs = Unserializer.deserializeDirectory("..\\webapps\\csj\\web-inf\\classes\\SerializedAccounts\\AccountSpecialist");
			AccountSpecialist as = (AccountSpecialist)acctSpecs.get(un);
			if(as == null || !(pw.equals(as.getPassword()))){pkb.setUsername("INVALID");}
			else{pkb.setUsername(un); pkb.setPrivelege(act);}
		}
		if(act == AccountType.TECHNICALSUPPORT){
			HashMap<String, Account> techies = Unserializer.deserializeDirectory("..\\webapps\\csj\\web-inf\\classes\\SerializedAccounts\\TechnicalSupport");
			TechnicalSupport tech = (TechnicalSupport)techies.get(un);
			if(tech == null || !(pw.equals(tech.getPassword()))){pkb.setUsername("INVALID");}
			else{pkb.setUsername(un); pkb.setPrivelege(act);}
		}
		return pkb;
	}
	
	public static Customer retrieveAccount(String un) throws ClassNotFoundException, IOException{
		HashMap<String, Account> customers = Unserializer.deserializeDirectory("..\\webapps\\csj\\web-inf\\classes\\SerializedAccounts\\Customer");
		if(customers.isEmpty()){System.out.println("Empty HashMap in AccountManager");}
		Customer ct = (Customer)customers.get(un);
		if(ct == null){System.out.println("Null Customer object in AccountManager.");}
		ArrayList<RecurringService> rr = ct.getRecur();
		if(rr == null){System.out.println("Null arraylist");}
		RecurringService rs = null;
		for(int i = 0; i < rr.size(); i++){
			rs = rr.get(i);
			if(rs == null){System.out.println("Null object in AccountManager");}
		}
		return ct;
	}
	
	public static TechnicalSupport retrieveTechnician(String un) throws ClassNotFoundException, IOException{
		HashMap<String, Account> techs = Unserializer.deserializeDirectory("..\\webapps\\csj\\web-inf\\classes\\SerializedAccounts\\TechnicalSupport");
		if(techs.isEmpty()){System.out.println("Empty HashMap in AccountManager");}
		TechnicalSupport t = (TechnicalSupport)techs.get(un);
		if(t == null){System.out.println("Null TechnicalSupport object in AccountManager.");}
		return t;
	}
}