package com.jean.model;

import com.jean.entity.*;

import java.util.List;

/**
 * Created by root on 01.08.15.
 */
public class WetherApi {

    private City city;
    private String cod;
    private List<Weather> weathers;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
}
