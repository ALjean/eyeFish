package com.jean.analyzers.weather;

import com.jean.analyzers.weather.WindDirectionConverter.Direction;
import com.jean.analyzers.weather.WindDirectionConverter.MinMaxHolder;

/**
 * Created by jean on 07.12.15.
 */
public interface ConstantsAnalyzer {

	double MIN_TEMP_CHANGES_PER_DAY = 1.5;
	double MAX_TEMP_CHANGES_PER_DAY = 2.5;
	double CRITICAL_TEMP_CHANGES_ALL_PERIOD = 5.5;
	double CRITICAL_HIGH_TEMP = 28.5;

	double MIN_PRESSURE_CHABGES_PER_DAY = 1.5;
	double MAX_PRESSURE_CHANGES_PER_DAY = 2.5;
	double CRITICAL_PRESSURE_CHANGES_ALL_PERIOD = 5.5;

	double PERCENT_PRESSURE_CHANGES = 18.18;
	double PERCENT_TEMPERATURE_CHANGES = 22.22;

	double CRITICAL_WIND_SPEED = 7.1;
	double MIN_WIND_SPEED = 1.5;
	
	double WIND_NIBBLE_N = 6.5;
	double WIND_NIBBLE_NNE = 8.32;
	double WIND_NIBBLE_NE = 25.12;
	double WIND_NIBBLE_ENE = 51.32;
	double WIND_NIBBLE_E = 70.32;
	double WIND_NIBBLE_ESE = 75.14;
	double WIND_NIBBLE_SE = 80.32;
	double WIND_NIBBLE_SSE = 88.18;
	double WIND_NIBBLE_S = 99.22;
	double WIND_NIBBLE_SSW = 62.87;
	double WIND_NIBBLE_SW = 50.32;
	double WIND_NIBBLE_WSW = 42.09;
	double WIND_NIBBLE_W = 30.56;
	double WIND_NIBBLE_WNW = 25.14;
	double WIND_NIBBLE_NW = 8.69;
	double WIND_NIBBLE_NNW = 7.52;

	enum PARAMETER_NAMES {
		ENVIROMENT_TEMPERATURE, WATER_TEMPERATURE, PRESSURE, MOON_PHASE, TIME_DAY, TIME_YEAR
	}

	// enum BRIGHT_LEVEL {BRIGHT, WHITE, NATURAL, DARK}

	enum ALGA_LEVEL {
		CLEAR, OVERGROWN, TRASH
	}

	enum DEEP_LEVEL {
		SHALLOW, MIDDLE, DEEPLY, OVERDEEPLY
	}

	enum BAIT_TYPE {
		LIVEBAIT, VEGETALE, BOIL, SIMULATED
	}

	enum KEY_MESSAGE {
		STYRO_POP_UP, BOIL_POP_UP, TOP_POP_UP
	}

	enum LIVING_AREA {
		TOP, MIDDLE, BOTTOM, EVERPRESENT
	}
}
