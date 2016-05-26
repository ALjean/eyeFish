package com.jean.analyzers.weather;

public class GeneralNibbleState {

	private double nibbleLevel;
	private String message;

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

	public GeneralNibbleState() {
		super();
	}

	public GeneralNibbleState(double nibbleLevel, String message) {
		super();
		this.nibbleLevel = nibbleLevel;
		this.message = message;
	}

	@Override
	public String toString() {
		return "PressureState [nibbleLevel=" + nibbleLevel + ", message=" + message + "]";
	}

}
