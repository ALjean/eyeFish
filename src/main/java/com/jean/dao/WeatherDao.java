package com.jean.dao;

import com.jean.CustomDfmException;
import com.jean.entity.Weather;

import java.util.Date;
import java.util.List;


/**
 * Created by stas on 18.07.15.
 */
public interface WeatherDao {

    void save(Weather weather) throws CustomDfmException;

    List<Weather> getAllWeather() throws CustomDfmException;
    
    List<Weather> getLimitWeatherByDate()throws CustomDfmException;
}
