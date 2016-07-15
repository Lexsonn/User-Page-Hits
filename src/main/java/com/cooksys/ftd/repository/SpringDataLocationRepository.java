package com.cooksys.ftd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.ftd.entity.Location;

public interface SpringDataLocationRepository  extends JpaRepository<Location, Long> {

	Location findByName(String name);
	Location findByArea(Long area);
	
}
