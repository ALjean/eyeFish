package com.jean.entity;

/**
 * Created by Stas on 15.11.2015.
 */
public class NibbleStateParam {

    private int id;
    private int minValue;
    private int maxValue;
    private float nibble;

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public float getNibble() {
        return nibble;
    }

    public void setNibble(float nibble) {
        this.nibble = nibble;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
