package com.jean.analyzers.fish;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jean.dao.FishDao;
import com.jean.dao.WeatherDao;
import com.jean.entity.Bait;

public class BaitsConstructor {
	
	@Autowired
	private BaitPropertiesAnalyzer baitPropertiesAnalyzer;
	
	@Autowired 
	private FishDao fishDao;
	
	@Autowired
	private WeatherDao weatherDao;

	public List<Bait> getTheBestBaits(int fishId, double activityLevel, Date date) {

		return null;
	}
}
