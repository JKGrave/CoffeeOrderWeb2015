package kr.kosta.coffeeorder.domain;

import java.io.Serializable;

public class PreferenceCoffee implements Serializable{

	private static final long serialVersionUID = -2302787014391827065L;

	private long id;
	private long coffeeId;
	private long memberId;
	private int whipping;
	private int syrup;
	private int shot;
	private int size;
	private String temperature;
	private String cup;
	
	public String getCup()
	{
		return cup;
	}
	public void setCup(String cup)
	{
		this.cup = cup;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public long getCoffeeId() {
		return coffeeId;
	}
	public void setCoffeeId(long coffeeId) {
		this.coffeeId = coffeeId;
	}
	
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	
	public int getWhipping() {
		return whipping;
	}
	public void setWhipping(int whipping) {
		this.whipping = whipping;
	}
	
	public int getSyrup() {
		return syrup;
	}
	public void setSyrup(int syrup) {
		this.syrup = syrup;
	}
	
	public int getShot() {
		return shot;
	}
	public void setShot(int shot) {
		this.shot = shot;
	}

	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	
}
