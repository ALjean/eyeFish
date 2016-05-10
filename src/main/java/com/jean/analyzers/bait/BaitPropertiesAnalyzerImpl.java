package com.jean.analyzers.bait;

import java.util.List;

import com.jean.DaoDfmException;
import org.springframework.beans.factory.annotation.Autowired;

import com.jean.dao.BaitDao;


public class BaitPropertiesAnalyzerImpl implements BaitPropertiesAnalyzer {



    @Autowired
    private BaitDao baitDao;

    @Override
    public List<com.jean.entity.BaitPropertie> getTheBestColor(double cloudLevel, double rainLevel, double deepLevel, double algaLevel)
	    throws DaoDfmException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<com.jean.entity.BaitPropertie> getTheBestTaste(double envirmomentTemp, Double waterTemp) throws DaoDfmException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<com.jean.entity.BaitPropertie> getTheBestMass(int boffortScale) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<com.jean.entity.BaitPropertie> isPopUp(String algaLevel, String livingArea, String baitType, String deepLevel)
	    throws DaoDfmException {
	// TODO Auto-generated method stub
	return null;
    }

}
