package com.jean.analyzers.fish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jean.DaoDfmException;
import com.jean.analyzers.weather.NibblePoint;
import com.jean.analyzers.weather.BehaviorConstants;
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

	/*
	 * @Autowired private BaitConstructor baitConstructor;
	 */

	private static Map<Double, String> messages = new HashMap<Double, String>();

	@Override
	public BehaviorDTO getFishBehavior(List<HourWeather> hourWeathers, Fish fish) throws DaoDfmException {

		BehaviorDTO behaviorDTO = new BehaviorDTO();

		List<Float> press = new ArrayList<Float>();
		for (HourWeather hourWeather : hourWeathers) {
			press.add(hourWeather.getPressure());
		}

		GeneralNibbleState nibbleState = nibbleChecker.checkPressure(press);
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

			double generalResult = nibbleState.getNibbleLevel();
			double fishSettingResult = 0;
			double dayActivityResult = 0;
			double rainResult = 0;
			double windResult = 0;
			double periodResult = 0;

			List<Double> results = new ArrayList<Double>();

			NibblePoint conrolPoint = new NibblePoint();

			for (FishSetting fishSetting : fish.getFishSetting()) {
				if (ParamNames.ENVIRMOMENT_TEMPERATURE.name().equals(fishSetting.getParamName())
						&& (hourWeather.getGeneralTemp() > fishSetting.getMinValue()
								&& hourWeather.getGeneralTemp() < fishSetting.getMaxValue())) {
					results.add(fishSetting.getNibbleLevel());
				}
			}

			/*
			 * for (Map.Entry<String, Double> entry :
			 * fish.getPressureStates().entrySet()) { if
			 * (entry.getKey().equals(nibbleState.getMessage())) { generalResult
			 * += entry.getValue(); } }
			 */

			String time = hourWeather.getDateText().substring(11);

			for (DayActivity dayActivity : fish.getDaysActivity()) {
				if (dayActivity.getActivityName().equals(DaysActivity.MORNING.name())
						&& (time.equals("6:00:00") || time.equals("9:00:00"))) {
					results.add(BehaviorConstants.DAY_ACTIVITY_POINT);
				}
				if (dayActivity.getActivityName().equals(DaysActivity.DAY.name())
						&& (time.equals("9:00:00") || time.equals("12:00:00") || time.equals("15:00:00"))) {
					results.add(BehaviorConstants.DAY_ACTIVITY_POINT);
				}
				if (dayActivity.getActivityName().equals(DaysActivity.EVENING.name())
						&& (time.equals("18:00:00") || time.equals("21:00:00"))) {
					results.add(BehaviorConstants.DAY_ACTIVITY_POINT);
				}
				if (dayActivity.getActivityName().equals(DaysActivity.NIGHT.name())
						&& (time.equals("00:00:00") || time.equals("3:00:00"))) {
					results.add(BehaviorConstants.DAY_ACTIVITY_POINT);
				}
			}

			results.add(nibbleChecker.isRain(hourWeather.getRainVolume()));

			results.add(nibbleChecker.isWind(hourWeather.getWindDeg(), hourWeather.getWindSpeed()));

			for (NibblePeriod nibblePeriod : fish.getNibbles()) {
				if (Utils.getJavaUtilDate(hourWeather.getDateText()).after(nibblePeriod.getStartPeriod())
						&& Utils.getJavaUtilDate(hourWeather.getDateText()).before(nibblePeriod.getEndPeriod())) {
					results.add(nibblePeriod.getNibbleLevel());
				}
			}

			conrolPoint.setMessage(messages.get(generalResult));
			conrolPoint.setNibbleLevel(generalResult);
			conrolPoint.setTime(hourWeather.getDateText().substring(11));

			behaviorDTO.getControlPoints().add(conrolPoint);
		}
		return behaviorDTO;

	}

	private double prepareResult(List<Double> results, double generalResult) {

		double prepareResult = generalResult;

		for (Double result : results) {
			if (prepareResult >= 10) {
				if (result < 0 && result != -10) {
					prepareResult += result;
				}
			}else{
				prepareResult += result;
			}
		}
		return 0;

	}

}
