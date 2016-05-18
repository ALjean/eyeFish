package com.jean.servlet.model;

import java.io.Serializable;

/**
 * Created by jean on 16.05.16.
 */
public class Coordinates implements Serializable {


    private double longitude;
    private double latitude;
    private String redisKey;


    public Coordinates() {
        this("NOT_MATTER");
    }

    public Coordinates(String redisKey) {
        this.redisKey = redisKey;
        this.longitude = 0;
        this.latitude = 0;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getRedisKey() {
        return redisKey;
    }

    public void setRedisKey(String redisKey) {
        this.redisKey = redisKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        return Double.compare(that.longitude, longitude) == 0 && Double.compare(that.latitude, latitude) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(longitude);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
