package com.jean.service;

import java.util.*;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.entity.BehaviorsDTO;
import com.jean.entity.GeneralHourWeather;

public interface BehaviorService {

	public List<BehaviorsDTO> getFishBehavior(List<String> calculatedDates, List<Integer> fishIds, GeneralHourWeather generalHourWeather) throws DaoDfmException, CustomDfmException;
	
}
