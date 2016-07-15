package com.cooksys.ftd.model;

public class RequestLocation {
	
	private String title;
	private Long num;
	
	public RequestLocation() {
		super();
	}
	
	public RequestLocation(String title, Long num) {
		super();
		this.title = title;
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}
	
}
