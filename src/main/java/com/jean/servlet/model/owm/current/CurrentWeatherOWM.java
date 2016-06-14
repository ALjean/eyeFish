package com.jean.servlet.model.owm.current;

import com.jean.servlet.model.owm.*;
import java.util.List;

/**
 * Created by jean on 14.05.16.
 */
public class CurrentWeatherOWM {

	private int id;
	private String name;
	private long dt;
	private CoordOWM coord;
	private List<WeatherMonitorOWM> weather;
	private String base;
	private CurrentWeatherParamsOWM main;
	private SysCurrentOWM sys;

	private WindOWM wind;
	private RainOWM rain;
	private CloudsOWM clouds;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CoordOWM getCoord() {
		return coord;
	}

	public void setCoord(CoordOWM coord) {
		this.coord = coord;
	}

	public List<WeatherMonitorOWM> getWeather() {
		return weather;
	}

	public void setWeather(List<WeatherMonitorOWM> weather) {
		this.weather = weather;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public CurrentWeatherParamsOWM getMain() {
		return main;
	}

	public void setMain(CurrentWeatherParamsOWM main) {
		this.main = main;
	}

	public SysCurrentOWM getSys() {
		return sys;
	}

	public void setSys(SysCurrentOWM sys) {
		this.sys = sys;
	}

	public WindOWM getWind() {
		return wind;
	}

	public void setWind(WindOWM wind) {
		this.wind = wind;
	}

	public RainOWM getRain() {
		return rain;
	}

	public void setRain(RainOWM rain) {
		this.rain = rain;
	}

	public CloudsOWM getClouds() {
		return clouds;
	}

	public void setClouds(CloudsOWM clouds) {
		this.clouds = clouds;
	}

	public long getDt() {
		return dt;
	}

	public void setDt(long dt) {
		this.dt = dt;
	}
	
	public CurrentWeatherOWM() {
		this.rain = new RainOWM();
	}

}
