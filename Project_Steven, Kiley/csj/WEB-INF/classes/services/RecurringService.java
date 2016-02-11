package services;

import java.io.Serializable;
import PublicUtils.Service;
import PublicUtils.ServiceType;

public class RecurringService implements Service, Serializable {
	private static final long serialVersionUID = 1L;
	private double cost;
	private String name;
	private String description;
	ServiceType servType;
	
	public RecurringService(String n, String desc, double c, ServiceType st){
		this.name = n;
		this.description = desc;
		this.cost = c;
		this.servType = st;
	}
	
	public ServiceType getType() {
		return(servType);
	}
	
	public double getPrice() {
		return this.cost;
	}
	
	public String getDescription(){
		return(description);
	}
	
	public String getName(){
		return(name);
	}
}
