package com.jean.analyzers.fish;

import java.util.ArrayList;
import java.util.List;

import com.jean.analyzers.weather.GeneralNibbleState;
import com.jean.analyzers.weather.NibblePoint;

public class BehaviorDTO {

	private int fishId;

	private String fishName;

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

	public int getFishId() {
		return fishId;
	}

	public void setFishId(int fishId) {
		this.fishId = fishId;
	}

	public String getFishName() {
		return fishName;
	}

	public void setFishName(String fishName) {
		this.fishName = fishName;
	}

	@Override
	public String toString() {
		return "BehaviorDTO [fishId=" + fishId + ", fishName=" + fishName + ", NibblePoints=" + NibblePoints
				+ ", nibbleState=" + nibbleState + "]";
	}

}
