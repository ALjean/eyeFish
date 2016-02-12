package com.jean.servlet.model.owm;

/**
 * Created by Alex on 06.08.15.
 */
public class AverageWeatherParamsOWM {

    private float temp;

    private float temp_min;

    private float temp_max;

    private float pressure;

    private float sea_level;

    private int humidity;

    private float temp_kf;
    
    
    public AverageWeatherParamsOWM() {
	super();
    }

    public AverageWeatherParamsOWM(float temp) {
	super();
	this.temp = temp;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getSea_level() {
        return sea_level;
    }

    public void setSea_level(float sea_level) {
        this.sea_level = sea_level;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public float getTemp_kf() {
        return temp_kf;
    }

    public void setTemp_kf(float temp_kf) {
        this.temp_kf = temp_kf;
    }

    @Override
    public String toString() {
        return "AvarageWeatherParams [temp=" + temp + ", temp_min=" + temp_min + ", temp_max=" + temp_max + ", pressure=" + pressure + ", sea_level="
                + sea_level + ", humidity=" + humidity + ", temp_kf=" + temp_kf + "]";
    }
}
