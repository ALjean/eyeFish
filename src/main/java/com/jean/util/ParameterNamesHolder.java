package com.jean.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jean.enums.ParamNames;

public class ParameterNamesHolder {

	private final static String ENV_TEMP = "ENVIRMOMENT_TEMPERATURE";
	private final static String WATER_TEMP = "WATER_TEMPERATURE";
	private final static String CLOUD = "CLOUD_LEVEL";
	private final static String ALGA = "ALGA_LEVEL";
	private final static String DEEP = "DEEP_LEVEL";
	private final static String RAIN = "RAIN_LEVEL";
	private final static String WIND = "WIND_SPEED";
	private final static String PRESSURE = "PRESSURE";

	public static List<ParameterName> paramNames;

	public ParameterNamesHolder() {
		super();
		this.paramNames = new ArrayList<ParameterName>();

		paramNames.add(new ParameterName(ENV_TEMP, -50, 60));
		paramNames.add(new ParameterName(WATER_TEMP, 0, 40));
		paramNames.add(new ParameterName(CLOUD, 0, 100));
		paramNames.add(new ParameterName(ALGA, 0, 100));
		paramNames.add(new ParameterName(DEEP, 0.2, 25));
		paramNames.add(new ParameterName(RAIN, 0, 10));
		paramNames.add(new ParameterName(WIND, 0, 40));
		paramNames.add(new ParameterName(PRESSURE, 600, 900));
	}

}
