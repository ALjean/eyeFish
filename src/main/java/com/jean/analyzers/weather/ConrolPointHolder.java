package com.jean.analyzers.weather;

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

	public ConrolPointHolder() {
		super();
	}

	public ConrolPointHolder(String time, double nibbleLevel, String message) {
		super();
		this.time = time;
		this.nibbleLevel = nibbleLevel;
		this.message = message;
	}

	@Override
	public String toString() {
		return "ConrolPointHolder [time=" + time + ", nibbleLevel=" + nibbleLevel + ", message=" + message + "]";
	}
	
	
}
