package com.jean.analyzers.bait;

import java.util.ArrayList;
import java.util.List;

import com.jean.DaoDfmException;
import com.jean.dao.BaitPropertiesDao;
import com.jean.enums.BaitProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jean.analyzers.weather.ConstantsAnalyzer;
import com.jean.analyzers.weather.ConstantsAnalyzer.*;
import com.jean.dao.BaitDao;

@Component
public class BaitPropertiesAnalyzerImpl implements BaitPropertiesAnalyzer {

    @Autowired
    private BaitPropertiesDao baitPropertiesDao;

    @Autowired
    private BaitDao baitDao;

    @Override
    public List<com.jean.entity.BaitProperties> getTheBestColor(double cloudLevel, double rainLevel, double deepLevel, double algaLevel)
	    throws DaoDfmException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<com.jean.entity.BaitProperties> getTheBestTaste(double envirmomentTemp, Double waterTemp) throws DaoDfmException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<com.jean.entity.BaitProperties> getTheBestMass(int boffortScale) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<com.jean.entity.BaitProperties> isPopUp(String algaLevel, String livingArea, String baitType, String deepLevel)
	    throws DaoDfmException {
	// TODO Auto-generated method stub
	return null;
    }

}
