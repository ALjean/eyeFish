package com.jean.analyzers.weather;

import java.util.ArrayList;
import java.util.List;

import com.jean.entity.Bait;

public class BehaviorDTO {

	private List<ConrolPointHolder> controlPoints;

	private GeneralNibbleState nibbleState;

	public List<ConrolPointHolder> getControlPoints() {
		return controlPoints;
	}

	public void setControlPoints(List<ConrolPointHolder> controlPoints) {
		this.controlPoints = controlPoints;
	}

	public BehaviorDTO() {
		this.controlPoints = new ArrayList<ConrolPointHolder>();
	}

	public GeneralNibbleState getNibbleState() {
		return nibbleState;
	}

	public void setNibbleState(GeneralNibbleState nibbleState) {
		this.nibbleState = nibbleState;
	}

	@Override
	public String toString() {
		return "BehaviorDTO [controlPoints=" + controlPoints + ", nibbleState=" + nibbleState + "]";
	}

}
