package com.jean.analyzers.fish;

import java.util.ArrayList;
import java.util.List;

import com.jean.dao.BaitPropertiesDao;
import com.jean.enums.BrightLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jean.CustomDfmException;
import com.jean.analyzers.weather.ConstantsAnalyzer.*;
import com.jean.dao.BaitDao;
import com.jean.entity.BaitProperties;

@Component
public class BaitPropertiesAnalyzerImpl implements BaitPropertiesAnalyzer {

    @Autowired
    private BaitPropertiesDao baitPropertiesDao;

	@Autowired
	private BaitDao baitDao;

    @Override
    public List<BaitProperties> getTheBestTaste(double temperature) throws CustomDfmException {

	List<BaitProperties> tastes = new ArrayList<>();

	tastes.addAll(baitPropertiesDao.getBaitTastes(temperature));
	return tastes;
    }

    //TODO
    @Override
    public List<BaitProperties> getTheBestMass(int boffortScale) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<BaitProperties> getTheBestColor(double cloudLevel, double rainLevel, String deepLevel) throws CustomDfmException {

	List<BaitProperties> colors = new ArrayList<>();

	boolean isRain = false;
	if (rainLevel > 80) {
	    isRain = true;
	}

	if (deepLevel.equalsIgnoreCase(DEEP_LEVEL.OVERDEEPLY.toString())) {
	    colors.addAll(baitPropertiesDao.getBaitColors(BrightLevel.BRIGHT));
	} else if ((deepLevel.equalsIgnoreCase(DEEP_LEVEL.DEEPLY.toString()) || deepLevel.equalsIgnoreCase(DEEP_LEVEL.MIDDLE.toString())) && isRain) {
	    colors.addAll(baitPropertiesDao.getBaitColors(BrightLevel.WHITE));
	} else {
	    colors.addAll(baitPropertiesDao.getBaitColors(cloudLevel));
	}

	return colors;
    }

    @Override
    public List<BaitProperties> isPopUp(String algaLevel, String livingArea, String baitType, String deepLevel) throws CustomDfmException {
	
	String result = "";
	
	if(deepLevel.equalsIgnoreCase(DEEP_LEVEL.SHALLOW.toString()) 
		&& algaLevel.equalsIgnoreCase(ALGA_LEVEL.OVERGROWN.toString()) 
		&& algaLevel.equalsIgnoreCase(ALGA_LEVEL.TRASH.toString())){
	    
	   result = baitDao.getMessage(KEY_MESSAGE.TOP_POP_UP.toString());
	}
	
	
	return null;
    }

}
