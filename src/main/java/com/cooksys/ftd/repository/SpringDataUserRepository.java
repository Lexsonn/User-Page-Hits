package com.cooksys.ftd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.ftd.entity.User;

public interface SpringDataUserRepository extends JpaRepository<User, Long> {
	
	public User findByUsername(String name);
	public List<User> findByNum(Long num);
	
}
