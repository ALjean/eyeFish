package com.jean.entity;

public class PondEnvirmoment {

    private float cloudLevel;
    private float rainLevel;
    private float envirmomentTemp;
    private float waterTemp;
    private float pressure;
    private float deepLevel;
    private float algalevel;
    private float windSpeed;

    public float getCloudLevel() {
        return cloudLevel;
    }

    public void setCloudLevel(float cloudLevel) {
        this.cloudLevel = cloudLevel;
    }

    public float getRainLevel() {
        return rainLevel;
    }

    public void setRainLevel(float rainLevel) {
        this.rainLevel = rainLevel;
    }

    public float getEnvirmomentTemp() {
        return envirmomentTemp;
    }

    public void setEnvirmomentTemp(float envirmomentTemp) {
        this.envirmomentTemp = envirmomentTemp;
    }

    public float getWaterTemp() {
        return waterTemp;
    }

    public void setWaterTemp(float waterTemp) {
        this.waterTemp = waterTemp;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getDeepLevel() {
        return deepLevel;
    }

    public void setDeepLevel(float deepLevel) {
        this.deepLevel = deepLevel;
    }

    public float getAlgalevel() {
        return algalevel;
    }

    public void setAlgalevel(float algalevel) {
        this.algalevel = algalevel;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public PondEnvirmoment() {
	super();
    }

    public PondEnvirmoment(float cloudLevel, float rainLevel, float envirmomentTemp, float waterTemp, float pressure, float deepLevel,
	    float algalevel, float windSpeed) {
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
