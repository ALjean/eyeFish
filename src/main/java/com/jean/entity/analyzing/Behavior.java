package com.jean.entity.analyzing;

import java.util.ArrayList;
import java.util.List;

import com.jean.dao.entity.bait.Bait;

public class Behavior {

	private List<NibblePoint> NibblePoints;

	private GeneralNibbleState nibbleState;
	
	private List<Bait> baits;

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
		this.NibblePoints = new ArrayList<>();
	}
	
	public List<Bait> getBaits() {
		return baits;
	}

	public void setBaits(List<Bait> baits) {
		this.baits = baits;
	}

	@Override
	public String toString() {
		return "Behavior [NibblePoints=" + NibblePoints + ", nibbleState=" + nibbleState + "]";
	}

}
