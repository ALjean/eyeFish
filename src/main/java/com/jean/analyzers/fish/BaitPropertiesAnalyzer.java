package com.jean.analyzers.fish;

import java.util.List;

import com.jean.CustomDfmException;
import com.jean.entity.BaitProperties;

public interface BaitPropertiesAnalyzer {


	public List<BaitProperties> getTheBestColor(double cloudLevel, double rainLevel, String deepLevel) throws CustomDfmException;
	
	public List<BaitProperties> getTheBestTaste(double temperature);
	
	public List<BaitProperties> getTheBestMass(int boffortScale);
}
