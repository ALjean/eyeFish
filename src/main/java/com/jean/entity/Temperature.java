package com.jean.entity;

/**
 * Created by Stas on 15.11.2015.
 */
public class Temperature {

    private int id;
    private int minValue;
    private int maxValue;
    private double nibble;

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

    public double getNibble() {
        return nibble;
    }

    public void setNibble(double nibble) {
        this.nibble = nibble;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
