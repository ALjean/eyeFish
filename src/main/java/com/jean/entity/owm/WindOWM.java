package com.jean.entity.owm;

/**
 * Created by Alex on 06.08.15.
 */
public class WindOWM {

    private float speed;

    private float deg;

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getDeg() {
        return deg;
    }

    public void setDeg(float deg) {
        this.deg = deg;
    }

    @Override
    public String toString() {
        return "Wind [speed=" + speed + ", deg=" + deg + "]";
    }
}
