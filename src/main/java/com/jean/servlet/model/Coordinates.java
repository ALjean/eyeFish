package com.jean.servlet.model;

/**
 * Created by jean on 16.05.16.
 */
public class Coordinates implements RedisStoreEntry{


    private float longitude;
    private float latitude;

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        return Float.compare(that.latitude, latitude) == 0 && Float.compare(that.longitude, longitude) == 0;

    }

    @Override
    public int hashCode() {
        int result = (latitude != +0.0f ? Float.floatToIntBits(latitude) : 0);
        result = 31 * result + (longitude != +0.0f ? Float.floatToIntBits(longitude) : 0);
        return result;
    }

    @Override
    public String generateRedisHashKey() {
        return Float.toString(longitude) + "-" + Float.toString(latitude);
    }
}
