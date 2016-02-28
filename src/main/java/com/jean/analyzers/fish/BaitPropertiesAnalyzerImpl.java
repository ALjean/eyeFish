package com.jean.analyzers.fish;

import org.springframework.stereotype.Component;

import com.jean.entity.BaitProperties;

@Component
public class BaitPropertiesAnalyzerImpl implements BaitPropertiesAnalyzer {

	@Override
	public BaitProperties getTheBestColor(double cloudLevel, double deepLevel, double algaLevel, double rainLevel) {
		
		return null;
	}

	@Override
	public BaitProperties getTheBestTaste(double temperature) {
		
		return null;
	}

	@Override
	public BaitProperties getTheBestMass(int boffortScale) {
		
		return null;
	}

}
