package com.jean.config.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Stas on 06.08.15.
 */
@Component
public class WeatherApiProperties {

     /* Weather API Settings */

    @Value("${weather.url}")
    private String weatherUrl;

    @Value("${weather.id.city}")
    private String cityId;

    @Value("${weather.id.app}")
    private String appId;



    public String getWeatherUrl() {
        return weatherUrl;
    }

    public void setWeatherUrl(String weatherUrl) {
        this.weatherUrl = weatherUrl;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }


}
