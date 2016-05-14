package com.jean.servlet.model.owm.hours;

import com.jean.servlet.model.owm.*;

import java.util.List;

/**
 * Created by Alex on 06.08.15.
 */
public class HoursWeatherDataOWM {

	private long dt;

	private String dt_txt;

	private AverageWeatherParamsOWM main;

	private List<WeatherMonitorOWM> weather;

	private CloudsOWM clouds;

	private WindOWM wind;

	private RainOWM rain;

	private SysOWM sys;

	public long getDt() {
		return dt;
	}

	public void setDt(long dt) {
		this.dt = dt;
	}

	public String getDt_txt() {
		return dt_txt;
	}

	public void setDt_txt(String dt_txt) {
		this.dt_txt = dt_txt;
	}

	public AverageWeatherParamsOWM getMain() {
		return main;
	}

	public void setMain(AverageWeatherParamsOWM main) {
		this.main = main;
	}

	public List<WeatherMonitorOWM> getWeather() {
		return weather;
	}

	public void setWeather(List<WeatherMonitorOWM> weather) {
		this.weather = weather;
	}

	public CloudsOWM getClouds() {
		return clouds;
	}

	public void setClouds(CloudsOWM clouds) {
		this.clouds = clouds;
	}

	public WindOWM getWind() {
		return wind;
	}

	public void setWind(WindOWM wind) {
		this.wind = wind;
	}

	public SysOWM getSys() {
		return sys;
	}

	public void setSys(SysOWM sys) {
		this.sys = sys;
	}

	public RainOWM getRain() {
		return rain;
	}

	public void setRain(RainOWM rain) {
		this.rain = rain;
	}

	@Override
	public String toString() {
		return "HoursWeatherDataOWM [dt=" + dt + ", dt_txt=" + dt_txt + ", main=" + main + ", weather=" + weather
				+ ", clouds=" + clouds + ", wind=" + wind + ", rain=" + rain + ", sys=" + sys + "]";
	}

}
