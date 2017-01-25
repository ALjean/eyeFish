package com.jean.entity.analyzing;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.jean.dao.entity.fish.Fish;

public class BehaviorsDTO {

	private Fish fish;

	private Map<String, List<Behavior>> behaviors;

	public BehaviorsDTO() {
		this.behaviors = new LinkedHashMap<String, List<Behavior>>();
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
}
