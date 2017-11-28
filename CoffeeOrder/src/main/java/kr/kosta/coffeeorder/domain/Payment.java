package kr.kosta.coffeeorder.domain;

import java.io.Serializable;

public class Payment implements Serializable{

	
	private static final long serialVersionUID = -2066579814337764016L;
	
	private long id;
	private String name;
	
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
}
