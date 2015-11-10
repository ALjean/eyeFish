package com.jean.analyzers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AnalyzerResultObject {

	private double weatherStateResult;
	private double windResult;
	private double pressureResult;
	private double badWeatherResult;

	private Date currentDate;
	private Map<Integer, Double> priorityMap;

	public AnalyzerResultObject(double weatherStateResult, double windResult,
								double pressureResult, double badWeatherResult, Date date) {

		this.weatherStateResult = weatherStateResult;
		this.windResult = windResult;
		this.pressureResult = pressureResult;
		this.badWeatherResult = badWeatherResult;

		this.setDate(date);
		this.priorityMap = new HashMap<Integer, Double>();

		if (date.equals(new Date())) {
			// Some logic which helps create priority for each other result
			// depends on year time
		}
	}

	public double getWeatherStateResult() {
		return weatherStateResult;
	}

	public void setWeatherStateResult(double weatherStateResult) {
		this.weatherStateResult = weatherStateResult;
	}

	public double getWindResult() {
		return windResult;
	}

	public void setWindResult(double windResult) {
		this.windResult = windResult;
	}

	public double getPressureResult() {
		return pressureResult;
	}

	public void setPressureResult(double pressureResult) {
		this.pressureResult = pressureResult;
	}

	public Map<Integer, Double> getPriorityMap() {
		return priorityMap;
	}

	public Date getDate() {
		return currentDate;
	}

	public void setDate(Date date) {
		this.currentDate = date;
	}

	public double getBadWeatherResult() {
		return badWeatherResult;
	}

	public void setBadWeatherResult(double badWeatherResult) {
		this.badWeatherResult = badWeatherResult;
	}

	@Override
	public String toString() {
		return "AnalisationResultObject [weatherStateResult="
				+ weatherStateResult + ", windResult=" + windResult
				+ ", pressureResult=" + pressureResult + "]";
	}

}
