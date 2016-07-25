package com.jean.analyzers.weather;

/**
 * Created by jean on 07.12.15.
 */
public interface BehaviorConstants {

	double CRITICAL_HIGH_TEMP = 28.5;

	double MIN_PRESSURE_CHANGES = 1;
	double MAX_PRESSURE_CHANGES = 2.5;

	double CRITICAL_WIND_SPEED = 6;
	double MAX_WIND_SPEED = 3.3;

	double HIGH_PRESSURE_LEVEL = 759.0;
	double LOW_PRESSURE_LEVEL = 744.00;

	double MAX_RAIN_VOLUME = 3.3;
	double MIN_RAIN_VOLUME = 0.3;

	double HIGH_PRESSURE_POINT = 8;
	double LOW_PRESSURE_POINT = 6;
	double RISE_PRESSURE_POINT = 6;
	double DOWN_PRESSURE_POINT = 10;
	double STABILITY_PRESSURE_POINT = 8;
	double UNSTABILITY_PRESSURE_POINT = 2;

	double LIGHT_RAIN_POINT = -1;
	double HEAVY_RAIN_POINT = -5;
	double WIND_POINT = -3;
	double DAY_ACTIVITY_POINT = 1;
	
	String SPAWNING_MESSAGE = "Is it spawning now!";

}
