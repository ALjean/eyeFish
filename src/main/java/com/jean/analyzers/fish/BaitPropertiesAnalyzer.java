package com.jean.analyzers.fish;

import com.jean.entity.BaitProperties;

public interface BaitPropertiesAnalyzer {


	public BaitProperties getTheBestColor(double cloudLevel, double deepLevel, double algaLevel, double rainLevel);
	
	public BaitProperties getTheBestTaste(double temperature);
	
	public BaitProperties getTheBestMass(int boffortScale);
}
