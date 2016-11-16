package com.jean.service.impl;

import com.jean.CustomDfmException;
import com.jean.entity.owm.GeneralWeatherStateOWM;
import com.jean.entity.owm.current.CurrentWeatherOWM;
import com.jean.entity.owm.detail.DayWeatherDataOWM;
import com.jean.entity.owm.hour.HoursWeatherDataOWM;
import com.jean.entity.weather.GeneralDayWeather;
import com.jean.entity.weather.GeneralHourWeather;
import com.jean.service.WeatherService;


import com.jean.service.WeatherServiceApi;
import com.jean.util.MapperOWM;
import com.jean.util.RedisCacheStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by stas on 18.07.15.
 */
@Service
public class WeatherServiceImpl implements WeatherService {


    @Autowired
    private WeatherServiceApi weatherServiceApi;

    @Autowired
    private RedisCacheStore casheStore;

    @Override
    public GeneralHourWeather getGeneralHourWeather(String lon, String lat) throws CustomDfmException {

        GeneralHourWeather hourWeather = casheStore.getGeneralHourWeather(lon, lat);

        if (hourWeather == null) {
            GeneralWeatherStateOWM<HoursWeatherDataOWM> hourWeatherOWM = weatherServiceApi.getHourWeathers(lat, lon);
            hourWeather = MapperOWM.buildModelHourWeather(hourWeatherOWM);
            casheStore.setWeather(hourWeather);
        }

        return hourWeather;
    }

    @Override
    public GeneralDayWeather getGeneralDayWeather(String lon, String lat) throws CustomDfmException {

        GeneralDayWeather dayWeather = casheStore.getGeneralDayWeather(lon, lat);

        if (dayWeather == null) {
            GeneralWeatherStateOWM<DayWeatherDataOWM> dayWeatherOWM = weatherServiceApi.getDayWeatherState(lat, lon);
            dayWeather = MapperOWM.buildModelDayWeather(dayWeatherOWM);
            casheStore.setWeather(dayWeather);
        }

        return dayWeather;
    }

    @Override
    public CurrentWeatherOWM getCurrentWeatherState(String lat, String lon) {
        return weatherServiceApi.getCurrentWeatherState(lat, lon);
    }
}
