package com.cooksys.ftd.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Location")
public class Location {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="hits")
	private Long hits;
	@Column(name="anon_hits")
	private Long anonHits;
	@Column(name="area")
	private Long area;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "locations", cascade = CascadeType.ALL)
	private List<HitsPerDay> hitsPerDay;
	
	public Location() {
		super();
	}

	public Location(Long id, String name, Long hits, Long anonHits, Long area, List<HitsPerDay> hitsPerDay) {
		super();
		this.id = id;
		this.name = name;
		this.hits = hits;
		this.anonHits = anonHits;
		this.area = area;
		this.hitsPerDay = hitsPerDay;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Long getArea() {
		return area;
	}

	public void setArea(Long area) {
		this.area = area;
	}

	public List<HitsPerDay> getHitsPerDay() {
		return hitsPerDay;
	}

	public void setHitsPerDay(List<HitsPerDay> hitsPerDay) {
		this.hitsPerDay = hitsPerDay;
	}

}
