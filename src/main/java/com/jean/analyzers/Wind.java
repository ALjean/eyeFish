package com.jean.analyzers;

public class Wind {

	private String direction;
	private double speed;

	public Wind() {
		super();
	}

	public Wind(String direction, double speed) {
		super();
		this.direction = direction;
		this.speed = speed;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Wind [direction=" + direction + ", speed=" + speed + "]";
	}

}
