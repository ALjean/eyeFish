package com.jean.service;

import com.jean.analyzers.fish.BehaviorDTO;

public interface BehaviorService {

	public BehaviorDTO getFishBehavior(String currentDate, int fishId, double lon, double lat);
	
}
