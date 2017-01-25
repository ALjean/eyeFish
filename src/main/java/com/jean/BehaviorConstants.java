package com.jean;

/**
 * Created by jean on 07.12.15.
 */
public interface BehaviorConstants {

	float CRITICAL_HIGH_TEMP = 28.5f;

	float MIN_PRESSURE_CHANGES = 1;
	float MAX_PRESSURE_CHANGES = 2.5f;

	float CRITICAL_WIND_SPEED = 6;
	float MAX_WIND_SPEED = 3.3f;

	float HIGH_PRESSURE_LEVEL = 759.0f;
	float LOW_PRESSURE_LEVEL = 744.00f;

	float MAX_RAIN_VOLUME = 3.3f;
	float MIN_RAIN_VOLUME = 0.3f;

	float CRASH_NIBBLE_POINT = -15;
	float SPAWNING_POINT = -10;
	float COUNT_OF_POINT = 10;
	float HIGH_PRESSURE_POINT = 8;
	float LOW_PRESSURE_POINT = 6;
	float RISE_PRESSURE_POINT = 6;
	float DOWN_PRESSURE_POINT = 10;
	float STABILITY_PRESSURE_POINT = 8;
	float UNSTABILITY_PRESSURE_POINT = 2;

	float LIGHT_RAIN_POINT = -1;
	float HEAVY_RAIN_POINT = -5;
	float WIND_POINT = -3;
	float DAY_ACTIVITY_POINT = 1;
	
	String SPAWNING_MESSAGE = "Is it spawning now!";

}
