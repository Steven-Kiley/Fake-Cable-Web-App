package Beans;

import PublicUtils.AccountType;

public class PassKeyBean {
	private String username;
	private int privelege;
	
	public String getUsername(){
		return(username);
	}
	
	public void setUsername(String un){
		this.username = un;
	}
	
	public int getPrivelege(){
		return(privelege);
	}
	
	public void setPrivelege(AccountType at){
		if(at == AccountType.CUSTOMER){this.privelege = 0;}
		if(at == AccountType.TECHNICALSUPPORT){this.privelege = 1;}
		if(at == AccountType.ACCOUNTSPECIALIST){this.privelege = 2;}
		if(at == AccountType.MANAGER){this.privelege = 3;}
	}
}
