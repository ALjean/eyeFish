package com.jean.util;

import java.util.ArrayList;
import java.util.List;
import com.jean.enums.ParamNames;

public class ParameterNamesHolder {

    private static List<ParameterName> paramNames;

    static {
	paramNames = new ArrayList<ParameterName>();

	paramNames.add(new ParameterName(ParamNames.ENVIRMOMENT_TEMPERATURE.name(), -50, 60));
	paramNames.add(new ParameterName(ParamNames.WATER_TEMPERATURE.name(), 0, 40));
	paramNames.add(new ParameterName(ParamNames.CLOUD_LEVEL.name(), 0, 100));
	paramNames.add(new ParameterName(ParamNames.ALGA_LEVEL.name(), 0, 100));
	paramNames.add(new ParameterName(ParamNames.DEEP_LEVEL.name(), 0.2, 25));
	paramNames.add(new ParameterName(ParamNames.RAIN_LEVEL.name(), 0, 10));
	paramNames.add(new ParameterName(ParamNames.WIND_SPEED.name(), 0, 40));
	paramNames.add(new ParameterName(ParamNames.PRESSURE.name(), 600, 900));
    }

    public static ParameterName getParamName(String name) {
	ParameterName result = new ParameterName();
	for (ParameterName paramName : paramNames) {
	    if (name.equalsIgnoreCase(paramName.getParamName()))
		result = paramName;
	}
	return result;
    }

}
