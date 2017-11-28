package kr.kosta.coffeeorder.dto;

import java.util.Date;

public class ArticleSearchCond extends SearchCond {

	private static final long serialVersionUID = -4180132060550846687L;

	private Long boardId;
	private Long storeId;
	
	public Long getBoardId() {
		return boardId;
	}
	public void setBoardId(Long boardId) {
		this.boardId = boardId;
	}
	
	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
	
}
