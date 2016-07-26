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
import com.jean.service.BehaviorService;

@Service
public class BehaviorServiceImpl implements BehaviorService {

	@Autowired
	private BehaviorAnalyzer behaviorAnalyzer;

	@Autowired
	private FishDao fishDao;

	@Override
	public BehaviorDTO getFishBehavior(String currentDate, int fishId, GeneralHourWeather generalHourWeather)
			throws DaoDfmException, CustomDfmException {
		
		List<Fish> fishes = fishDao.getFishes(fishId, null, null, null, null);
		
		if(fishes.isEmpty()){
			throw new CustomDfmException("Fish didn't found");
		}

		Fish fish = fishes.get(0);
		
		List<HourWeather> hourWeathers = new ArrayList<HourWeather>();
		
		for (HourWeather hourWeather : generalHourWeather.getHourWeathers()) {
			if (hourWeather.getDateText().substring(0, 10).trim().equals(currentDate)) {
				hourWeathers.add(hourWeather);
			}
		}
		
		return behaviorAnalyzer.getFishBehavior(hourWeathers, fish);

	}

}
