package com.jean.analyzers.bait;

import java.util.List;

import com.jean.DaoDfmException;
import com.jean.entity.Bait;
import com.jean.entity.Fish;
import com.jean.entity.HourWeather;

public interface BaitConstructor {

	List<Bait> getBaits(HourWeather hourWeather, Fish fish) throws DaoDfmException;
}
