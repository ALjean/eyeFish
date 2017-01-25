package com.jean.analyzers.checkers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jean.BehaviorConstants;
import com.jean.entity.analyzing.GeneralNibbleState;
import com.jean.enums.PressureStates;

@Component
public class NibbleCheckerImpl implements NibbleChecker {

	@Override
	public float isRain(double rain) {

		float result = 0;
		if (rain >= BehaviorConstants.MAX_RAIN_VOLUME) {
			result = BehaviorConstants.HEAVY_RAIN_POINT;
		} else if (rain > BehaviorConstants.MIN_RAIN_VOLUME && rain <= BehaviorConstants.MIN_RAIN_VOLUME) {
			result = BehaviorConstants.LIGHT_RAIN_POINT;
		}
		return result;
	}

	@Override
	public float isWind(double degrees, double speed) {

		float result = 0;

		if (speed > BehaviorConstants.CRITICAL_WIND_SPEED) {
			result = BehaviorConstants.WIND_POINT;
		}
		return result;
	}

	@Override
	public GeneralNibbleState checkPressure(double[] press) {

		GeneralNibbleState pressureState = new GeneralNibbleState();
		int countHigh = 0;
		int countLow = 0;

		if (isStability(press, BehaviorConstants.MAX_PRESSURE_CHANGES)) {
			if (isStability(press, BehaviorConstants.MIN_PRESSURE_CHANGES)) {
				for (int i = 0; i < press.length; i++) {
					if (press[i] >= BehaviorConstants.HIGH_PRESSURE_LEVEL) {
						countHigh++;
					} else if (press[i] <= BehaviorConstants.LOW_PRESSURE_LEVEL) {
						countLow++;
					}
				}
				if (countHigh == press.length) {
					pressureState.setNibbleLevel(BehaviorConstants.HIGH_PRESSURE_POINT);
					pressureState.setMessage(PressureStates.IS_STABILITY_HIGH.name());
				} else if (countLow == press.length) {
					pressureState.setNibbleLevel(BehaviorConstants.LOW_PRESSURE_POINT);
					pressureState.setMessage(PressureStates.IS_STABILITY_LOW.name());
				} else if (pressureState.getNibbleLevel() == 0) {
					pressureState.setNibbleLevel(BehaviorConstants.STABILITY_PRESSURE_POINT);
					pressureState.setMessage(PressureStates.IS_STABILITY.name());
				}
			} else {
				if (press[press.length - 1] - press[0] > 0) {
					pressureState.setNibbleLevel(BehaviorConstants.RISE_PRESSURE_POINT);
					pressureState.setMessage(PressureStates.IS_RISE.name());
				} else {
					pressureState.setNibbleLevel(BehaviorConstants.DOWN_PRESSURE_POINT);
					pressureState.setMessage(PressureStates.IS_DOWN.name());
				}
			}
		} else {
			pressureState.setNibbleLevel(BehaviorConstants.UNSTABILITY_PRESSURE_POINT);
			pressureState.setMessage(PressureStates.IS_UNSTABILITY.name());
		}
		return pressureState;
	}

	public GeneralNibbleState checkPressure(List<Float> press) {

		GeneralNibbleState generalNibbleState = new GeneralNibbleState();

		if (isStabilityPres(press)) {
			if (isHighPres(press)) {
				generalNibbleState.setNibbleLevel(BehaviorConstants.HIGH_PRESSURE_POINT);
				generalNibbleState.setMessage(PressureStates.IS_STABILITY_HIGH.name());
				return generalNibbleState;
			} else if (isLowPres(press)) {
				generalNibbleState.setNibbleLevel(BehaviorConstants.LOW_PRESSURE_POINT);
				generalNibbleState.setMessage(PressureStates.IS_STABILITY_LOW.name());
				return generalNibbleState;
			} else if (isRisePres(press)) {
				generalNibbleState.setNibbleLevel(BehaviorConstants.RISE_PRESSURE_POINT);
				generalNibbleState.setMessage(PressureStates.IS_RISE.name());
				return generalNibbleState;
			} else {
				generalNibbleState.setNibbleLevel(BehaviorConstants.DOWN_PRESSURE_POINT);
				generalNibbleState.setMessage(PressureStates.IS_DOWN.name());
				return generalNibbleState;
			}
		} else {
			generalNibbleState.setNibbleLevel(BehaviorConstants.UNSTABILITY_PRESSURE_POINT);
			generalNibbleState.setMessage(PressureStates.IS_UNSTABILITY.name());
			return generalNibbleState;
		}

	}

	private boolean isStability(double[] params, double constantValue) {
		boolean result = false;
		int count = 0;

		for (int i = 0; i < params.length - 1; i++) {
			double changeRange = Math.abs(params[i + 1] - params[i]);
			if (changeRange == 0 || changeRange <= constantValue) {
				count++;
			}
		}
		if (count == params.length - 1) {
			result = true;
		}
		return result;
	}

	private static boolean isStabilityPres(List<Float> press) {

		boolean result = false;

		for (int i = 0; i < press.size() - 1; i++) {

			int count = i;
			float current = press.get(i);
			float next = press.get(++count);
			float compute = current - next;

			if (Math.abs(compute) < BehaviorConstants.MAX_PRESSURE_CHANGES) {
				result = true;
			} else {
				result = false;
				break;
			}
		}
		return result;
	}

	private static boolean isHighPres(List<Float> press) {

		boolean result = false;

		for (float pres : press) {
			if (pres >= BehaviorConstants.HIGH_PRESSURE_LEVEL) {
				result = true;
			} else {
				result = false;
				break;
			}
		}
		return result;
	}

	private static boolean isLowPres(List<Float> press) {

		boolean result = false;

		for (float pres : press) {
			if (pres <= BehaviorConstants.LOW_PRESSURE_LEVEL) {
				result = true;
			} else {
				result = false;
				break;
			}
		}
		return result;
	}

	private static boolean isRisePres(List<Float> press) {

		boolean result = false;

		if ((press.get(0) - press.get(press.size() - 1)) < 0) {
			result = true;
		}
		return result;
	}

	public static void main(String[] args) {
		List<Float> press = new ArrayList<Float>();
		press.add(741F);
		press.add(742F);
		press.add(743F);
		press.add(744F);
		press.add(745F);
		press.add(746F);
		press.add(747F);
		press.add(748F);
		press.add(740F);

		System.out.println(isStabilityPres(press));
		System.out.println(isHighPres(press));
		System.out.println(isLowPres(press));
		System.err.println(isRisePres(press));

	}
}
