package com.jean.entity.analyzing;

import java.sql.Date;

public class PondEnvirmoment {

	private Date date;
	private Float cloudLevel;
	private Float rainLevel;
	private Float temp;
	private Float pressure;
	private Float deepLevel;
	private Float algalevel;
	private Float windSpeed;

	public Float getCloudLevel() {
		return cloudLevel;
	}

	public void setCloudLevel(Float cloudLevel) {
		this.cloudLevel = cloudLevel;
	}

	public Float getRainLevel() {
		return rainLevel;
	}

	public void setRainLevel(Float rainLevel) {
		this.rainLevel = rainLevel;
	}

	public Float getTemp() {
		return temp;
	}

	public void setTemp(Float envirmomentTemp) {
		this.temp = envirmomentTemp;
	}

	public Float getPressure() {
		return pressure;
	}

	public void setPressure(Float pressure) {
		this.pressure = pressure;
	}

	public Float getDeepLevel() {
		return deepLevel;
	}

	public void setDeepLevel(Float deepLevel) {
		this.deepLevel = deepLevel;
	}

	public Float getAlgalevel() {
		return algalevel;
	}

	public void setAlgalevel(Float algaLevel) {
		this.algalevel = algaLevel;
	}

	public Float getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(Float windSpeed) {
		this.windSpeed = windSpeed;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public PondEnvirmoment() {
		
	}

	public PondEnvirmoment(Date date, Float cloudLevel, Float rainLevel, Float temp, Float pressure, Float deepLevel,
			Float algalevel, Float windSpeed) {
		
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
