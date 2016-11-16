package com.jean.service;

import java.util.*;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.entity.analyzing.BehaviorsDTO;
import com.jean.entity.weather.GeneralHourWeather;

public interface BehaviorService {

	List<BehaviorsDTO> getFishBehavior(List<String> calculatedDates, List<Integer> fishIds, GeneralHourWeather generalHourWeather, boolean withBaits) throws DaoDfmException, CustomDfmException;
	
}
