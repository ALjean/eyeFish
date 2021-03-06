package com.jean.entity.owm;

import java.util.List;

import com.jean.entity.owm.hour.CityOWM;

public class GeneralWeatherStateOWM<T> {

    private CityOWM city;

    private float message;

    private int cnt;

    private List<T> list;

    public CityOWM getCity() {
        return city;
    }

    public void setCity(CityOWM city) {
        this.city = city;
    }

    public float getMessage() {
        return message;
    }

    public void setMessage(float message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "GeneralDataWeatherOWM [city=" + city + ", message=" + message + ", cnt=" + cnt + ", list=" + list + "]";
    }
}
