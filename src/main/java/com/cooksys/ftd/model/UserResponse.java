package com.cooksys.ftd.model;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.ftd.entity.User;

public class UserResponse {
	
	private Long id;
	private String username;
	private String role;
	
	public UserResponse() {
		super();
	}

	public UserResponse(Long id, String username, String role) {
		super();
		this.id = id;
		this.username = username;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public static UserResponse get(User user) {
		if (user == null)
			return null;
		return new UserResponse(user.getId(), user.getUsername(), user.getRole().getRole());
	}
	
	public static List<UserResponse> getList(List<User> list) {
		List<UserResponse> userList = new ArrayList<>();
		for (User user : list) {
			userList.add(UserResponse.get(user));
		}
		return userList;
	}
	
}
