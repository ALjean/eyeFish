package com.jean.analyzers.constructors;

import java.sql.Date;
import java.util.List;

import com.jean.DaoDfmException;
import com.jean.entity.bait.Bait;
import com.jean.entity.weather.HourWeather;

public interface BaitConstructor {

	List<Bait> getBaitsDependsOnWeathers(long fishId, Date date) throws DaoDfmException;
}
