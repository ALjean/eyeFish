package com.jean.model;

/**
 * Created by root on 01.08.15.
 */
public class Weather {

    private long data;
    private long temp;
    private long temp_min;
    private long temp_max;
    private long pressure;
    private long sea_level;
    private long grnd_level;
    private long humidity;
    private long temp_kf;

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public long getTemp() {
        return temp;
    }

    public void setTemp(long temp) {
        this.temp = temp;
    }

    public long getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(long temp_min) {
        this.temp_min = temp_min;
    }

    public long getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(long temp_max) {
        this.temp_max = temp_max;
    }

    public long getPressure() {
        return pressure;
    }

    public void setPressure(long pressure) {
        this.pressure = pressure;
    }

    public long getSea_level() {
        return sea_level;
    }

    public void setSea_level(long sea_level) {
        this.sea_level = sea_level;
    }

    public long getGrnd_level() {
        return grnd_level;
    }

    public void setGrnd_level(long grnd_level) {
        this.grnd_level = grnd_level;
    }

    public long getHumidity() {
        return humidity;
    }

    public void setHumidity(long humidity) {
        this.humidity = humidity;
    }

    public long getTemp_kf() {
        return temp_kf;
    }

    public void setTemp_kf(long temp_kf) {
        this.temp_kf = temp_kf;
    }
}
