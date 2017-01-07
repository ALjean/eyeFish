package com.jean.entity.bait;

import com.jean.entity.BaseEntity;
import com.jean.entity.BaseEntityAudit;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "baits_to_seasons")
public class DateHolder extends BaseEntityAudit {

    @ManyToOne
    @JoinColumn(name = "bait_id")
    private Bait bait;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_period", nullable = false)
    private Date startPeriod;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_period", nullable = false)
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

    public DateHolder(long id, Date startPeriod, Date endPeriod, Bait bait) {
        this.id = id;
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
        this.bait = bait;
    }



}
