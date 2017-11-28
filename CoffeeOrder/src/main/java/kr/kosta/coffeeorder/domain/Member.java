package kr.kosta.coffeeorder.domain;

import java.io.Serializable;
import java.util.List;

public class Member implements Serializable {

	private static final long serialVersionUID = -2026648995239910519L;

	private long id;
	private String name;
	private String deviceId;
	private String password;
	private String phoneNumber;
	private long point;
	private long mileage;
	private Long discountCard;
	private Long preferenceStore;
	private List<PreferenceCoffee> preferenceCoffee;
//	private List<Coupon> coupon;

	

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



	public String getDeviceId() {
		return deviceId;
	}



	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public long getPoint() {
		return point;
	}



	public void setPoint(long point) {
		this.point = point;
	}



	public long getMileage() {
		return mileage;
	}



	public void setMileage(long mileage) {
		this.mileage = mileage;
	}
	
	public Long getDiscountCard() {
		return discountCard;
	}
	
	public void setDiscountCard(Long discountCard) {
		this.discountCard = discountCard;
	}

	public Long getPreferenceStore() {
		return preferenceStore;
	}

	public void setPreferenceStore(Long preferenceStore) {
		this.preferenceStore = preferenceStore;
	}

	public List<PreferenceCoffee> getPreferenceCoffee() {
		return preferenceCoffee;
	}



	public void setPreferenceCoffee(List<PreferenceCoffee> preferenceCoffee) {
		this.preferenceCoffee = preferenceCoffee;
	}



//	public List<Coupon> getCoupon() {
//		return coupon;
//	}
//
//
//
//	public void setCoupon(List<Coupon> coupon) {
//		this.coupon = coupon;
//	}


	public boolean isEqualPassword(String password)
	{
		if(this.password.equals(password))
			return true;
		return false;
	}

}
