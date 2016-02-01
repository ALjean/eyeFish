package com.jean.analyzers.weather;

/**
 * Created by jean on 07.12.15.
 */
public interface ConstantsAnalyzer {

    float CRITICAL_PRESSURE_CHANGES = 4.57f;
    double PERCENT_PRESSURE_CHANGES = 44.22;

    float CRITICAL_TEMPERATURE_CHANGES = 4.5f;
    float MAX_GENERAL_TEMPERATURE_CHANGES = 11.5f;
    double PERCENT_TEMPERATURE_CHANGES = 32.25;
    
    double CRITICAL_WIND_SPEED = 7.1;
    double MIN_WIND_SPEED = 1.5;
    
    double CRITICAL_HIGH_TEMPERATURE = 28.5;
    
    enum STATE_DATA_TYPE {ENVIROMENT_TEMPERATURE, WATER_TEMPERATURE, PRESSURE, MOON_PHASE, TIME_DAY, TIME_YEAR};
}
