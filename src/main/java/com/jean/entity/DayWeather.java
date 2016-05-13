package com.jean.entity;

import java.sql.Timestamp;

public class DayWeather {

	private int id;
	private Timestamp currentDate;
	private String sunRise;
	private String sunDown;
	private double tempDay;
	private double tempNight;
	private double tempEvening;
	private double tempMorning;
	private double pressure;
	private double windDeg;
	private double windSpeed;
	private double humidity;
	private double clouds;
	private double rainVolume;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Timestamp currentDate) {
		this.currentDate = currentDate;
	}

	public String getSunRise() {
		return sunRise;
	}

	public void setSunRise(String sunRise) {
		this.sunRise = sunRise;
	}

	public String getSunDown() {
		return sunDown;
	}

	public void setSunDown(String sunDown) {
		this.sunDown = sunDown;
	}

	public double getTempDay() {
		return tempDay;
	}

	public void setTempDay(double tempDay) {
		this.tempDay = tempDay;
	}

	public double getTempNight() {
		return tempNight;
	}

	public void setTempNight(double tempNight) {
		this.tempNight = tempNight;
	}

	public double getTempEvening() {
		return tempEvening;
	}

	public void setTempEvening(double tempEvening) {
		this.tempEvening = tempEvening;
	}

	public double getTempMorning() {
		return tempMorning;
	}

	public void setTempMorning(double tempMorning) {
		this.tempMorning = tempMorning;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public double getWindDeg() {
		return windDeg;
	}

	public void setWindDeg(double windDeg) {
		this.windDeg = windDeg;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public double getClouds() {
		return clouds;
	}

	public void setClouds(double clouds) {
		this.clouds = clouds;
	}

	public double getRainVolume() {
		return rainVolume;
	}

	public void setRainVolume(double rainVolume) {
		this.rainVolume = rainVolume;
	}

	@Override
	public String toString() {
		return "DayWeather [id=" + id + ", currentDate=" + currentDate + ", sunRise=" + sunRise + ", sunDown=" + sunDown
				+ ", tempDay=" + tempDay + ", tempNight=" + tempNight + ", tempEvening=" + tempEvening
				+ ", tempMorning=" + tempMorning + ", pressure=" + pressure + ", windDeg=" + windDeg + ", windSpeed="
				+ windSpeed + ", humidity=" + humidity + ", clouds=" + clouds + ", rainVolume=" + rainVolume + "]";
	}

}
