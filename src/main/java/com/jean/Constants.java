package com.jean;

/**
 * Created by stas on 18.07.15.
 */
public interface Constants {

    float KELVIN_VALUE = 273.15f;
    float MILLIBAR_VALUE = 1.33322368f;

    String ID = "id";
    String APPID = "APPID";

    String CITY_PATH =  "city";
    String DAILY_PATH =  "daily";

    int MULTIPLIER = 1000;

    enum Location {UP, MIDDLE, DIP}
    enum Hungry {NOTEAT, WEAKLY, MODESTLY, ACTIVE} //new vers.
//    enum Hungry {ACTIVE, NOACTIVE, HUNGRY} //old vers.
    
//    enum StateMarkLocation {
//	UP, MIDDLE, DIP
//    }
//
//    enum StateMarkHungry {
//
//    }



}
