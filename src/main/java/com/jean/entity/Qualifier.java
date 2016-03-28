package com.jean.entity;

import java.util.List;

public class Qualifier {

    private int qualifierId;
    private ParameterName parameterName;
    private List<RangeHolder> ranges;

    public int getQualifierId() {
	return qualifierId;
    }

    public void setQualifierId(int qualifierId) {
	this.qualifierId = qualifierId;
    }

    public ParameterName getParameterName() {
	return parameterName;
    }

    public void setParameterName(ParameterName parameterName) {
	this.parameterName = parameterName;
    }

    public List<RangeHolder> getRanges() {
	return ranges;
    }

    public void setRanges(List<RangeHolder> ranges) {
	this.ranges = ranges;
    }

    @Override
    public String toString() {
	return "ColorQualifier [qualifierId=" + qualifierId + ", parameterName=" + parameterName + ", ranges=" + ranges + "]";
    }

    public Qualifier() {
	super();
    }

    public Qualifier(int qualifierId, ParameterName parameterName, List<RangeHolder> ranges) {
	super();
	this.qualifierId = qualifierId;
	this.parameterName = parameterName;
	this.ranges = ranges;
    }

}
