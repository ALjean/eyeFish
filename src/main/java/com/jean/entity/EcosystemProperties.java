package com.jean.entity;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class EcosystemProperties {

    private Date date;
    private double envirmomentTemp;
    private double cloudLevel;
    private double rainLevel;
    private double windSpeed;

    private Map<String, String> PondProperties = new HashMap<String, String>();

    public Date getDate() {
	return date;
    }

    public void setDate(Date date) {
	this.date = date;
    }

    public double getEnvirmomentTemp() {
	return envirmomentTemp;
    }

    public void setEnvirmomentTemp(double envirmomentTemp) {
	this.envirmomentTemp = envirmomentTemp;
    }

    public double getCloudLevel() {
	return cloudLevel;
    }

    public void setCloudLevel(double cloudLevel) {
	this.cloudLevel = cloudLevel;
    }

    public double getRainLevel() {
	return rainLevel;
    }

    public void setRainLevel(double rainLevel) {
	this.rainLevel = rainLevel;
    }

    public double getWindSpeed() {
	return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
	this.windSpeed = windSpeed;
    }

    public Map<String, String> getPondProperties() {
	return PondProperties;
    }

    public void setPondProperties(Map<String, String> pondProperties) {
	PondProperties = pondProperties;
    }

}
