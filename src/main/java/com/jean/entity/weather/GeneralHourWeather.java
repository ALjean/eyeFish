package com.jean.entity.weather;

import com.jean.entity.redis.Coordinates;
import com.jean.entity.redis.RedisStoreEntry;
import com.jean.enums.RedisKeys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class GeneralHourWeather implements RedisStoreEntry, Serializable {

	private static final long serialVersionUID = 1629110154828593180L;

	private long cityId;
	private String cityName;
	private float coordLon;
	private float coordLat;
	private String country;
	private double messageCount;
	private Map<Date, List<HourWeather>> dayHourWeathers;

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

	public Map<Date, List<HourWeather>> getDayHourWeathers() {
		return dayHourWeathers;
	}

	public void setDayHourWeathers(Map<Date, List<HourWeather>> dayHourWeathers) {
		this.dayHourWeathers = dayHourWeathers;
	}

	@Override
	public String toString() {
		return "GeneralHourWeather [cityId=" + cityId + ", cityName=" + cityName + ", coordLon=" + coordLon
				+ ", coordLat=" + coordLat + ", country=" + country + ", messageCount=" + messageCount
				+ ", hourWeathers=" + "]";
	}

	@Override
	public Coordinates getRedisCoordinates() {
		return new Coordinates(RedisKeys.HourWeather, coordLon, coordLat);
	}
}
