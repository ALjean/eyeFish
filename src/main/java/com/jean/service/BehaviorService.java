package com.jean.service;

import com.jean.analyzers.weather.BehaviorDTO;

public interface BehaviorService {

	public BehaviorDTO getFishBehavior(String currentDate, int fishId, double lon, double lat);
	
}
