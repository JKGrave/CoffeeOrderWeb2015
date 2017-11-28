package kr.kosta.coffeeorder.domain;

import java.io.Serializable;
import java.util.Date;

/**제조용 주문내역*/
public class OrderList implements Serializable{

	private static final long serialVersionUID = 3534106673910099447L;

	private long id;
	private Member member;
	private Store store;
	private Payment payment;
	private Coffee coffee;
	private Code whipping;
	private Code syrup;
	private Code shot;
	private Code size;
	private Code temperature;
	private Code cup;
	private boolean payChk;
	private boolean receiveChk;
	private Date receiveTime;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public Coffee getCoffee() {
		return coffee;
	}
	public void setCoffee(Coffee coffee) {
		this.coffee = coffee;
	}
	
	public Code getWhipping() {
		return whipping;
	}
	public void setWhipping(Code whipping) {
		this.whipping = whipping;
	}
	
	public Code getSyrup() {
		return syrup;
	}
	public void setSyrup(Code syrup) {
		this.syrup = syrup;
	}
	
	public Code getShot() {
		return shot;
	}
	public void setShot(Code shot) {
		this.shot = shot;
	}
	
	public Code getSize() {
		return size;
	}
	public void setSize(Code size) {
		this.size = size;
	}
	
	public Code getTemperature() {
		return temperature;
	}
	public void setTemperature(Code temperature) {
		this.temperature = temperature;
	}
	
	public Code getCup() {
		return cup;
	}
	public void setCup(Code cup) {
		this.cup = cup;
	}
	
	public boolean isPayChk() {
		return payChk;
	}
	public void setPayChk(boolean payChk) {
		this.payChk = payChk;
	}
	
	public boolean isReceiveChk() {
		return receiveChk;
	}
	public void setReceiveChk(boolean receiveChk) {
		this.receiveChk = receiveChk;
	}
	
	public Date getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
	

	
}
