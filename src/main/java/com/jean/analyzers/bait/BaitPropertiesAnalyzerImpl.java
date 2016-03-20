package com.jean.analyzers.bait;

import java.util.ArrayList;
import java.util.List;

import com.jean.DaoDfmException;
import com.jean.dao.BaitPropertiesDao;
import com.jean.enums.BrightLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jean.analyzers.weather.ConstantsAnalyzer;
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
    public List<BaitProperties> getTheBestTaste(double envirmomentTemp, Double waterTemp) throws DaoDfmException {

	List<BaitProperties> tastes = new ArrayList<>();

	String parameterName = "";

	if (waterTemp != null && Math.abs((envirmomentTemp - waterTemp)) >= ConstantsAnalyzer.CRITICAL_DIFFERENCE_TEMP) {
	    parameterName = ConstantsAnalyzer.PARAMETER_NAMES.WATER_TEMPERATURE.name();
	} else {
	    parameterName = ConstantsAnalyzer.PARAMETER_NAMES.ENVIROMENT_TEMPERATURE.name();
	}
	tastes.addAll(baitPropertiesDao.getBaitTastes(envirmomentTemp, parameterName));

	return tastes;
    }

    // TODO
    @Override
    public List<BaitProperties> getTheBestMass(int boffortScale) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<BaitProperties> getTheBestColor(double cloudLevel, double rainLevel, double deepLevel, double algaLevel) throws DaoDfmException {

	List<BaitProperties> colors = new ArrayList<>();

	
	return colors;
    }

    @Override
    public List<BaitProperties> isPopUp(String algaLevel, String livingArea, String baitType, String deepLevel) throws DaoDfmException {

	String result = "";

	if (deepLevel.equalsIgnoreCase(DEEP_LEVEL.SHALLOW.toString()) && algaLevel.equalsIgnoreCase(ALGA_LEVEL.OVERGROWN.toString())
		&& algaLevel.equalsIgnoreCase(ALGA_LEVEL.TRASH.toString())) {

	    result = baitDao.getMessage(KEY_MESSAGE.TOP_POP_UP.toString());
	}

	return null;
    }

}
