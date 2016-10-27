package com.jean.entity.bait;

import java.sql.Date;

public class DateHolder {

    private Date start_period;
    private Date end_period;

    public Date getStart_period() {
	return start_period;
    }

    public void setStart_period(Date start_period) {
	this.start_period = start_period;
    }

    public Date getEnd_period() {
	return end_period;
    }

    public void setEnd_period(Date end_period) {
	this.end_period = end_period;
    }

    public DateHolder() {
	super();
    }

    public DateHolder(Date start_period, Date end_period) {
	super();
	this.start_period = start_period;
	this.end_period = end_period;
    }

	@Override
	public String toString() {
		return "DateHolder [start_period=" + start_period + ", end_period=" + end_period + "]";
	}
    
    

}
