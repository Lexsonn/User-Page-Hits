package com.cooksys.ftd.model;

public class RequestUser {
	
	private String name;
	private String pass;
	private Long num;
	
	public RequestUser() {
		super();
	}

	public RequestUser(String name, String pass, Long num) {
		super();
		this.name = name;
		this.pass = pass;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}
	
}
