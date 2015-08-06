package com.jean.service.impl;


import com.jean.model.owm.DayWeatherDataOWM;
import com.jean.model.owm.GeneralWeatherStateOWM;
import com.jean.model.owm.HoursWeatherDataOWM;
import com.jean.service.WeatherService;
import com.jean.util.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;


/**
 * Created by stas on 18.07.15.
 */
@Service
public class WeatherServiceImpl implements WeatherService{

    @Value("${weather.url}")
    private String weatherUrl;

    @Value("${weather.id.city}")
    private String cityId;

    @Value("${weather.id.app}")
    private String appId;

    @Override
    @SuppressWarnings("unchecked")
    public  GeneralWeatherStateOWM<HoursWeatherDataOWM> getHoursWeatherState() {
        return  new RestTemplate().getForObject(urlBuilder(Constants.CITY_PATH), GeneralWeatherStateOWM.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public GeneralWeatherStateOWM<DayWeatherDataOWM> getDayWeatherState() {
        return  new RestTemplate().getForObject(urlBuilder(Constants.DAILY_PATH), GeneralWeatherStateOWM.class);
    }


    private URI urlBuilder(String type){
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(weatherUrl + "/" + type)
                .queryParam(Constants.ID, cityId)
                .queryParam(Constants.APPID, appId);
        return builder.build().encode().toUri();
    }
}
