package com.cooksys.ftd.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="hitsPerDay")
public class HitsPerDay {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="day")
	private Long day;
	@Column(name="hits")
	private Long hits;
	@Column(name="anonHits")
	private Long anonHits;
	@ManyToMany
    @JoinTable(name = "locationHitsPerDay")
    @JsonIgnore
    List<Location> locations;
	
	public HitsPerDay() {
		super();
	}

	public HitsPerDay(Long id, Long day, Long hits, Long anonHits, List<Location> locations) {
		super();
		this.id = id;
		this.day = day;
		this.hits = hits;
		this.anonHits = anonHits;
		this.locations = locations;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDay() {
		return day;
	}

	public void setDay(Long day) {
		this.day = day;
	}

	public Long getHits() {
		return hits;
	}

	public void setHits(Long hits) {
		this.hits = hits;
	}

	public Long getAnonHits() {
		return anonHits;
	}

	public void setAnonHits(Long anonHits) {
		this.anonHits = anonHits;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	
}
