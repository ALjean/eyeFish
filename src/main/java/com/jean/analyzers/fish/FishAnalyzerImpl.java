package com.jean.analyzers.fish;

import com.jean.DaoDfmException;
import com.jean.analyzers.weather.AnalyzerResultObject;
import org.springframework.stereotype.Component;

import com.jean.CustomDfmException;
import com.jean.entity.Fish;
import com.jean.entity.Weather;

import java.util.ArrayList;
import java.util.List;

@Component
public class FishAnalyzerImpl implements FishAnalyzer {

    @Override
    public AnalyzerResultObject getHungryRating(Fish fish, Weather weather) throws CustomDfmException, DaoDfmException {


        // TODO Auto-generated method stub


        return null;

    }


}
