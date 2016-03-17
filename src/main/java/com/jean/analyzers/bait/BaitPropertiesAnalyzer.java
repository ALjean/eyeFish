package com.jean.analyzers.bait;

import java.util.List;

import com.jean.DaoDfmException;
import com.jean.entity.BaitProperties;

public interface BaitPropertiesAnalyzer {


	List<BaitProperties> getTheBestColor(double cloudLevel, double rainLevel, String deepLevel) throws DaoDfmException;
	
	List<BaitProperties> getTheBestTaste(double temperature) throws DaoDfmException;
	
	List<BaitProperties> getTheBestMass(int boffortScale);
	
	List<BaitProperties> isPopUp(String algaLevel, String livingArea, String baitType, String deepLevel) throws DaoDfmException;
}
