package com.jean.analyzers.weather;

import java.util.List;

import com.jean.entity.Bait;

public class AnalyzerResultObject {

    private double nightActivity;
    private double morningActivity;
    private double dayActivity;
    private double eveningActivity;

    private double generalActivity;

    private List<Bait> baits;

    public double getNightActivity() {
	return nightActivity;
    }

    public void setNightActivity(double nightActivity) {
	this.nightActivity = nightActivity;
    }

    public double getMorningActivity() {
	return morningActivity;
    }

    public void setMorningActivity(double morningActivity) {
	this.morningActivity = morningActivity;
    }

    public double getDayActivity() {
	return dayActivity;
    }

    public void setDayActivity(double dayActivity) {
	this.dayActivity = dayActivity;
    }

    public double getEveningActivity() {
	return eveningActivity;
    }

    public void setEveningActivity(double eveningActivity) {
	this.eveningActivity = eveningActivity;
    }

    public double getGeneralActivity() {
	return generalActivity;
    }

    public void setGeneralActivity(double generalActivity) {
	this.generalActivity = generalActivity;
    }

    public List<Bait> getBaits() {
	return baits;
    }

    public void setBaits(List<Bait> baits) {
	this.baits = baits;
    }

    @Override
    public String toString() {
	return "AnalyzerResultObject [nightActivity=" + nightActivity + ", morningActivity=" + morningActivity + ", dayActivity=" + dayActivity
		+ ", eveningActivity=" + eveningActivity + ", generalActivity=" + generalActivity + ", baits=" + baits + "]";
    }

}
