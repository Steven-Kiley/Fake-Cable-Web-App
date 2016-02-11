package accounts;

import java.io.Serializable;
import PublicUtils.Account;
import PublicUtils.AccountType;

public class Manager implements Account, Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	public Manager(String un, String pw){
		this.username = un;
		this.password = pw;
	}
	
	public AccountType getType() {
		return AccountType.MANAGER;
	}

	public String getPassword() {
		return(password);
	}
	
	public String getUsername(){
		return(username);
	}

}
