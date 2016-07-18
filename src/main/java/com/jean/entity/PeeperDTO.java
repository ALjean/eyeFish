package com.jean.entity;

public class PeeperDTO {

	private float waterTemperature;
	private float algaLevel;
	private float deepLevel;

	public float getWaterTemperature() {
		return waterTemperature;
	}

	public void setWaterTemperature(float waterTemperature) {
		this.waterTemperature = waterTemperature;
	}

	public float getAlgaLevel() {
		return algaLevel;
	}

	public void setAlgaLevel(float algaLevel) {
		this.algaLevel = algaLevel;
	}

	public float getDeepLevel() {
		return deepLevel;
	}

	public void setDeepLevel(float deepLevel) {
		this.deepLevel = deepLevel;
	}

	public PeeperDTO() {
		super();
	}

	public PeeperDTO(float waterTemperature, float algaLevel, float deepLevel) {
		super();
		this.waterTemperature = waterTemperature;
		this.algaLevel = algaLevel;
		this.deepLevel = deepLevel;
	}

	@Override
	public String toString() {
		return "PeeperDTO [waterTemperature=" + waterTemperature + ", algaLevel=" + algaLevel + ", deepLevel="
				+ deepLevel + "]";
	}

}
