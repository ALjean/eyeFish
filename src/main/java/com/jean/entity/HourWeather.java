package com.jean.entity;

import java.io.Serializable;
import java.util.Date;


public class HourWeather implements Serializable {

	private Date date;
	private String dateText;
	private String windDirection;
	private String cloudMain;
	private String cloudDescription;
	private float clouds;
	private float humadity;
	private float pressure;
	private float seaLevel;
	private float generalTemp;
	private float tempMin;
	private float tempMax;
	private float windDeg;
	private float windSpeed;
	private float rainVolume;

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

	public float getClouds() {
		return clouds;
	}

	public void setClouds(float clouds) {
		this.clouds = clouds;
	}

	public float getHumadity() {
		return humadity;
	}

	public void setHumadity(float humadity) {
		this.humadity = humadity;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	public float getSeaLevel() {
		return seaLevel;
	}

	public void setSeaLevel(float seaLevel) {
		this.seaLevel = seaLevel;
	}

	public float getGeneralTemp() {
		return generalTemp;
	}

	public void setGeneralTemp(float generalTemp) {
		this.generalTemp = generalTemp;
	}

	public float getTempMin() {
		return tempMin;
	}

	public void setTempMin(float tempMin) {
		this.tempMin = tempMin;
	}

	public float getTempMax() {
		return tempMax;
	}

	public void setTempMax(float tempMax) {
		this.tempMax = tempMax;
	}

	public float getWindDeg() {
		return windDeg;
	}

	public void setWindDeg(float windDeg) {
		this.windDeg = windDeg;
	}

	public float getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(float windSpeed) {
		this.windSpeed = windSpeed;
	}

	public float getRainVolume() {
		return rainVolume;
	}

	public void setRainVolume(float rainVolume) {
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
