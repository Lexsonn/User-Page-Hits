package com.cooksys.ftd.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.ftd.CurrentDay;
import com.cooksys.ftd.entity.HitsPerDay;
import com.cooksys.ftd.entity.Location;
import com.cooksys.ftd.entity.User;
import com.cooksys.ftd.model.RequestLocation;
import com.cooksys.ftd.repository.SpringDataLocationRepository;
import com.cooksys.ftd.repository.SpringDataUserRepository;
import com.cooksys.ftd.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	SpringDataUserRepository userRepo;
	@Autowired
	SpringDataLocationRepository locRepo;
	
	@Override
	public Location getLocationById(Long id) {
		return locRepo.findOne(id);
	}
	
	@Override
	public Location getLocationByArea(Long area) {
		return locRepo.findByArea(area);
	}

	@Override
	public Location getLocationByName(String name) {
		return locRepo.findByName(name);
	}

	@Override
	public List<Location> getAllLocations() {
		return locRepo.findAll();
	}

	@Override
	public List<User> getAllUsersByLocation(Long num) {
		return userRepo.findByNum(num);
	}

	@Override
	public String getConversionRateByLocation(Long num) {
		Location loc = locRepo.findOne(num);
		if (loc == null)
			return null;
		String message = "Location: " + loc.getName() + "\n" + "User hits: " + 
			Long.toString(loc.getHits()) + ", Anonymous hits: " + Long.toString(loc.getAnonHits()) +
			"\nConversion Rate: " + Double.toString((double)loc.getHits()/(double)(loc.getAnonHits() + loc.getHits()));
		return message;
	}

	@Override
	public Location createLocation(RequestLocation requestLocation) {
		Location location = checkExisting(requestLocation);
		if (location != null) {
			locRepo.save(location);
		}
		return location;
	}

	@Override
	public Location addToLocation(RequestLocation requestLocation, Long n) {
		if (requestLocation.getTitle() != null) {
			return createLocation(requestLocation);
		}
		
		Location location = getLocationByArea(requestLocation.getNum());
		if (location != null) {
			if (n > 0) {
				location.setAnonHits(location.getAnonHits() + n);
			} else {
				location.setAnonHits(location.getAnonHits() + n);
				location.setHits(location.getHits() - n);
			}
			locRepo.save(location);
			return location;
		}
		return null;
	}
	
	private Location checkExisting(RequestLocation requestLocation) {
		Location existing = getLocationByArea(requestLocation.getNum());
		
		if (existing == null) {
			Location location = new Location();
			location.setName(requestLocation.getTitle());
			location.setAnonHits((long)1);
			location.setHits((long)0);
			location.setArea(requestLocation.getNum());
			return location;
		}
		
		return null;
	}

	private Location parseLocationDays(Location location, Long days) throws ParseException {
		Long currentDay = CurrentDay.getCurrentDay(new Date());
		//findBottom7By in JPA repository
		List<HitsPerDay> list = location.getHitsPerDay();
		for (HitsPerDay hpd : list) {
			if (hpd.getDay() + days <= currentDay) {
				location.setHits(location.getHits() - hpd.getHits());
				location.setAnonHits(location.getAnonHits() - hpd.getAnonHits());
			}
		}
		return location;
	}
	
	@Override
	public List<Location> getAllLocationsByDaysNum(Long days) throws ParseException {
		List<Location> locations = getAllLocations();
		List<Location> result = new ArrayList<>();
		for (Location location : locations)
			result.add(parseLocationDays(location, days));
		
		return result;
	}

	@Override
	public Location getLocationByDaysNum(Long id, Long days) throws ParseException {
		Location location = getLocationById(id);
		if (location == null)
			return null;
		
		return parseLocationDays(location, days);
	}
	
}
