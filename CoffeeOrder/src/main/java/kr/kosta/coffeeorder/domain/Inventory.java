package kr.kosta.coffeeorder.domain;

import java.io.Serializable;


/**재고현황*/
public class Inventory implements Serializable{

	private static final long serialVersionUID = -8101584643919813254L;

	private long id;
	private long storeId;
	private String name;
	private int amount;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public long getStoreId() {
		return storeId;
	}
	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
