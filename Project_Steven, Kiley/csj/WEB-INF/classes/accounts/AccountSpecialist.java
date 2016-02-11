package accounts;

import java.io.Serializable;
import PublicUtils.Account;
import PublicUtils.AccountType;

public class AccountSpecialist implements Account, Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	public AccountSpecialist(String un, String pw){
		this.username = un;
		this.password = pw;
	}
	
	public AccountType getType() {
		return AccountType.ACCOUNTSPECIALIST;
	}

	public String getPassword() {
		return(password);
	}
	
	public String getUsername(){
		return(username);
	}

}
