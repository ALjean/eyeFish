package com.jean.service.impl;

import com.jean.config.property.WeatherApiProperties;
import com.jean.servlet.model.owm.current.CurrentWeatherOWM;
import com.jean.servlet.model.owm.detail.DayWeatherDataOWM;
import com.jean.servlet.model.owm.GeneralWeatherStateOWM;
import com.jean.servlet.model.owm.hours.HoursWeatherDataOWM;
import com.jean.service.WeatherService;
import com.jean.ApplicationConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Created by stas on 18.07.15.
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    WeatherApiProperties weatherApiProperties;

    @Override
    @SuppressWarnings("unchecked")
    public GeneralWeatherStateOWM<DayWeatherDataOWM> getDayWeatherState(String lat, String lon) {

        ResponseEntity<GeneralWeatherStateOWM<DayWeatherDataOWM>> response = new RestTemplate().exchange(urlBuilder(lat, lon, ApplicationConstants.DAILY),
                HttpMethod.GET, null, new ParameterizedTypeReference<GeneralWeatherStateOWM<DayWeatherDataOWM>>() {});
        return response.getBody();
    }

    @Override
    public CurrentWeatherOWM getCurrentWeatherState(String lat, String lon) {
    	
        ResponseEntity<CurrentWeatherOWM> response = new RestTemplate().exchange(urlBuilder(lat, lon, ApplicationConstants.WEATHER),
                HttpMethod.GET, null, new ParameterizedTypeReference<CurrentWeatherOWM>() {});
        return response.getBody();
    }


    @Override
    @SuppressWarnings("unchecked")
    public GeneralWeatherStateOWM<HoursWeatherDataOWM> getHourWeathers(String lat, String lon) {

        ResponseEntity<GeneralWeatherStateOWM<HoursWeatherDataOWM>> response = new RestTemplate().exchange(urlBuilder(lat, lon, ApplicationConstants.FORCAST),
                HttpMethod.GET, null, new ParameterizedTypeReference<GeneralWeatherStateOWM<HoursWeatherDataOWM>>() {});
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
