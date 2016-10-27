package com.jean.entity.weather;

import com.jean.entity.redis.Coordinates;
import com.jean.entity.redis.RedisStoreEntry;
import com.jean.enums.RedisKeys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GeneralDayWeather  implements RedisStoreEntry, Serializable{

	private long cityId;
	private String cityName;
	private float coordLon;
	private float coordLat;
	private String country;
	private double messageCount;
	private List<DayWeather> dayWeathers;

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

	public float getCoordLon() {
		return coordLon;
	}

	public void setCoordLon(float coordLon) {
		this.coordLon = coordLon;
	}

	public float getCoordLat() {
		return coordLat;
	}

	public void setCoordLat(float coordLat) {
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

	public GeneralDayWeather() {
		this.dayWeathers = new ArrayList<DayWeather>();
	}

	@Override
	public String toString() {
		return "GeneralDayWeather [cityId=" + cityId + ", cityName=" + cityName + ", coordLon=" + coordLon
				+ ", coordLat=" + coordLat + ", country=" + country + ", messageCount=" + messageCount
				+ ", dayWeathers=" + dayWeathers + "]";
	}

	@Override
	public Coordinates getRedisCoordinates() {
		return new Coordinates(RedisKeys.DayWeather, coordLon, coordLat);
	}
}
