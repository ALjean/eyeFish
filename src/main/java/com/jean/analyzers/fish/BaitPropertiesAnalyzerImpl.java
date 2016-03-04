package com.jean.analyzers.fish;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jean.CustomDfmException;
import com.jean.analyzers.weather.ConstantsAnalyzer.*;
import com.jean.dao.BaitDao;
import com.jean.entity.BaitProperties;

@Component
public class BaitPropertiesAnalyzerImpl implements BaitPropertiesAnalyzer {

    @Autowired
    private BaitDao baitDao;

    @Override
    public List<BaitProperties> getTheBestTaste(double temperature) throws CustomDfmException {

	List<BaitProperties> tastes = new ArrayList<BaitProperties>();

	tastes.addAll(baitDao.getBaitTastes(temperature));
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

	List<BaitProperties> colors = new ArrayList<BaitProperties>();

	boolean isRain = false;
	if (rainLevel > 80) {
	    isRain = true;
	}

	if (deepLevel.equalsIgnoreCase(DEEP_LEVEL.OVERDEEPLY.toString())) {
	    colors.addAll(baitDao.getBaitColors(BRIGHT_LEVEL.BRIGHT.toString()));
	} else if ((deepLevel.equalsIgnoreCase(DEEP_LEVEL.DEEPLY.toString()) || deepLevel.equalsIgnoreCase(DEEP_LEVEL.MIDDLE.toString())) && isRain) {
	    colors.addAll(baitDao.getBaitColors(BRIGHT_LEVEL.WHITE.toString()));
	} else {
	    colors.addAll(baitDao.getBaitColors(cloudLevel));
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
