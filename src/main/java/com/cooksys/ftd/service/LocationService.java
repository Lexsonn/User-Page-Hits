package com.cooksys.ftd.service;

import java.util.List;

import com.cooksys.ftd.entity.Location;
import com.cooksys.ftd.entity.User;
import com.cooksys.ftd.model.RequestLocation;

public interface LocationService {
	// GET METHODS
	public Location getLocationById(Long id);
	public Location getLocationByName(String name);
	public Location getLocationByArea(Long area);
	public List<Location> getAllLocations();
	public List<User> getAllUsersByLocation(Long num);
	public String getConversionRateByLocation(Long num);
	// POST METHODS
	public Location createLocation(RequestLocation requestLocation);
	public Location addToLocation(RequestLocation requestLocation, Long n);
	
}
