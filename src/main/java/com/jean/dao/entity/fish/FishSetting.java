package com.jean.dao.entity.fish;

import com.jean.dao.entity.BaseEntityAudit;

import javax.persistence.*;

/**
 * Created by Stas on 15.11.2015.
 */
@Entity
@Table(name = "fish_settings")
public class FishSetting extends BaseEntityAudit {


	@ManyToOne
	@JoinColumn(name = "fish_id")
	private Fish fish;

	@Column(name = "param_name")
	private String paramName;

	@Column(name = "min_value")
	private float minValue;

	@Column(name = "man_value")
	private float maxValue;

	@Column(name = "nibble_level")
	private float nibbleLevel;


	public Fish getFish() {
		return fish;
	}

	public void setFish(Fish fish) {
		this.fish = fish;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public float getMinValue() {
		return minValue;
	}

	public void setMinValue(float minValue) {
		this.minValue = minValue;
	}

	public float getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(float maxValue) {
		this.maxValue = maxValue;
	}

	public float getNibbleLevel() {
		return nibbleLevel;
	}

	public void setNibbleLevel(float nibbleLevel) {
		this.nibbleLevel = nibbleLevel;
	}

	public FishSetting() {

	}

	public FishSetting(long id, Fish fish, String paramName, float minValue, float maxValue, float nibbleLevel) {
		this.id = id;
		this.paramName = paramName;
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.nibbleLevel = nibbleLevel;
	}


}
