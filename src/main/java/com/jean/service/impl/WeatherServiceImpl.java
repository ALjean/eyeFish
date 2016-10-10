package com.jean.service.impl;

import com.jean.CustomDfmException;
import com.jean.entity.CurrentWeather;
import com.jean.entity.GeneralDayWeather;
import com.jean.entity.GeneralHourWeather;
import com.jean.service.WeatherApiService;
import com.jean.service.WeatherService;
import com.jean.servlet.model.owm.GeneralWeatherStateOWM;
import com.jean.servlet.model.owm.detail.DayWeatherDataOWM;
import com.jean.servlet.model.owm.hours.HoursWeatherDataOWM;
import com.jean.util.MapperOWM;
import com.jean.util.RedisCacheStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherApiService weatherApiService;

    @Autowired
    private RedisCacheStore casheStore;


    @Override
    public CurrentWeather getCurrentWeatherState(String lat, String lon) {
        return MapperOWM.buildModelCurrentWeather(weatherApiService.getCurrentWeatherState(lat, lon));
    }

    @Override
    public GeneralDayWeather getDayWeatherState(String lat, String lon) throws CustomDfmException {

        GeneralDayWeather dayWeather = casheStore.getGeneralDayWeather(lon, lat);

		if (dayWeather == null) {
			GeneralWeatherStateOWM<DayWeatherDataOWM> dayWeatherOWM = weatherApiService.getDayWeatherState(lat, lon);
			dayWeather = MapperOWM.buildModelDayWeather(dayWeatherOWM);
            casheStore.setWeather(dayWeather);
		}

		return dayWeather;
    }

    @Override
    public GeneralHourWeather getHourWeathers(String lat, String lon) throws CustomDfmException {
        GeneralHourWeather hourWeather = casheStore.getGeneralHourWeather(lat, lon);

		if (hourWeather == null) {
			GeneralWeatherStateOWM<HoursWeatherDataOWM> hourWeatherOWM = weatherApiService.getHourWeathers(lat, lon);
			hourWeather = MapperOWM.buildModelHourWeather(hourWeatherOWM);
            casheStore.setWeather(hourWeather);
		}

        return hourWeather;

    }
}
