package com.jean.analyzers.fish;

import java.util.List;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.analyzers.weather.AnalyzerResultObject;
import com.jean.entity.Fish;
import com.jean.entity.Weather;

public interface FishAnalyzer {

    AnalyzerResultObject getHungryRating(Fish fish, Weather weather) throws CustomDfmException, DaoDfmException;
}