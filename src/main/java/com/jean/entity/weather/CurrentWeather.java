package com.jean.entity.weather;

import java.sql.Timestamp;
import java.util.Date;

public class CurrentWeather {

	private long cityId;
	private Date date;
	private Timestamp sunRise;
	private Timestamp sunDown;
	private String cityName;
	private String country;
	private String cloudMain;
	private String cloudDescription;
	private String windDirection;
	private double coordLon;
	private double coordLat;
	private double temp;
	private double tempMin;
	private double tempMax;
	private double pressure;
	private double seaLevel;
	private double humidity;
	private double clouds;
	private double rainVolume;
	private double windDeg;
	private double windSpeed;
	private double tempKf;

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
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

	public double getTempKf() {
		return tempKf;
	}

	public void setTempKf(double tempKf) {
		this.tempKf = tempKf;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	@Override
	public String toString() {
		return "CurrentWeather [cityId=" + cityId + ", date=" + date + ", sunRise=" + sunRise + ", sunDown=" + sunDown
				+ ", cityName=" + cityName + ", country=" + country + ", cloudMain=" + cloudMain + ", cloudDescription="
				+ cloudDescription + ", coordLon=" + coordLon + ", coordLat=" + coordLat + ", temp=" + temp
				+ ", tempMin=" + tempMin + ", tempMax=" + tempMax + ", pressure=" + pressure + ", seaLevel=" + seaLevel
				+ ", humidity=" + humidity + ", clouds=" + clouds + ", rainVolume=" + rainVolume + ", windDeg="
				+ windDeg + ", windSpeed=" + windSpeed + ", tempKf=" + tempKf + "]";
	}

}
