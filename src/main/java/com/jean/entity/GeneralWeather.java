package com.jean.entity;

import java.util.ArrayList;
import java.util.List;

public class GeneralWeather {

	private long cityId;
	private String cityName;
	private double coordLon;
	private double coordLat;
	private String country;
	private double messageCount;
	private List<DayWeather> dayWeathers;
	private List<HourWeather> hourWeathers;

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public double getCoordLon() {
		return coordLon;
	}

	public void setCoordLon(double coordLon) {
		this.coordLon = coordLon;
	}

	public double getCoordLat() {
		return coordLat;
	}

	public void setCoordLat(double coordLat) {
		this.coordLat = coordLat;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getMessageCount() {
		return messageCount;
	}

	public void setMessageCount(double messageCount) {
		this.messageCount = messageCount;
	}

	public List<DayWeather> getDayWeathers() {
		return dayWeathers;
	}

	public void setDayWeathers(List<DayWeather> dayWeathers) {
		this.dayWeathers = dayWeathers;
	}

	public List<HourWeather> getHourWeathers() {
		return hourWeathers;
	}

	public void setHourWeathers(List<HourWeather> hourWeathers) {
		this.hourWeathers = hourWeathers;
	}
	
	

	public GeneralWeather() {
		this.dayWeathers = new ArrayList<DayWeather>();
		this.hourWeathers = new ArrayList<HourWeather>();
	}

	@Override
	public String toString() {
		return "GeneralWeather [cityId=" + cityId + ", cityName=" + cityName + ", coordLon=" + coordLon + ", coordLat="
				+ coordLat + ", country=" + country + ", messageCount=" + messageCount + ", dayWeathers=" + dayWeathers
				+ ", hourWeathers=" + hourWeathers + "]";
	}

}