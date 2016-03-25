package com.jean.analyzers.bait;

import java.util.List;

import com.jean.DaoDfmException;
import com.jean.entity.BaitPropertie;

public interface BaitPropertiesAnalyzer {


	List<BaitPropertie> getTheBestColor(double cloudLevel, double rainLevel, double deepLevel, double algaLevel) throws DaoDfmException;
	
	List<BaitPropertie> getTheBestTaste(double envirmomentTemp, Double waterTemp) throws DaoDfmException;
	
	List<BaitPropertie> getTheBestMass(int boffortScale);
	
	List<BaitPropertie> isPopUp(String algaLevel, String livingArea, String baitType, String deepLevel) throws DaoDfmException;
}
