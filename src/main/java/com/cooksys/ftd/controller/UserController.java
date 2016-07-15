package com.cooksys.ftd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.ftd.entity.User;
import com.cooksys.ftd.model.RequestLocation;
import com.cooksys.ftd.model.RequestUser;
import com.cooksys.ftd.model.UserResponse;
import com.cooksys.ftd.model.MessageResponse;
import com.cooksys.ftd.service.LocationService;
import com.cooksys.ftd.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	UserService userService;
	@Autowired
	LocationService locationService;
	
	@RequestMapping(method=RequestMethod.POST)
	public MessageResponse<UserResponse> createUser(@RequestBody RequestUser requestUser) {
		locationService.addToLocation(new RequestLocation(null, requestUser.getNum()), (long)1);
		User user = userService.createUser(requestUser);
		String message = "User succesfully created!";
		if (user == null)
			message = "Error! User already exists.";
		
		return new MessageResponse<UserResponse>(message, UserResponse.get(user));
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(value="/{id}")
	public User getUser(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@RequestMapping(value="name/{name}")
	public User getUserByName(@PathVariable String name) {
		return userService.getUserByUsername(name);
	}
	
	@RequestMapping(value="login")
	public MessageResponse<UserResponse> loginUser(@RequestBody RequestUser requestUser) {
		User user = userService.login(requestUser);
		String message = "Login successful!";
		if (user == null)
			message = "Username or password is incorrect.";
		else
			locationService.addToLocation(new RequestLocation(null, requestUser.getNum()), (long)-1);
		
		return new MessageResponse<UserResponse>(message, UserResponse.get(user));
	}

}
