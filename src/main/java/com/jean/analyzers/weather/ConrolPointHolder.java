package com.jean.analyzers.weather;

import java.util.List;
import com.jean.entity.Bait;

public class ConrolPointHolder {

	private String time;

	private double nibbleLevel;

	private String message;

	private List<Bait> baits;

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

	public List<Bait> getBaits() {
		return baits;
	}

	public void setBaits(List<Bait> baits) {
		this.baits = baits;
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
		return "ConrolPointHolder [time=" + time + ", nibbleLevel=" + nibbleLevel + ", message=" + message + ", baits="
				+ baits + "]";
	}

}
