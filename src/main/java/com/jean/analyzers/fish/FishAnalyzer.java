package com.jean.analyzers.fish;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.analyzers.weather.AnalyzerResultObject;
import com.jean.entity.Fish;


public interface FishAnalyzer {

    AnalyzerResultObject getHungryRating(Fish fish) throws CustomDfmException, DaoDfmException;
}