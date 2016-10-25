package com.jean.entity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BehaviorsDTO {

	private Fish fish;

	private Map<String, List<Behavior>> behaviors;

	private Map<String, List<Bait>> baitsList;

	public BehaviorsDTO() {
		this.behaviors = new LinkedHashMap<String, List<Behavior>>();
		this.baitsList = new LinkedHashMap<String, List<Bait>>();
	}

	public Fish getFish() {
		return fish;
	}

	public void setFish(Fish fish) {
		this.fish = fish;
	}

	public Map<String, List<Behavior>> getBehaviors() {
		return behaviors;
	}

	public void setBehaviors(Map<String, List<Behavior>> behaviors) {
		this.behaviors = behaviors;
	}

	public Map<String, List<Bait>> getBaitsList() {
		return baitsList;
	}

	public void setBaitsList(Map<String, List<Bait>> baitsList) {
		this.baitsList = baitsList;
	}

}
