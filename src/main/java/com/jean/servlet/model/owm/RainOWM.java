package com.jean.servlet.model.owm;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RainOWM {

	@JsonProperty("3h")
	private double volume;

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}
	
	
}
