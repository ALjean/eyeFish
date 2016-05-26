package com.jean.analyzers.weather;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConrolPointHolder {

	private String time;

	private double nibbleLevel;

	private String message;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getNibbleLevel() {
		return nibbleLevel;
	}

	public void setNibbleLevel(double nibbleLevel) {
		this.nibbleLevel = nibbleLevel;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ConrolPointHolder(String time, double nibbleLevel, String message) {
		super();
		this.time = time;
		this.nibbleLevel = nibbleLevel;
		this.message = message;
	}

	public ConrolPointHolder() {
		super();
	}

	@Override
	public String toString() {
		return "ConrolPointHolder [time=" + time + ", nibbleLevel=" + nibbleLevel + ", message=" + message + "]";
	}

}
