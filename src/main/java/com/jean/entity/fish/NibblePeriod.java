package com.jean.entity.fish;


import com.jean.entity.BaseEntityAudit;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by jean on 12.03.16.
 */

@Entity
@Table(name = "nibble_period")
public class NibblePeriod extends BaseEntityAudit {


	@ManyToOne
	@JoinColumn(name = "fish_id")
	private Fish fish;


	@Column(name = "start_period")
	private Date startPeriod;

	@Column(name = "end_period")
	private Date endPeriod;

	@Column(name = "nibble_level")
	private float nibbleLevel;

	public Fish getFish() {
		return fish;
	}

	public void setFish(Fish fish) {
		this.fish = fish;
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

	public float getNibbleLevel() {
		return nibbleLevel;
	}

	public void setNibbleLevel(float nibbleLevel) {
		this.nibbleLevel = nibbleLevel;
	}

	public NibblePeriod() {

	}

	public NibblePeriod(Long id, Fish fish, Date startPeriod, Date endPeriod, float nibbleLevel) {
		this.id = id;
		this.fish = fish;
		this.startPeriod = startPeriod;
		this.endPeriod = endPeriod;
		this.nibbleLevel = nibbleLevel;
	}


}
