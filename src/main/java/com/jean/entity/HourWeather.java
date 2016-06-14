package com.jean.entity;

import java.util.Date;

public class HourWeather {

	private Date date;
	private String dateText;
	private String windDirection;
	private String cloudMain;
	private String cloudDescription;
	private double clouds;
	private double humadity;
	private double pressure;
	private double seaLevel;
	private double generalTemp;
	private double tempMin;
	private double tempMax;
	private double windDeg;
	private double windSpeed;
	private double rainVolume;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDateText() {
		return dateText;
	}

	public void setDateText(String dateText) {
		this.dateText = dateText;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
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

	public double getClouds() {
		return clouds;
	}

	public void setClouds(double clouds) {
		this.clouds = clouds;
	}

	public double getHumadity() {
		return humadity;
	}

	public void setHumadity(double humadity) {
		this.humadity = humadity;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	public double getSeaLevel() {
		return seaLevel;
	}

	public void setSeaLevel(double seaLevel) {
		this.seaLevel = seaLevel;
	}

	public double getGeneralTemp() {
		return generalTemp;
	}

	public void setGeneralTemp(double generalTemp) {
		this.generalTemp = generalTemp;
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

	public double getRainVolume() {
		return rainVolume;
	}

	public void setRainVolume(double rainVolume) {
		this.rainVolume = rainVolume;
	}

	@Override
	public String toString() {
		return "HourWeather [date=" + date + ", dateText=" + dateText + ", windDirection=" + windDirection
				+ ", cloudMain=" + cloudMain + ", cloudDescription=" + cloudDescription + ", clouds=" + clouds
				+ ", humadity=" + humadity + ", pressure=" + pressure + ", seaLevel=" + seaLevel + ", generalTemp="
				+ generalTemp + ", tempMin=" + tempMin + ", tempMax=" + tempMax + ", windDeg=" + windDeg
				+ ", windSpeed=" + windSpeed + ", rainVolume=" + rainVolume + "]";
	}

}
