package com.cooksys.ftd.controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.ftd.model.LocationResponse;
import com.cooksys.ftd.model.RequestLocation;
import com.cooksys.ftd.model.UserResponse;
import com.cooksys.ftd.service.LocationService;

@RestController
@RequestMapping("locations")
public class LocationController {
	//private Logger log = LoggerFactory.getLogger(LocationController.class);
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
	
	@RequestMapping(value="day", method=RequestMethod.GET)
	public List<LocationResponse> getAllLocationsByDay() throws ParseException {
		return LocationResponse.getList(locationService.getAllLocationsByDaysNum(0L));
	}
	
	@RequestMapping(value="week", method=RequestMethod.GET)
	public List<LocationResponse> getAllLocationsByWeek() throws ParseException {
		return LocationResponse.getList(locationService.getAllLocationsByDaysNum(7L));
	}
	
	@RequestMapping(value="month", method=RequestMethod.GET)
	public List<LocationResponse> getAllLocationsByMonth() throws ParseException {
		return LocationResponse.getList(locationService.getAllLocationsByDaysNum(30L));
	}
	
	@RequestMapping(value="year", method=RequestMethod.GET)
	public List<LocationResponse> getAllLocationsByYear() throws ParseException {
		return LocationResponse.getList(locationService.getAllLocationsByDaysNum(360L));
	}
	
	@RequestMapping(value="day/{id}", method=RequestMethod.GET)
	public LocationResponse getLocationByDay(@PathVariable("id") Long id) throws ParseException {
		return LocationResponse.get(locationService.getLocationByDaysNum(id, 0L));
	}
	
	@RequestMapping(value="week/{id}", method=RequestMethod.GET)
	public LocationResponse getLocationByWeek(@PathVariable Long id) throws ParseException {
		return LocationResponse.get(locationService.getLocationByDaysNum(id, 7L));
	}
	
	@RequestMapping(value="month/{id}", method=RequestMethod.GET)
	public LocationResponse getLocationByMonth(@PathVariable Long id) throws ParseException {
		return LocationResponse.get(locationService.getLocationByDaysNum(id, 30L));
	}
	
	@RequestMapping(value="year/{id}", method=RequestMethod.GET)
	public LocationResponse getLocationByYear(@PathVariable Long id) throws ParseException {
		return LocationResponse.get(locationService.getLocationByDaysNum(id, 360L));
	}
//	@RequestMapping(method=RequestMethod.GET)
//	public List<Location> getAllLocations() {
//		return locationService.getAllLocations();
//	}
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
