package com.jean.service.impl;

import com.jean.config.property.WeatherApiProperties;
import com.jean.model.owm.DayWeatherDataOWM;
import com.jean.model.owm.GeneralWeatherStateOWM;
import com.jean.model.owm.HoursWeatherDataOWM;
import com.jean.service.WeatherService;
import com.jean.util.Constants;

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
    public GeneralWeatherStateOWM<HoursWeatherDataOWM> getHoursWeatherState() {

	ResponseEntity<GeneralWeatherStateOWM<HoursWeatherDataOWM>> response = new RestTemplate().exchange(urlBuilder(Constants.CITY_PATH),
		HttpMethod.GET, null, new ParameterizedTypeReference<GeneralWeatherStateOWM<HoursWeatherDataOWM>>() {
		});

	GeneralWeatherStateOWM<HoursWeatherDataOWM> result = response.getBody();
	return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public GeneralWeatherStateOWM<DayWeatherDataOWM> getDayWeatherState() {

	ResponseEntity<GeneralWeatherStateOWM<DayWeatherDataOWM>> response = new RestTemplate().exchange(urlBuilder(Constants.DAILY_PATH),
		HttpMethod.GET, null, new ParameterizedTypeReference<GeneralWeatherStateOWM<DayWeatherDataOWM>>() {
		});

	GeneralWeatherStateOWM<DayWeatherDataOWM> result = response.getBody();
	return result;
    }

    private URI urlBuilder(String type) {
	UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(weatherApiProperties.getWeatherUrl() + "/" + type)
	// .queryParam(Constants.APPID, weatherApiProperties.getAppId())
		.queryParam(Constants.ID, weatherApiProperties.getCityId());

	return builder.build().encode().toUri();
    }
}
