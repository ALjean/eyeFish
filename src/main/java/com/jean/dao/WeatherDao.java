package com.jean.dao;


import com.jean.DaoDfmException;
import com.jean.entity.Weather;

import java.util.Date;
import java.util.List;


/**
 * Created by stas on 18.07.15.
 */
public interface WeatherDao {

    void save(Weather weather) throws DaoDfmException;

    List<Weather> getAllWeather() throws DaoDfmException;

    List<Weather> getLimitWeatherByDate(Date date) throws DaoDfmException;
}
