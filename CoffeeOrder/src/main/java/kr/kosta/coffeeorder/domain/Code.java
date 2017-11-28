package kr.kosta.coffeeorder.domain;

import java.io.Serializable;

public class Code implements Serializable{

	private static final long serialVersionUID = 647283525874408955L;
	
	private String groupCode;
	private String code;
	private String name;
	
	public String getGroupCode() {
		return groupCode;
	}
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
