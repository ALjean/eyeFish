package com.jean.analyzers.weather;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class WindDirectionConverter {

	private Map<DirectionMap, MinMaxHolder> degreesMap;
	private Map<Integer, MinMaxHolder> bofortScale;
	
	private static volatile WindDirectionConverter instance;

	public DirectionMap getDirectionObject(double degrees) {
		
		DirectionMap result = new DirectionMap("", 0.0);

		for (Entry<DirectionMap, MinMaxHolder> entry : degreesMap.entrySet()) {
			if ((entry.getValue().startValue <= degrees
					& entry.getValue().endValue >= degrees) || entry.getValue().endValue == degrees) {
				result = entry.getKey();
			}
		}
		return result;
	}
	
	public static WindDirectionConverter getInstance() {
		if (instance == null) {
			synchronized (WindDirectionConverter.class) {
				if (instance == null) {
					instance = new WindDirectionConverter();
				}
			}
		}
		return instance;
	}
 
	public Map<Integer, MinMaxHolder> getBofortScale(){
		return bofortScale;		
	}

	public class MinMaxHolder {

		private float startValue;
		private float endValue;

		public MinMaxHolder(float startDegree, float endDegree) {
			super();
			this.startValue = startDegree;
			this.endValue = endDegree;
		}

		public float getStartValue() {
			return startValue;
		}

		public float getEndValue() {
			return endValue;
		}

	}
	
	public class DirectionMap {
		
		private String direction;
		private double activity;
		
		public DirectionMap(String direction, double activity) {
			super();
			this.direction = direction;
			this.activity = activity;
		}

		public String getDirection() {
			return direction;
		}

		public double getActivity() {
			return activity;
		}
	
	}

	private WindDirectionConverter() {

		this.degreesMap = new HashMap<DirectionMap,MinMaxHolder>();

		degreesMap.put(new DirectionMap("N", 6.5), new MinMaxHolder(348.76f, 11.25f));
		degreesMap.put(new DirectionMap("NNE", 8.32), new MinMaxHolder(11.26f, 33.75f));
		degreesMap.put(new DirectionMap("NE", 25.12), new MinMaxHolder(33.76f, 56.25f));
		degreesMap.put(new DirectionMap("ENE", 51.32), new MinMaxHolder(56.26f, 78.75f));
		degreesMap.put(new DirectionMap("E", 70.32), new MinMaxHolder(78.76f, 101.25f));
		degreesMap.put(new DirectionMap("ESE", 75.14), new MinMaxHolder(101.26f, 123.75f));
		degreesMap.put(new DirectionMap("SE", 80.32), new MinMaxHolder(123.76f, 146.25f));
		degreesMap.put(new DirectionMap("SSE", 88.18), new MinMaxHolder(146.26f, 168.75f));
		degreesMap.put(new DirectionMap("S", 99.22), new MinMaxHolder(168.76f, 191.25f));
		degreesMap.put(new DirectionMap("SSW", 62.87), new MinMaxHolder(191.26f, 213.75f));
		degreesMap.put(new DirectionMap("SW", 50.32), new MinMaxHolder(213.76f, 236.25f));
		degreesMap.put(new DirectionMap("WSW", 42.09), new MinMaxHolder(236.26f, 258.75f));
		degreesMap.put(new DirectionMap("W", 30.56), new MinMaxHolder(258.76f, 281.25f));
		degreesMap.put(new DirectionMap("WNW", 25.14), new MinMaxHolder(281.26f, 303.75f));
		degreesMap.put(new DirectionMap("NW", 8.69), new MinMaxHolder(303.76f, 326.25f));
		degreesMap.put(new DirectionMap("NNW", 7.52), new MinMaxHolder(326.26f, 348.75f));
		
		this.bofortScale = new HashMap<Integer, MinMaxHolder>();
		
		bofortScale.put(0, new MinMaxHolder(0, 0.2f));
		bofortScale.put(1, new MinMaxHolder(0.3f, 1.5f));
		bofortScale.put(2, new MinMaxHolder(1.6f, 3.3f));
		bofortScale.put(3, new MinMaxHolder(3.4f, 5.4f));
		bofortScale.put(4, new MinMaxHolder(5.5f, 7.9f));
		bofortScale.put(5, new MinMaxHolder(8.0f, 70.7f));
		bofortScale.put(6, new MinMaxHolder(10.8f, 13.8f));
		bofortScale.put(7, new MinMaxHolder(13.9f, 17.1f));
		bofortScale.put(8, new MinMaxHolder(17.2f, 20.7f));
		bofortScale.put(9, new MinMaxHolder(20.8f, 24.4f));
		bofortScale.put(10, new MinMaxHolder(24.5f, 28.4f));
		bofortScale.put(11, new MinMaxHolder(28.5f, 32.6f));	
	}
}
