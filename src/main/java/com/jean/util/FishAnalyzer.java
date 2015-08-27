package com.jean.util;

import java.util.Date;
import java.util.List;

import com.jean.CustomDfmException;
import com.jean.entity.Fish;

public interface FishAnalyzer {

    public List<String> getHungryRating(Fish fish) throws CustomDfmException;
}