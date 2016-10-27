package com.jean.analyzers.constructors;

import java.sql.Date;
import java.util.List;

import com.jean.DaoDfmException;
import com.jean.entity.bait.Bait;
import com.jean.entity.weather.HourWeather;

public interface BaitConstructor {

	public List<Bait> getBaitsDependsOnWeathers(int fishId, Date date) throws DaoDfmException;
}
