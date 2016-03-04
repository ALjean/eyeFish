package com.jean.analyzers.fish;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jean.CustomDfmException;
import com.jean.analyzers.weather.ConstantsAnalyzer.*;
import com.jean.dao.BaitDao;
import com.jean.entity.BaitProperties;

@Component
public class BaitPropertiesAnalyzerImpl implements BaitPropertiesAnalyzer {

    private static Logger log = LoggerFactory.getLogger(BaitPropertiesAnalyzerImpl.class);

    @Autowired
    private BaitDao baitDao;

    @Override
    public List<BaitProperties> getTheBestTaste(double temperature) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<BaitProperties> getTheBestMass(int boffortScale) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<BaitProperties> getTheBestColor(double cloudLevel, double rainLevel, String deepLevel) throws CustomDfmException {

	List<BaitProperties> colors = new ArrayList<BaitProperties>();

	boolean isRain = false;
	if (rainLevel > 80) {
	    isRain = true;
	}

	    if (deepLevel.equalsIgnoreCase(DEEP_LEVEL.OVERDEEPLY.toString())) {
		colors.addAll(baitDao.getBaitColors(BRIGHT_LEVEL.BRIGHT.toString()));
	    } else if ((deepLevel.equalsIgnoreCase(DEEP_LEVEL.DEEPLY.toString()) || deepLevel.equalsIgnoreCase(DEEP_LEVEL.MIDDLE.toString()))
		    && isRain) {
		colors.addAll(baitDao.getBaitColors(BRIGHT_LEVEL.WHITE.toString()));
	    } else {
		colors.addAll(baitDao.getBaitColors(cloudLevel));
	    }
	    
	    if(colors.isEmpty()){
		throw new CustomDfmException("For some reason list of collors is empty");
	    }

	return colors;
    }

}
