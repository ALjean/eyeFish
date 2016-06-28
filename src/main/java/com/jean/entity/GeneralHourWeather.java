package com.jean.entity;

import com.jean.enums.RedisKeys;
import com.jean.servlet.model.Coordinates;
import com.jean.servlet.model.RedisStoreEntry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GeneralHourWeather implements RedisStoreEntry, Serializable {

    private long cityId;
    private String cityName;
    private float coordLon;
    private float coordLat;
    private String country;
    private double messageCount;
    private List<HourWeather> hourWeathers;

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public float getCoordLon() {
        return coordLon;
    }

    public void setCoordLon(float coordLon) {
        this.coordLon = coordLon;
    }

    public float getCoordLat() {
        return coordLat;
    }

    public void setCoordLat(float coordLat) {
        this.coordLat = coordLat;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(double messageCount) {
        this.messageCount = messageCount;
    }

    public List<HourWeather> getHourWeathers() {
        return hourWeathers;
    }

    public void setHourWeathers(List<HourWeather> hourWeathers) {
        this.hourWeathers = hourWeathers;
    }

    public GeneralHourWeather() {
        this.hourWeathers = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "GeneralHourWeather [cityId=" + cityId + ", cityName=" + cityName + ", coordLon=" + coordLon
                + ", coordLat=" + coordLat + ", country=" + country + ", messageCount=" + messageCount
                + ", hourWeathers=" + hourWeathers + "]";
    }

    @Override
    public Coordinates getRedisCoordinates() {
        return new Coordinates(RedisKeys.HourWeather, coordLon, coordLat);
    }
}
