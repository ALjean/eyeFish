package com.jean.util;

import java.util.ArrayList;
import java.util.List;

import com.jean.entity.DayWeather;
import com.jean.entity.GeneralWeather;
import com.jean.entity.HourWeather;
import com.jean.servlet.model.owm.GeneralWeatherStateOWM;
import com.jean.servlet.model.owm.detail.DayWeatherDataOWM;
import com.jean.servlet.model.owm.hours.HoursWeatherDataOWM;

public class MapperOWM {

	public static GeneralWeather parseOWM(GeneralWeatherStateOWM<DayWeatherDataOWM> dayWeatherOWM,
			GeneralWeatherStateOWM<HoursWeatherDataOWM> hourWeatherOWM) {

		GeneralWeather generalWeather = new GeneralWeather();
		List<DayWeather> dayWeathers = new ArrayList<DayWeather>();
		List<HourWeather> hourWeathers = new ArrayList<HourWeather>();

		generalWeather.setCityId((dayWeatherOWM.getCity().getId()));
		generalWeather.setCityName(dayWeatherOWM.getCity().getName());
		generalWeather.setCountry(dayWeatherOWM.getCity().getCountry());
		generalWeather.setCoordLat(dayWeatherOWM.getCity().getCoord().getLat());
		generalWeather.setCoordLon(dayWeatherOWM.getCity().getCoord().getLon());

		for (DayWeatherDataOWM dayWeatherDataOWM : dayWeatherOWM.getList()) {

			DayWeather dayWeather = new DayWeather();

			dayWeather.setClouds(dayWeatherDataOWM.getClouds());
			dayWeather.setCurrentDate(dayWeatherDataOWM.getDt());
			dayWeather.setHumidity(dayWeatherDataOWM.getHumidity());
			dayWeather.setPressure(dayWeatherDataOWM.getPressure());
			dayWeather.setRainVolume(dayWeatherDataOWM.getRain());
			dayWeather.setTempDay(dayWeatherDataOWM.getTemp().getDay());
			dayWeather.setTempEvening(dayWeatherDataOWM.getTemp().getEve());
			dayWeather.setTempMorning(dayWeatherDataOWM.getTemp().getMorn());
			dayWeather.setTempNight(dayWeatherDataOWM.getTemp().getNight());
			dayWeather.setTempMin(dayWeatherDataOWM.getTemp().getMin());
			dayWeather.setTempMax(dayWeatherDataOWM.getTemp().getMax());
			dayWeather.setWindDeg(dayWeatherDataOWM.getDeg());
			dayWeather.setWindSpeed(dayWeatherDataOWM.getSpeed());
			dayWeather.setClouds(dayWeatherDataOWM.getClouds());

			dayWeathers.add(dayWeather);
		}

		generalWeather.getDayWeathers().addAll(dayWeathers);

		for (HoursWeatherDataOWM hoursWeatherDataOWM : hourWeatherOWM.getList()) {

			HourWeather hourWeather = new HourWeather();

			hourWeather.setClouds(hoursWeatherDataOWM.getClouds().getAll());
			hourWeather.setDateText(hoursWeatherDataOWM.getDt_txt());
			hourWeather.setGeneralTemp(hoursWeatherDataOWM.getMain().getTemp());
			hourWeather.setTempMin(hoursWeatherDataOWM.getMain().getTemp_min());
			hourWeather.setTempMax(hoursWeatherDataOWM.getMain().getTemp_max());
			hourWeather.setPressure(hoursWeatherDataOWM.getMain().getPressure());
			hourWeather.setHumadity(hoursWeatherDataOWM.getMain().getPressure());
			hourWeather.setRainVolume(hoursWeatherDataOWM.getRain().getVolume());
			hourWeather.setSeaLevel(hoursWeatherDataOWM.getMain().getSea_level());
			hourWeather.setWindDeg(hoursWeatherDataOWM.getWind().getDeg());
			hourWeather.setWindSpeed(hoursWeatherDataOWM.getWind().getSpeed());

			hourWeathers.add(hourWeather);

		}
		
		generalWeather.getHourWeathers().addAll(hourWeathers);

		return generalWeather;

	}
}
