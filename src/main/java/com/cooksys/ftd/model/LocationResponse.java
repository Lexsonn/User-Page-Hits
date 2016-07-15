package com.cooksys.ftd.model;

import java.util.ArrayList;
import java.util.List;

import com.cooksys.ftd.entity.Location;

public class LocationResponse {

	private Long id;
	private String title;
	private Long totalHits;
	private Long userHits;
	private Long area;
	
	public LocationResponse() {
		super();
	}

	public LocationResponse(Long id, String title, Long totalHits, Long userHits, Long area) {
		super();
		this.id = id;
		this.title = title;
		this.totalHits = totalHits;
		this.userHits = userHits;
		this.area = area;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getTotalHits() {
		return totalHits;
	}

	public void setTotalHits(Long totalHits) {
		this.totalHits = totalHits;
	}

	public Long getUserHits() {
		return userHits;
	}

	public void setUserHits(Long userHits) {
		this.userHits = userHits;
	}

	public Long getArea() {
		return area;
	}

	public void setArea(Long area) {
		this.area = area;
	}
	
	public static LocationResponse get(Location location) {
		if (location == null)
			return null;
		Long totalHits = location.getAnonHits() + location.getHits();
		return new LocationResponse(location.getId(), location.getName(), totalHits, location.getHits(), location.getArea());
	}
	
	public static List<LocationResponse> getList(List<Location> list) {
		List<LocationResponse> locationList = new ArrayList<>();
		for (Location location : list) {
			locationList.add(LocationResponse.get(location));
		}
		return locationList;
	}
}
