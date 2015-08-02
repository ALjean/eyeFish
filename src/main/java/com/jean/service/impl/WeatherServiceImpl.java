package com.jean.service.impl;


import com.jean.model.WetherApi;
import com.jean.service.WeatherService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.MediaType;
import java.util.List;

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

    public String getWeatherData(){

        ClientConfig config = new DefaultClientConfig();
        config.getClasses().add(JacksonJaxbJsonProvider.class);
        config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);


        Client client = Client.create();
        WebResource webResource = client.resource(weatherUrl)
                .queryParam("id", cityId).queryParam("APPID", appId);

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);

//        List<WetherApi> accounts = response.getEntity(new GenericType<List<WetherApi>>(){});
        String result = response.getEntity(String.class);
        return result;
    }
}
