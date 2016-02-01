package com.jean.entity;

/**
 * Created by Stas on 15.11.2015.
 */
public class FishParameters {

    private int id;
    private String stateDataType;
    private double minValue;
    private double maxValue;
    private float nibble;
    

    public String getStateDataType() {
        return stateDataType;
    }

    public void setStateDataType(String stateDataType) {
        this.stateDataType = stateDataType;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
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
