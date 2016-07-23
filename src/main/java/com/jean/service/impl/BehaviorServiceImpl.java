package com.jean.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.analyzers.fish.BehaviorAnalyzer;
import com.jean.analyzers.fish.BehaviorDTO;
import com.jean.dao.FishDao;
import com.jean.entity.Fish;
import com.jean.entity.GeneralHourWeather;
import com.jean.entity.HourWeather;
import com.jean.enums.RedisKeys;
import com.jean.service.BehaviorService;
import com.jean.servlet.model.Coordinates;
import com.jean.util.RedisCacheStore;

@Service
public class BehaviorServiceImpl implements BehaviorService {

	@Autowired
	private RedisCacheStore casheStore;

	@Autowired
	private BehaviorAnalyzer behaviorAnalyzer;

	@Autowired
	private FishDao fishDao;

	@Override
	public BehaviorDTO getFishBehavior(String currentDate, int fishId, float lon, float lat)
			throws DaoDfmException, CustomDfmException {

		Fish fish = fishDao.getFishes(fishId, null, null, null, null).get(0);

		GeneralHourWeather generalHourWeather = casheStore
				.findHourWeather(new Coordinates(RedisKeys.HourWeather, lon, lat));
		if(generalHourWeather == null){
			throw new CustomDfmException("GeneralHourWeather doesn't exist in cache store");
		}
		
		List<HourWeather> hourWeathers = new ArrayList<HourWeather>();
		
		for (HourWeather hourWeather : generalHourWeather.getHourWeathers()) {
			if (hourWeather.getDateText().substring(0, 10).trim().equals(currentDate)) {
				hourWeathers.add(hourWeather);
			}
		}
		
		return behaviorAnalyzer.getFishBehavior(hourWeathers, fish);

	}

}
