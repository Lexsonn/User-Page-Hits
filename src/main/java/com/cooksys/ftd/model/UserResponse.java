package com.cooksys.ftd.model;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.ftd.entity.User;

public class UserResponse {
	
	private Long id;
	private String username;
	
	public UserResponse() {
		super();
	}

	public UserResponse(Long id, String username) {
		super();
		this.id = id;
		this.username = username;
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
	
	public static UserResponse get(User user) {
		if (user == null)
			return null;
		return new UserResponse(user.getId(), user.getUsername());
	}
	
	public static List<UserResponse> getList(List<User> list) {
		List<UserResponse> userList = new ArrayList<>();
		for (User user : list) {
			userList.add(UserResponse.get(user));
		}
		return userList;
	}
	
}
