package com.jean.analyzers.fish;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jean.DaoDfmException;
import com.jean.analyzers.weather.NibblePoint;
import com.jean.analyzers.weather.ConstantsAnalyzer;
import com.jean.analyzers.weather.GeneralNibbleState;
import com.jean.analyzers.weather.NibbleChecker;
import com.jean.config.property.MessagesProperties;
import com.jean.entity.DayActivity;
import com.jean.entity.Fish;
import com.jean.entity.FishSetting;
import com.jean.entity.HourWeather;
import com.jean.entity.NibblePeriod;
import com.jean.enums.DaysActivity;
import com.jean.enums.ParamNames;
import com.jean.util.Utils;

@Component
public class BehaviorAnalyzerImpl implements BehaviorAnalyzer {

	@Autowired
	private NibbleChecker nibbleChecker;

	@Autowired
	private MessagesProperties messagesProperties;
	
	/*@Autowired
	private BaitConstructor baitConstructor;*/

	private static Map<Double, String> messages = new HashMap<Double, String>();

	@Override
	public BehaviorDTO getFishBehavior(List<HourWeather> hourWeathers, Fish fish) throws DaoDfmException {

		BehaviorDTO behaviorDTO = new BehaviorDTO();
		GeneralNibbleState nibbleState = getGeneralNibble(hourWeathers);
		behaviorDTO.setNibbleState(nibbleState);

		messages.put(-10.0, messagesProperties.getSpawning());
		messages.put(1.0, messagesProperties.getToolow());
		messages.put(2.0, messagesProperties.getVeryLow());
		messages.put(3.0, messagesProperties.getLow());
		messages.put(4.0, messagesProperties.getBelowAvarage());
		messages.put(5.0, messagesProperties.getAvarage());
		messages.put(6.0, messagesProperties.getAboveAvarage());
		messages.put(7.0, messagesProperties.getGood());
		messages.put(8.0, messagesProperties.getPrettyGood());
		messages.put(9.0, messagesProperties.getVeryGood());
		messages.put(10.0, messagesProperties.getPerfect());

		for (HourWeather hourWeather : hourWeathers) {

			double result = nibbleState.getNibbleLevel();
			NibblePoint conrolPoint = new NibblePoint();

			for (FishSetting fishSetting : fish.getFishSetting()) {
				if (ParamNames.ENVIRMOMENT_TEMPERATURE.name().equals(fishSetting.getParamName())
						&& (hourWeather.getGeneralTemp() > fishSetting.getMinValue()
								&& hourWeather.getGeneralTemp() < fishSetting.getMaxValue())) {
					result += fishSetting.getNibbleLevel();
					break;
				}
			}

			for (Map.Entry<String, Double> entry : fish.getPressureStates().entrySet()) {
				if (entry.getKey().equals(nibbleState.getMessage())) {
					result += entry.getValue();
				}
			}

			String time = hourWeather.getDateText().substring(11);

			for (DayActivity dayActivity : fish.getDaysActivity()) {
				if (dayActivity.getActivityName().equals(DaysActivity.MORNING.name())
						&& (time.equals("6:00:00") || time.equals("9:00:00"))) {
					result += ConstantsAnalyzer.DAY_ACTIVITY_POINT;
				}
				if (dayActivity.getActivityName().equals(DaysActivity.DAY.name())
						&& (time.equals("9:00:00") || time.equals("12:00:00") || time.equals("15:00:00"))) {
					result += ConstantsAnalyzer.DAY_ACTIVITY_POINT;
				}
				if (dayActivity.getActivityName().equals(DaysActivity.EVENING.name())
						&& (time.equals("18:00:00") || time.equals("21:00:00"))) {
					result += ConstantsAnalyzer.DAY_ACTIVITY_POINT;
				}
				if (dayActivity.getActivityName().equals(DaysActivity.NIGHT.name())
						&& (time.equals("00:00:00") || time.equals("3:00:00"))) {
					result += ConstantsAnalyzer.DAY_ACTIVITY_POINT;
				}
			}

			result += nibbleChecker.isRain(hourWeather.getRainVolume());
			result += nibbleChecker.isWind(hourWeather.getWindDeg(), hourWeather.getWindSpeed());

			for (NibblePeriod nibblePeriod : fish.getNibbles()) {
				if (Utils.getJavaUtilDate(hourWeather.getDateText()).after(nibblePeriod.getStartPeriod())
						&& Utils.getJavaUtilDate(hourWeather.getDateText()).before(nibblePeriod.getEndPeriod())) {
					if (nibblePeriod.getNibbleLevel() == -10) {
						result = 0;
					} else {
						result += nibblePeriod.getNibbleLevel();
					}
				}
			}

			if(result > 10){
				result = 10;
			}else if(result < 0){
				result = 0;
			}
			
			conrolPoint.setMessage(messages.get(result));
			conrolPoint.setNibbleLevel(result);
			conrolPoint.setTime(hourWeather.getDateText().substring(11));

			behaviorDTO.getControlPoints().add(conrolPoint);
		}
		return behaviorDTO;

	}

	private GeneralNibbleState getGeneralNibble(List<HourWeather> hourWeathers) {

		GeneralNibbleState nibbleState = null;
		double[] press = new double[hourWeathers.size() - 1];

		for (int i = 0; i < hourWeathers.size() - 1; i++) {
			HourWeather hourWeather = hourWeathers.get(i);
			press[i] = hourWeather.getPressure();
		}
		nibbleState = nibbleChecker.checkPressure(press);
		return nibbleState;
	}

	private double perfomanceToCustomer(double result) {
		return result + (5 * Math.random());
	}
}
