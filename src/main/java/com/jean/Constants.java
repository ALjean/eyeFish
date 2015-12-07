package com.jean;

/**
 * Created by stas on 18.07.15.
 */
public interface Constants {

    float KELVIN_VALUE = 273.15f;
    float MILLIBAR_VALUE = 1.33322368f;
    
    float CRITICAL_PRESSURE_CHANGES = 4.56f;
    double PERCENT_PRESSURE_CHANGES = 44.22;
    
    float CRITICAL_TEMPERATURE_CHANGES = 4.5f;
    float MAX_GENERAL_TEMPERATURE_CHANGES = 11.5f;
    double PERCENT_TEMPERATURE_CHANGES = 32.25;
    
    String ID = "id";
    String APPID = "APPID";

    String CITY_PATH =  "city";
    String DAILY_PATH =  "daily";

    int MULTIPLIER = 1000;

    enum Location {UP, MIDDLE, DIP}
    enum Hungry {NOTEAT, WEAKLY, MODESTLY, ACTIVE} //new vers.
    String NIBBLE_DATA_TYPE = "nibbleDataType";


    String FISH_TYPE_PREDATOR = "PREDATOR";
    String FISH_TYPE_CALM = "CALM";
    


}
