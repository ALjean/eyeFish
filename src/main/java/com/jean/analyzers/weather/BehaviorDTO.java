package com.jean.analyzers.weather;

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
		super();
	}

	public BehaviorDTO(List<ConrolPointHolder> controlPoints) {
		super();
		this.controlPoints = controlPoints;
	}

	@Override
	public String toString() {
		return "BehaviorDTO [controlPoints=" + controlPoints + "]";
	}

}
