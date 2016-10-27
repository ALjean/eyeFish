package com.jean.entity.owm;

/**
 * Created by Alex on 06.08.15.
 */
public class CoordOWM {
    private float lon;
    private float lat;

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }
    public void setLat(float lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Coord [lon=" + lon + ", lat=" + lat + "]";
    }
}
