package com.jean.servlet.model.owm.detail;

import com.jean.servlet.model.owm.WeatherMonitorOWM;

import java.util.List;

/**
 * Created by Alex on 06.08.15.
 */
public class DayWeatherDataOWM {

	private long dt;

	private float pressure;

	private int humidity;

	private float speed;

	private double deg;

	private int clouds;

	private double rain;

	private TempOWM temp;

	private List<WeatherMonitorOWM> weather;

	public long getDt() {
		return dt;
	}

	public void setDt(long dt) {
		this.dt = dt;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public double getDeg() {
		return deg;
	}

	public void setDeg(double deg) {
		this.deg = deg;
	}

	public int getClouds() {
		return clouds;
	}

	public void setClouds(int clouds) {
		this.clouds = clouds;
	}

	public TempOWM getTemp() {
		return temp;
	}

	public void setTemp(TempOWM temp) {
		this.temp = temp;
	}

	public List<WeatherMonitorOWM> getWeather() {
		return weather;
	}

	public void setWeather(List<WeatherMonitorOWM> weather) {
		this.weather = weather;
	}

	public double getRain() {
		return rain;
	}

	public void setRain(double rain) {
		this.rain = rain;
	}

	@Override
	public String toString() {
		return "DayWeatherDataOWM [dt=" + dt + ", pressure=" + pressure + ", humidity=" + humidity + ", speed=" + speed
				+ ", deg=" + deg + ", clouds=" + clouds + ", rain=" + rain + ", temp=" + temp + ", weather=" + weather
				+ "]";
	}

}
