package com.jean.dao;

import com.jean.CustomDfmException;
import com.jean.entity.Weather;


/**
 * Created by stas on 18.07.15.
 */
public interface WeatherDao {
    void create(Weather weather) throws CustomDfmException;
}
