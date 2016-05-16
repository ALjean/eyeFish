package com.jean.analyzers.weather;

import java.util.ArrayList;
import java.util.List;

public class BehaviorDTO {

	private List<ConrolPointHolder> controlPoints;

	public List<ConrolPointHolder> getControlPoints() {
		return controlPoints;
	}

	public void setControlPoints(List<ConrolPointHolder> controlPoints) {
		this.controlPoints = controlPoints;
	}

	public BehaviorDTO() {
		this.controlPoints = new ArrayList<ConrolPointHolder>();
	}

	@Override
	public String toString() {
		return "BehaviorDTO [controlPoints=" + controlPoints + "]";
	}

}
