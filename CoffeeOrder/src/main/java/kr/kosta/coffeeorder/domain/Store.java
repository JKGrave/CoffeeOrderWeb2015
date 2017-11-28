package kr.kosta.coffeeorder.domain;

import java.io.Serializable;

public class Store implements Serializable{

	private static final long serialVersionUID = 641353455452294594L;

	private long id;
	private String name;
	private String storeGuidance;
	private String contactNumber;
	private String location;
	private String businessHours;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStoreGuidance() {
		return storeGuidance;
	}
	public void setStoreGuidance(String storeGuidance) {
		this.storeGuidance = storeGuidance;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getBusinessHours() {
		return businessHours;
	}
	public void setBusinessHours(String businessHours) {
		this.businessHours = businessHours;
	}
	
	
}
