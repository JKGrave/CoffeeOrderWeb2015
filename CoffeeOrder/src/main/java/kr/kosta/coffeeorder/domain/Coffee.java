package kr.kosta.coffeeorder.domain;

import java.io.Serializable;

public class Coffee implements Serializable{

	private static final long serialVersionUID = -185970354606153260L;

	private long id;
	private String name;
	private String productInfo;
	private int price;
	
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
	
	public String getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
