package accounts;

import java.io.Serializable;
import java.util.ArrayList;
import services.RecurringService;
import services.SingleService;
import PublicUtils.Account;
import PublicUtils.AccountType;
import PublicUtils.CustomerData;

public class Customer implements Account, Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<RecurringService> recur;
	private ArrayList<SingleService> oneTime;
	private String username;
	private String password;
	private CustomerData personalInfo;
	
	public Customer(String name, String pw, CustomerData cd){
		this.username = name;
		this.password = pw;
		this.personalInfo = cd;
		this.recur = new ArrayList<RecurringService>();
		this.oneTime = new ArrayList<SingleService>();
	}
	
	public AccountType getType() {
		return AccountType.CUSTOMER;
	}

	public String getPassword() {
		return(password);
	}
	
	public String getUsername(){
		return(username);
	}
	
	public ArrayList<RecurringService> getRecur(){
		return(recur);
	}
	
	public ArrayList<SingleService> getOneTime(){
		return(oneTime);
	}
	
	public CustomerData getPersonalInfo(){
		return(personalInfo);
	}
	
	public void setRecurring(RecurringService s){
		recur.add(s);
	}
	
	public void setFullRecurring(ArrayList<RecurringService> list){
		this.recur = list;
	}
	
	public void setOneTime(SingleService s){
		oneTime.add(s);
	}
	
	public double totalDue(){
		double t = 0;
		RecurringService r = null;
		SingleService s = null;
		if(recur != null && !(recur.isEmpty())){
			for(int i = 0; i < recur.size(); i++){
			r = recur.get(i);
			if(r == null){System.out.println("Null object in Customer account");}
			System.out.println(r.getName());
			System.out.println(r.getDescription());
			t += r.getPrice();
			}
		}
		if(oneTime != null && !(oneTime.isEmpty())){
			for(int j = 0; j < oneTime.size(); j++){
			s = oneTime.get(j);
			t += s.getPrice();
			}
		}
		
		return t;
	}
	
}
