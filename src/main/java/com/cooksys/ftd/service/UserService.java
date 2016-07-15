package com.cooksys.ftd.service;

import java.util.List;

import com.cooksys.ftd.entity.User;
import com.cooksys.ftd.model.RequestUser;

public interface UserService {
	// GET METHODS
	public User getUserById(Long id);
	public User getUserByUsername(String name);
	public List<User> getAllUsers();
	// POST METHODS
	public User login(RequestUser requestUser);
	public User createUser(RequestUser requestUser);
	
}
