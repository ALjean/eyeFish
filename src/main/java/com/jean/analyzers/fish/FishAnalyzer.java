package com.jean.analyzers.fish;

import java.util.List;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.entity.Fish;

public interface FishAnalyzer {

    List<String> getHungryRating(Fish fish) throws CustomDfmException, DaoDfmException;
}