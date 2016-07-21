package com.cooksys.ftd.batch;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cooksys.ftd.CurrentDay;
import com.cooksys.ftd.entity.HitsPerDay;
import com.cooksys.ftd.entity.Location;
import com.cooksys.ftd.service.HitsPerDayService;
import com.cooksys.ftd.service.LocationService;

@Component
public class DailyHitScheduler {
	private Logger log = LoggerFactory.getLogger(DailyHitScheduler.class);
	
	@Autowired
	LocationService locationService;
	@Autowired
	HitsPerDayService hitsPerDayService;
	
	@Scheduled(cron = "0 1 0 * * ?")
	public void saveDailyHits() throws ParseException {
		List<Location> list = locationService.getAllLocationsByDaysNum(0L);
		Long day = CurrentDay.getCurrentDay(new Date()) - 1L;
		for (Location location : list) {
			HitsPerDay hpd = new HitsPerDay();
			hpd.setDay(day);
			hpd.setHits(location.getHits());
			hpd.setAnonHits(location.getAnonHits());
			if (hpd.getHits() != 0 && hpd.getAnonHits() != 0) //No need to input data that hasn't changed.
				hitsPerDayService.createHPD(hpd);
			log.info("Location: {}, Hits per for day {}: {}, {}", hpd.getDay(), hpd.getHits(), hpd.getAnonHits());
		}
	}
}
