package com.jean.entity.bait;

import com.jean.entity.BaseEntry;

import javax.persistence.Table;
import java.sql.Date;

@Table(name = "baits_to_seasons")
public class DateHolder extends BaseEntry {

    private Bait bait;
    private Date startPeriod;
    private Date endPeriod;


    public Bait getBait() {
        return bait;
    }

    public void setBait(Bait bait) {
        this.bait = bait;
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

    public DateHolder() {
    }

    public DateHolder(Date startPeriod, Date endPeriod, Bait bait) {
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
        this.bait = bait;
    }



}
