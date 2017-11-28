package kr.kosta.coffeeorder.domain;

import java.io.Serializable;

public class Admin implements Serializable{

	private static final long serialVersionUID = -9198167109979550201L;
	
	private long id;
	private Store store;
	private String name;
	private String account;
	private String password;
	private String phoneNumber;
	private String email;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEqualPassword(String password){
		if(this.password.equals(password)){
			return true;
		}else{
			return false;
		}
	}
}
