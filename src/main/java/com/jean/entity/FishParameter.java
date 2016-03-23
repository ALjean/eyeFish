package com.jean.entity;

import com.jean.enums.ParamNames;

/**
 * Created by Stas on 15.11.2015.
 */
public class FishParameter {

    private int id;
    private int fishId;
    private ParamNames stateDataType;
    private double minValue;
    private double maxValue;
    private float nibble;


    public ParamNames getStateDataType() {
        return stateDataType;
    }

    public void setStateDataType(ParamNames stateDataType) {
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

    public int getFishId() {
        return fishId;
    }

    public void setFishId(int fishId) {
        this.fishId = fishId;
    }
}
