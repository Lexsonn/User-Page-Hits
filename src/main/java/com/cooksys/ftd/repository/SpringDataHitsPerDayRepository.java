package com.cooksys.ftd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.ftd.entity.HitsPerDay;

public interface SpringDataHitsPerDayRepository extends JpaRepository<HitsPerDay, Long> {
	
	public HitsPerDay findByDay(Long day);
	
}
