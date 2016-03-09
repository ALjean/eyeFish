package com.jean.analyzers.bait;

import java.util.List;

import com.jean.CustomDfmException;
import com.jean.entity.BaitProperties;

public interface BaitPropertiesAnalyzer {


	public List<BaitProperties> getTheBestColor(double cloudLevel, double rainLevel, String deepLevel) throws CustomDfmException;
	
	public List<BaitProperties> getTheBestTaste(double temperature) throws CustomDfmException;
	
	public List<BaitProperties> getTheBestMass(int boffortScale);
	
	public List<BaitProperties> isPopUp(String algaLevel, String livingArea, String baitType, String deepLevel) throws CustomDfmException;
}
