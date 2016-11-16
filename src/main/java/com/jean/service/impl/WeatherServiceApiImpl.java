package com.jean.service.impl;

import com.jean.ApplicationConstants;
import com.jean.config.property.WeatherApiProperties;
import com.jean.entity.owm.GeneralWeatherStateOWM;
import com.jean.entity.owm.current.CurrentWeatherOWM;
import com.jean.entity.owm.detail.DayWeatherDataOWM;
import com.jean.entity.owm.hour.HoursWeatherDataOWM;
import com.jean.entity.redis.Coordinates;
import com.jean.entity.weather.GeneralDayWeather;
import com.jean.entity.weather.GeneralHourWeather;
import com.jean.service.WeatherServiceApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class WeatherServiceApiImpl implements WeatherServiceApi {


    @Autowired
    WeatherApiProperties weatherApiProperties;

    @Override
    @SuppressWarnings("unchecked")
    public GeneralWeatherStateOWM<DayWeatherDataOWM> getDayWeatherState(String lat, String lon) {

        ResponseEntity<GeneralWeatherStateOWM<DayWeatherDataOWM>> response = new RestTemplate().exchange(urlBuilder(lat, lon, ApplicationConstants.DAILY),
                HttpMethod.GET, null, new ParameterizedTypeReference<GeneralWeatherStateOWM<DayWeatherDataOWM>>() {
                });
        return response.getBody();
    }

    @Override
    public CurrentWeatherOWM getCurrentWeatherState(String lat, String lon) {
        ResponseEntity<CurrentWeatherOWM> response = new RestTemplate().exchange(urlBuilder(lat, lon, ApplicationConstants.WEATHER), HttpMethod.GET, null, new ParameterizedTypeReference<CurrentWeatherOWM>() {
        });
        return response.getBody();
    }


    @Override
    @SuppressWarnings("unchecked")
    public GeneralWeatherStateOWM<HoursWeatherDataOWM> getHourWeathers(String lat, String lon) {

        ResponseEntity<GeneralWeatherStateOWM<HoursWeatherDataOWM>> response = new RestTemplate().exchange(urlBuilder(lat, lon, ApplicationConstants.FORCAST),
                HttpMethod.GET, null, new ParameterizedTypeReference<GeneralWeatherStateOWM<HoursWeatherDataOWM>>() {
                });
        return response.getBody();
    }

    private URI urlBuilder(String lat, String lon, String state) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(weatherApiProperties.getWeatherUrl() + "/" + state)
                .queryParam(ApplicationConstants.APPID, weatherApiProperties.getAppId()) //todo connect with auth
                .queryParam(ApplicationConstants.LAT, lat)
                .queryParam(ApplicationConstants.LON, lon);

        return builder.build().encode().toUri();
    }
}
