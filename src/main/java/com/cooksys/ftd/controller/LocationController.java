package com.cooksys.ftd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.ftd.entity.Location;
import com.cooksys.ftd.entity.User;
import com.cooksys.ftd.model.LocationResponse;
import com.cooksys.ftd.model.RequestLocation;
import com.cooksys.ftd.model.UserResponse;
import com.cooksys.ftd.service.LocationService;

@RestController
@RequestMapping("locations")
public class LocationController {

	@Autowired
	LocationService locationService;
	
	@RequestMapping(method=RequestMethod.POST)
	public LocationResponse createLocation(@RequestBody RequestLocation requestLocation) {
		return LocationResponse.get(locationService.addToLocation(requestLocation, (long)1));
	}
	
	// What's up?
	@RequestMapping(method=RequestMethod.GET)
	public List<LocationResponse> getAllLocations() {
		return LocationResponse.getList(locationService.getAllLocations());
	}
	
	@RequestMapping(value="/{id}")
	public LocationResponse getLocation(@PathVariable Long id) {
		return LocationResponse.get(locationService.getLocationById(id));
	}
	
	@RequestMapping(value="{id}/users")
	public List<UserResponse> getUsersByLocation(@PathVariable Long id) {
		return UserResponse.getList(locationService.getAllUsersByLocation(id));
	}
	
	@RequestMapping(value="{id}/stats")
	public String getLocationConversion(@PathVariable Long id) {
		return locationService.getConversionRateByLocation(id);
	}
	
	@RequestMapping(value="area/{area}")
	public LocationResponse getLocationByArea(@PathVariable Long area) {
		return LocationResponse.get(locationService.getLocationByArea(area));
	}
	
	@RequestMapping(value="name/{name}")
	public LocationResponse getLocationByName(@PathVariable String name) {
		return LocationResponse.get(locationService.getLocationByName(name));
	}
}
