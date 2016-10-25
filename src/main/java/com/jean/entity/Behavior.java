package com.jean.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jean.analyzers.weather.GeneralNibbleState;
import com.jean.analyzers.weather.NibblePoint;

public class Behavior {

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

	public Behavior() {
		this.NibblePoints = new ArrayList<NibblePoint>();
	}

	@Override
	public String toString() {
		return "Behavior [NibblePoints=" + NibblePoints + ", nibbleState=" + nibbleState + "]";
	}

}
