package com.jean.entity;

import java.sql.Timestamp;
import java.util.Date;

public class DayWeather {

	private Date currentDate;
	private Timestamp sunRise;
	private Timestamp sunDown;
	private String cloudMain;
	private String cloudDescription;
	private String windDirection;
	private double tempMin;
	private double tempMax;
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

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public Timestamp getSunRise() {
		return sunRise;
	}

	public void setSunRise(Timestamp sunRise) {
		this.sunRise = sunRise;
	}

	public Timestamp getSunDown() {
		return sunDown;
	}

	public void setSunDown(Timestamp sunDown) {
		this.sunDown = sunDown;
	}

	public String getCloudMain() {
		return cloudMain;
	}

	public void setCloudMain(String cloudMain) {
		this.cloudMain = cloudMain;
	}

	public String getCloudDescription() {
		return cloudDescription;
	}

	public void setCloudDescription(String cloudDescription) {
		this.cloudDescription = cloudDescription;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	public double getTempMin() {
		return tempMin;
	}

	public void setTempMin(double tempMin) {
		this.tempMin = tempMin;
	}

	public double getTempMax() {
		return tempMax;
	}

	public void setTempMax(double tempMax) {
		this.tempMax = tempMax;
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
		return "DayWeather [currentDate=" + currentDate + ", sunRise=" + sunRise + ", sunDown=" + sunDown
				+ ", cloudMain=" + cloudMain + ", cloudDescription=" + cloudDescription + ", windDirection="
				+ windDirection + ", tempMin=" + tempMin + ", tempMax=" + tempMax + ", tempDay=" + tempDay
				+ ", tempNight=" + tempNight + ", tempEvening=" + tempEvening + ", tempMorning=" + tempMorning
				+ ", pressure=" + pressure + ", windDeg=" + windDeg + ", windSpeed=" + windSpeed + ", humidity="
				+ humidity + ", clouds=" + clouds + ", rainVolume=" + rainVolume + "]";
	}

}
