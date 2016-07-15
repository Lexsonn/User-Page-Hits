package com.cooksys.ftd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.ftd.entity.Location;
import com.cooksys.ftd.entity.User;
import com.cooksys.ftd.model.RequestUser;
import com.cooksys.ftd.repository.SpringDataLocationRepository;
import com.cooksys.ftd.repository.SpringDataUserRepository;
import com.cooksys.ftd.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	SpringDataUserRepository userRepo;
	@Autowired
	SpringDataLocationRepository locRepo;

	@Override
	public User getUserById(Long id) {
		return userRepo.findOne(id);
	}

	@Override
	public User getUserByUsername(String name) {
		return userRepo.findByUsername(name);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User login(RequestUser requestUser) {
		User onFile = getUserByUsername(requestUser.getName());
		User toLogin = new User();
		toLogin.setUsername(requestUser.getName());
		toLogin.setPassword(requestUser.getPass());
		
		if (verifyUser(toLogin, onFile)) {
			return onFile;
		}
		
		return null;
	}

	@Override
	public User createUser(RequestUser requestUser) {
		User user = checkExisting(requestUser);
		if (user != null) {
			userRepo.save(user);
		}
		return user;
	}
	
	private User checkExisting(RequestUser requestUser) {
		User existing = getUserByUsername(requestUser.getName());
		
		if (existing == null) {
			User user = new User();
			user.setUsername(requestUser.getName());
			user.setPassword(requestUser.getPass());
			user.setNum(requestUser.getNum());
			return user;
		}
		
		return null;
	}
	
	private boolean verifyUser(User toLogin, User onFile) {
		if (toLogin == null || onFile == null)
			return false;
		return (toLogin.getUsername().equals(onFile.getUsername()) && toLogin.getPassword().equals(onFile.getPassword()));
	}

}
