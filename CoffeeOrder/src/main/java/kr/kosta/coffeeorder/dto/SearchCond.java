package kr.kosta.coffeeorder.dto;

import java.io.Serializable;

public abstract class SearchCond implements Serializable{
	
	private static final long serialVersionUID = 6006636221640576848L;
	
	protected int showPageNum = 5;
	
	protected int page = 1;
	protected int limit = 10;
	protected int startPage;
	protected int endPage;
	
	

	public int getShowPageNum() {
		return showPageNum;
	}
	
	public void setShowPageNum(int showPageNum) {
		this.showPageNum = showPageNum;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getOffset() {
		return (page - 1) * limit;
	}
}
