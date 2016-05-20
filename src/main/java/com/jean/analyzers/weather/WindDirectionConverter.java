package com.jean.analyzers.weather;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class WindDirectionConverter {

	private Map<Direction, MinMaxHolder> degreesMap;

	public Direction getDirection(double degrees) {

		Direction result = new Direction("", 0.0);

		for (Entry<Direction, MinMaxHolder> entry : degreesMap.entrySet()) {
			if ((entry.getValue().startValue <= degrees & entry.getValue().endValue >= degrees)
					|| entry.getValue().endValue == degrees) {
				result = entry.getKey();
			}
		}
		return result;
	}

	public class MinMaxHolder {

		private float startValue;
		private float endValue;

		public MinMaxHolder(float startDegree, float endDegree) {
			super();
			this.startValue = startDegree;
			this.endValue = endDegree;
		}
	}

	public class Direction {

		private String way;
		private double activity;

		public String getWay() {
			return way;
		}

		public double getActivity() {
			return activity;
		}

		public Direction(String direction, double activity) {
			super();
			this.way = direction;
			this.activity = activity;
		}
	}

	public WindDirectionConverter() {

		this.degreesMap = new HashMap<Direction, MinMaxHolder>();

		degreesMap.put(new Direction("N", ConstantsAnalyzer.WIND_NIBBLE_N), new MinMaxHolder(348.76f, 11.25f));
		degreesMap.put(new Direction("NNE", ConstantsAnalyzer.WIND_NIBBLE_NNE), new MinMaxHolder(11.26f, 33.75f));
		degreesMap.put(new Direction("NE", ConstantsAnalyzer.WIND_NIBBLE_NE), new MinMaxHolder(33.76f, 56.25f));
		degreesMap.put(new Direction("ENE", ConstantsAnalyzer.WIND_NIBBLE_ENE), new MinMaxHolder(56.26f, 78.75f));
		degreesMap.put(new Direction("E", ConstantsAnalyzer.WIND_NIBBLE_E), new MinMaxHolder(78.76f, 101.25f));
		degreesMap.put(new Direction("ESE", ConstantsAnalyzer.WIND_NIBBLE_ESE), new MinMaxHolder(101.26f, 123.75f));
		degreesMap.put(new Direction("SE", ConstantsAnalyzer.WIND_NIBBLE_SE), new MinMaxHolder(123.76f, 146.25f));
		degreesMap.put(new Direction("SSE", ConstantsAnalyzer.WIND_NIBBLE_SSE), new MinMaxHolder(146.26f, 168.75f));
		degreesMap.put(new Direction("S", ConstantsAnalyzer.WIND_NIBBLE_S), new MinMaxHolder(168.76f, 191.25f));
		degreesMap.put(new Direction("SSW", ConstantsAnalyzer.WIND_NIBBLE_SSW), new MinMaxHolder(191.26f, 213.75f));
		degreesMap.put(new Direction("SW", ConstantsAnalyzer.WIND_NIBBLE_SW), new MinMaxHolder(213.76f, 236.25f));
		degreesMap.put(new Direction("WSW", ConstantsAnalyzer.WIND_NIBBLE_WSW), new MinMaxHolder(236.26f, 258.75f));
		degreesMap.put(new Direction("W", ConstantsAnalyzer.WIND_NIBBLE_W), new MinMaxHolder(258.76f, 281.25f));
		degreesMap.put(new Direction("WNW", ConstantsAnalyzer.WIND_NIBBLE_WNW), new MinMaxHolder(281.26f, 303.75f));
		degreesMap.put(new Direction("NW", ConstantsAnalyzer.WIND_NIBBLE_NW), new MinMaxHolder(303.76f, 326.25f));
		degreesMap.put(new Direction("NNW", ConstantsAnalyzer.WIND_NIBBLE_NNW), new MinMaxHolder(326.26f, 348.75f));

	}
}
