package com.cooksys.ftd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.ftd.repository.SpringDataHitsPerDayRepository;
import com.cooksys.ftd.entity.HitsPerDay;
import com.cooksys.ftd.service.HitsPerDayService;

@Service
public class HitsPerDayServiceImpl implements HitsPerDayService {

	@Autowired
	SpringDataHitsPerDayRepository repo;
	
	@Override
	public HitsPerDay createHPD(HitsPerDay hpd) {
		HitsPerDay newHPD = repo.findByDay(hpd.getDay());
		
		if (newHPD != null)
			return null;
		
		repo.save(newHPD);
		
		return hpd;
	}

}
