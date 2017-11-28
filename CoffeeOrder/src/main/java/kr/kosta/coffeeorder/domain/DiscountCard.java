package kr.kosta.coffeeorder.domain;

import java.io.Serializable;

public class DiscountCard implements Serializable {

	private static final long serialVersionUID = -4588940148755231793L;
	
	private long id;
	private String cardName;
	private int discountRate;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public int getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
}
