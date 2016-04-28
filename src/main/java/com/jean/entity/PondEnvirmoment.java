package com.jean.entity;

public class PondEnvirmoment {

    Double cloudLevel;
    Double rainLevel;
    Double envirmomentTemp;
    Double waterTemp;
    Double pressure;
    Double deepLevel;
    Double algalevel;
    Double windSpeed;

    public Double getCloudLevel() {
	return cloudLevel;
    }

    public void setCloudLevel(Double cloudLevel) {
	this.cloudLevel = cloudLevel;
    }

    public Double getRainLevel() {
	return rainLevel;
    }

    public void setRainLevel(Double rainLevel) {
	this.rainLevel = rainLevel;
    }

    public Double getEnvirmomentTemp() {
	return envirmomentTemp;
    }

    public void setEnvirmomentTemp(Double envirmomentTemp) {
	this.envirmomentTemp = envirmomentTemp;
    }

    public Double getWaterTemp() {
	return waterTemp;
    }

    public void setWaterTemp(Double waterTemp) {
	this.waterTemp = waterTemp;
    }

    public Double getPressure() {
	return pressure;
    }

    public void setPressure(Double pressure) {
	this.pressure = pressure;
    }

    public Double getDeepLevel() {
	return deepLevel;
    }

    public void setDeepLevel(Double deepLevel) {
	this.deepLevel = deepLevel;
    }

    public Double getAlgalevel() {
	return algalevel;
    }

    public void setAlgalevel(Double algalevel) {
	this.algalevel = algalevel;
    }

    public Double getWindSpeed() {
	return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
	this.windSpeed = windSpeed;
    }

    public PondEnvirmoment() {
	super();
    }

    public PondEnvirmoment(Double cloudLevel, Double rainLevel, Double envirmomentTemp, Double waterTemp, Double pressure, Double deepLevel,
	    Double algalevel, Double windSpeed) {
	super();
	this.cloudLevel = cloudLevel;
	this.rainLevel = rainLevel;
	this.envirmomentTemp = envirmomentTemp;
	this.waterTemp = waterTemp;
	this.pressure = pressure;
	this.deepLevel = deepLevel;
	this.algalevel = algalevel;
	this.windSpeed = windSpeed;
    }

	@Override
	public String toString() {
		return "PondEnvirmoment [cloudLevel=" + cloudLevel + ", rainLevel=" + rainLevel + ", envirmomentTemp="
				+ envirmomentTemp + ", waterTemp=" + waterTemp + ", pressure=" + pressure + ", deepLevel=" + deepLevel
				+ ", algalevel=" + algalevel + ", windSpeed=" + windSpeed + "]";
	}
    
    

}
