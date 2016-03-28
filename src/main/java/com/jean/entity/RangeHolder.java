package com.jean.entity;

public class RangeHolder {

    private double minLevel;
    private double maxlevel;

    public double getMinLevel() {
	return minLevel;
    }

    public void setMinLevel(double minLevel) {
	this.minLevel = minLevel;
    }

    public double getMaxlevel() {
	return maxlevel;
    }

    public void setMaxlevel(double maxlevel) {
	this.maxlevel = maxlevel;
    }

    @Override
    public String toString() {
	return "RangeHolder [minLevel=" + minLevel + ", maxlevel=" + maxlevel + "]";
    }

    public RangeHolder() {
	super();
    }

    public RangeHolder(double minLevel, double maxlevel) {
	super();
	this.minLevel = minLevel;
	this.maxlevel = maxlevel;
    }

}
