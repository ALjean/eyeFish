package com.jean.entity;

import java.sql.Date;

public class PondEnvirmoment {

	private Date date;
	private float cloudLevel;
	private float rainLevel;
	private float temp;
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

	public float getTemp() {
		return temp;
	}

	public void setTemp(float envirmomentTemp) {
		this.temp = envirmomentTemp;
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

	public void setAlgalevel(float algaLevel) {
		this.algalevel = algaLevel;
	}

	public float getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(float windSpeed) {
		this.windSpeed = windSpeed;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public PondEnvirmoment() {
		super();
	}

	public PondEnvirmoment(Date date, float cloudLevel, float rainLevel, float temp, float pressure, float deepLevel,
			float algalevel, float windSpeed) {
		super();
		this.date = date;
		this.cloudLevel = cloudLevel;
		this.rainLevel = rainLevel;
		this.temp = temp;
		this.pressure = pressure;
		this.deepLevel = deepLevel;
		this.algalevel = algalevel;
		this.windSpeed = windSpeed;
	}

	



}
