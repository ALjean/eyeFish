package com.jean.config.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessagesProperties {

	@Value("${behavior.message.crash}")
	private String crash;

	@Value("${behavior.message.spawning}")
	private String spawning;

	@Value("${behavior.message.too.low}")
	private String toolow;

	@Value("${behavior.message.very.low}")
	private String veryLow;

	@Value("${behavior.message.low}")
	private String low;

	@Value("${behavior.message.below.avarage}")
	private String belowAvarage;

	@Value("${behavior.message.avarage}")
	private String avarage;

	@Value("${behavior.message.above.avarage}")
	private String aboveAvarage;

	@Value("${behavior.message.good}")
	private String good;

	@Value("${behavior.message.pretty.good}")
	private String prettyGood;

	@Value("${behavior.message.very.good}")
	private String veryGood;

	@Value("${behavior.message.perfect}")
	private String perfect;

	public String getCrash() {
		return crash;
	}

	public void setCrash(String crash) {
		this.crash = crash;
	}

	public String getSpawning() {
		return spawning;
	}

	public void setSpawning(String spawning) {
		this.spawning = spawning;
	}

	public String getToolow() {
		return toolow;
	}

	public void setToolow(String toolow) {
		this.toolow = toolow;
	}

	public String getVeryLow() {
		return veryLow;
	}

	public void setVeryLow(String veryLow) {
		this.veryLow = veryLow;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getBelowAvarage() {
		return belowAvarage;
	}

	public void setBelowAvarage(String belowAvarage) {
		this.belowAvarage = belowAvarage;
	}

	public String getAvarage() {
		return avarage;
	}

	public void setAvarage(String avarage) {
		this.avarage = avarage;
	}

	public String getAboveAvarage() {
		return aboveAvarage;
	}

	public void setAboveAvarage(String aboveAvarage) {
		this.aboveAvarage = aboveAvarage;
	}

	public String getGood() {
		return good;
	}

	public void setGood(String good) {
		this.good = good;
	}

	public String getPrettyGood() {
		return prettyGood;
	}

	public void setPrettyGood(String prettyGood) {
		this.prettyGood = prettyGood;
	}

	public String getVeryGood() {
		return veryGood;
	}

	public void setVeryGood(String veryGood) {
		this.veryGood = veryGood;
	}

	public String getPerfect() {
		return perfect;
	}

	public void setPerfect(String perfect) {
		this.perfect = perfect;
	}

}
