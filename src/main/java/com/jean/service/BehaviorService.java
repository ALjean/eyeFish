package com.jean.service;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.analyzers.fish.BehaviorDTO;

public interface BehaviorService {

	public BehaviorDTO getFishBehavior(String currentDate, int fishId, float lon, float lat) throws DaoDfmException, CustomDfmException;
	
}
