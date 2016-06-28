package com.jean.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jean.analyzers.weather.BehaviorDTO;
import com.jean.entity.GeneralHourWeather;
import com.jean.service.BehaviorService;
import com.jean.servlet.model.Coordinates;
import com.jean.util.RedisCacheStore;

@Service
public class BehaviorServiceImpl implements BehaviorService {

	@Autowired
	private RedisCacheStore cacheStore;

	@Override
	public BehaviorDTO getFishBehavior(String currentDate, int fishId, double lon, double lat) {

//		GeneralHourWeather hourWeather = cacheStore.findHourWeather(new Coordinates(lon, lat));
		return null;
	}

}
