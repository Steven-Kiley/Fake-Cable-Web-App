package PublicUtils;

import java.io.Serializable;

public class CustomerData implements Serializable{
	private static final long serialVersionUID = 1L;
	private String street;
	private String city;
	private String state;
	private int zip;
	private int creditCardNum;
	private String creditCardExp;
	
	public String getStreet(){
		return(street);
	}
	
	public void setStreet(String st){
		this.street = st;
	}
	
	public String getCity(){
		return(city);
	}
	
	public void setCity(String c){
		this.city = c;
	}
	
	public String getState(){
		return(state);
	}
	
	public void setState(String s){
		this.state = s;
	}
	
	public int getZip(){
		return(zip);
	}
	
	public void setZip(int z){
		this.zip = z;
	}
	
	public int getCreditCardNum(){
		return(creditCardNum);
	}
	
	public void setCreditCardNum(int ccn){
		this.creditCardNum = ccn;
	}
	
	public String getCreditCardExp(){
		return(creditCardExp);
	}
	
	public void setCreditCardExp(String exp){
		this.creditCardExp = exp;
	}
	
}
