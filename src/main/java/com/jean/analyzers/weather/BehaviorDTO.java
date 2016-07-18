package com.jean.analyzers.weather;

import java.util.ArrayList;
import java.util.List;

import com.jean.entity.Bait;

public class BehaviorDTO {

	private List<NibblePoint> NibblePoints;

	private GeneralNibbleState nibbleState;

	public List<NibblePoint> getControlPoints() {
		return NibblePoints;
	}

	public void setControlPoints(List<NibblePoint> controlPoints) {
		this.NibblePoints = controlPoints;
	}

	public GeneralNibbleState getNibbleState() {
		return nibbleState;
	}

	public void setNibbleState(GeneralNibbleState nibbleState) {
		this.nibbleState = nibbleState;
	}

	public BehaviorDTO() {
		this.NibblePoints = new ArrayList<NibblePoint>();
	}

	@Override
	public String toString() {
		return "BehaviorDTO [controlPoints=" + NibblePoints + ", nibbleState=" + nibbleState + "]";
	}

}
