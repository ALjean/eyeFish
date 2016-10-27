package com.jean.entity.fish;

import java.sql.Date;

/**
 * Created by jean on 12.03.16.
 */
public class NibblePeriod {

	private int id;
	private int fishId;
	private Date startPeriod;
	private Date endPeriod;
	private double nibbleLevel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFishId() {
		return fishId;
	}

	public void setFishId(int fishId) {
		this.fishId = fishId;
	}

	public Date getStartPeriod() {
		return startPeriod;
	}

	public void setStartPeriod(Date startPeriod) {
		this.startPeriod = startPeriod;
	}

	public Date getEndPeriod() {
		return endPeriod;
	}

	public void setEndPeriod(Date endPeriod) {
		this.endPeriod = endPeriod;
	}

	public double getNibbleLevel() {
		return nibbleLevel;
	}

	public void setNibbleLevel(double nibbleLevel) {
		this.nibbleLevel = nibbleLevel;
	}

	public NibblePeriod() {
		super();
	}

	public NibblePeriod(int id, int fishId, Date startPeriod, Date endPeriod, double nibbleLevel) {
		super();
		this.id = id;
		this.fishId = fishId;
		this.startPeriod = startPeriod;
		this.endPeriod = endPeriod;
		this.nibbleLevel = nibbleLevel;
	}

	@Override
	public String toString() {
		return "NibblePeriod [id=" + id + ", fishId=" + fishId + ", startPeriod=" + startPeriod + ", endPeriod="
				+ endPeriod + ", nibbleLevel=" + nibbleLevel + "]";
	}

}
