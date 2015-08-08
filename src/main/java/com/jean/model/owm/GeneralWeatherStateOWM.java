package com.jean.model.owm;

import java.util.List;

public class GeneralWeatherStateOWM {

    private CityOWM city;

    private float message;

    private int cnt;

    private List<DayWeatherDataOWM> list;

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

    public List<DayWeatherDataOWM> getList() {
        return list;
    }

    public void setList(List<DayWeatherDataOWM> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "GeneralDataWeatherOWM [city=" + city + ", message=" + message + ", cnt=" + cnt + ", list=" + list + "]";
    }
}
