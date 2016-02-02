package com.jean.analyzers.weather;

import java.sql.Timestamp;

public class AnalyzerResultObject {

    // Individual parameters for compare for each fish in database
    private double temperature;
    private double waterTemperature;
    private double pressure;
    private double clouds;
    private double rain;
    private double snow;
    private double moonPhase;

    // Values from WeatherAnalyzer
    private double weatherStabilityValue;
    private double pressureStabilityValue;
    private double windDirectionValue;

    // Current date and time on moment of fetching weather data
    private Timestamp timeDay;
    private Timestamp timeYear;

    public AnalyzerResultObject(double temperature, double waterTemperature, double pressure, double clouds, double rain, double snow,
	    double moonPhase, double weatherStabilityValue, double pressureStabilityValue, double windDirectionValue, Timestamp timeDay,
	    Timestamp timeYear) {
	super();
	this.temperature = temperature;
	this.waterTemperature = waterTemperature;
	this.pressure = pressure;
	this.clouds = clouds;
	this.rain = rain;
	this.snow = snow;
	this.moonPhase = moonPhase;
	this.weatherStabilityValue = weatherStabilityValue;
	this.pressureStabilityValue = pressureStabilityValue;
	this.windDirectionValue = windDirectionValue;
	this.timeDay = timeDay;
	this.timeYear = timeYear;
    }

    public AnalyzerResultObject() {
	super();
    }

    public double getTemperature() {
	return temperature;
    }

    public double getClouds() {
	return clouds;
    }

    public void setClouds(double clouds) {
	this.clouds = clouds;
    }

    public double getRain() {
	return rain;
    }

    public void setRain(double rain) {
	this.rain = rain;
    }

    public double getSnow() {
	return snow;
    }

    public void setSnow(double snow) {
	this.snow = snow;
    }

    public void setTemperature(double temperature) {
	this.temperature = temperature;
    }

    public double getWaterTemperature() {
	return waterTemperature;
    }

    public void setWaterTemperature(double waterTemperature) {
	this.waterTemperature = waterTemperature;
    }

    public double getPressure() {
	return pressure;
    }

    public void setPressure(double pressure) {
	this.pressure = pressure;
    }

    public double getMoonPhase() {
	return moonPhase;
    }

    public void setMoonPhase(double moonPhase) {
	this.moonPhase = moonPhase;
    }

    public double getWeatherStabilityValue() {
	return weatherStabilityValue;
    }

    public void setWeatherStabilityValue(double weatherStabilityValue) {
	this.weatherStabilityValue = weatherStabilityValue;
    }

    public double getPressureStabilityValue() {
	return pressureStabilityValue;
    }

    public void setPressureStabilityValue(double pressureStabilityValue) {
	this.pressureStabilityValue = pressureStabilityValue;
    }

    public double getWindDirectionValue() {
	return windDirectionValue;
    }

    public void setWindDirectionValue(double windDirectionValue) {
	this.windDirectionValue = windDirectionValue;
    }

    public Timestamp getTimeDay() {
	return timeDay;
    }

    public void setTimeDay(Timestamp timeDay) {
	this.timeDay = timeDay;
    }

    public Timestamp getTimeYear() {
	return timeYear;
    }

    public void setTimeYear(Timestamp timeYear) {
	this.timeYear = timeYear;
    }

    @Override
    public String toString() {
	return "AnalyzerResultObject [temperature=" + temperature + ", waterTemperature=" + waterTemperature + ", pressure=" + pressure + ", clouds="
		+ clouds + ", rain=" + rain + ", snow=" + snow + ", moonPhase=" + moonPhase + ", weatherStabilityValue=" + weatherStabilityValue
		+ ", pressureStabilityValue=" + pressureStabilityValue + ", windDirectionValue=" + windDirectionValue + ", timeDay=" + timeDay
		+ ", timeYear=" + timeYear + "]";
    }

}
