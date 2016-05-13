package com.jean.service.impl;

import com.jean.config.property.WeatherApiProperties;
import com.jean.servlet.model.owm.DayWeatherDataOWM;
import com.jean.servlet.model.owm.GeneralWeatherStateOWM;
import com.jean.servlet.model.owm.HoursWeatherDataOWM;
import com.jean.service.WeatherService;
import com.jean.Constants;

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
    public GeneralWeatherStateOWM<HoursWeatherDataOWM> getHoursWeatherState(String city) {

        ResponseEntity<GeneralWeatherStateOWM<HoursWeatherDataOWM>> response = new RestTemplate().exchange(urlBuilder(Constants.CITY_PATH, city),
                HttpMethod.GET, null, new ParameterizedTypeReference<GeneralWeatherStateOWM<HoursWeatherDataOWM>>() {
        });
        return response.getBody();
    }

    @Override
    @SuppressWarnings("unchecked")
    public GeneralWeatherStateOWM<DayWeatherDataOWM> getDayWeatherState(String city) {

        ResponseEntity<GeneralWeatherStateOWM<DayWeatherDataOWM>> response = new RestTemplate().exchange(urlBuilder(Constants.DAILY_PATH, city),
                HttpMethod.GET, null, new ParameterizedTypeReference<GeneralWeatherStateOWM<DayWeatherDataOWM>>() {
                });
        return response.getBody();
    }

    private URI urlBuilder(String type, String city) {
        String param = city + "," + weatherApiProperties.getCountryCode();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(weatherApiProperties.getWeatherUrl() + "/" + type)
                 .queryParam(Constants.APPID, weatherApiProperties.getAppId()) //todo connect with auth
                .queryParam(Constants.Q,  param);

        return builder.build().encode().toUri();
    }
}
