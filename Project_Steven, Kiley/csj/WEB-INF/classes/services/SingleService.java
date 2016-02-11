package services;

import java.io.Serializable;
import PublicUtils.Service;
import PublicUtils.ServiceType;
import java.util.Date;

public class SingleService implements Service, Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private double cost;
	private String description;
	ServiceType servType;
	Date eventDate;
	Date lastCancelDate;
	
	public SingleService(String n, String desc, double c, ServiceType st){
		this.name = n;
		this.description = desc;
		this.cost = c;
		this.servType = st;
		this.eventDate = null;
		this.lastCancelDate = null;
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
	
	public void setDate(Date d, Date lcd){
		eventDate = d;
		lastCancelDate = lcd;
	}
	
	public Date getEventDate(){
		return(eventDate);
	}
	
	public Date getLastCancelDate(){
		return(lastCancelDate);
	}
	
	
}
