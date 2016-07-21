package com.jean.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalBaitsDTO {

	private Map<String, List<Bait>> optimalBaits;
	private String message;

	public Map<String, List<Bait>> getOptimalBaits() {
		return optimalBaits;
	}

	public void setOptimalBaits(Map<String, List<Bait>> optimalBaits) {
		this.optimalBaits = optimalBaits;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public OptimalBaitsDTO() {
		this.optimalBaits = new HashMap<String, List<Bait>>();
	}

	@Override
	public String toString() {
		return "OptimalBaitsDTO [optimalBaits=" + optimalBaits + ", message=" + message + "]";
	}

}
