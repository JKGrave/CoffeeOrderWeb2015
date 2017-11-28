package kr.kosta.coffeeorder.domain;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable{

	private static final long serialVersionUID = -4573916055933589631L;

	private long id;
	private long boardId;
	private String boardName;
	private String title;
	private String contents;
	private int readCount;
	private Date createDate;
	private Store writer;
	
	public long getId() {
		return id;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public long getBoardId() {
		return boardId;
	}
	public void setBoardId(long boardId) {
		this.boardId = boardId;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Store getWriter() {
		return writer;
	}
	public void setWriter(Store writer) {
		this.writer = writer;
	}
	
	
}
