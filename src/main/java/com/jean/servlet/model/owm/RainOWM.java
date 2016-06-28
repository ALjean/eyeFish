package com.jean.servlet.model.owm;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RainOWM {

	@JsonProperty("3h")
	private float volume;

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}
	
	
}
