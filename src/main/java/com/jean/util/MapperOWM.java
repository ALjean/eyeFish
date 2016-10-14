package com.jean.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jean.entity.CurrentWeather;
import com.jean.entity.DayWeather;
import com.jean.entity.GeneralDayWeather;
import com.jean.entity.GeneralHourWeather;
import com.jean.entity.HourWeather;
import com.jean.servlet.model.owm.GeneralWeatherStateOWM;
import com.jean.servlet.model.owm.WindOWM;
import com.jean.servlet.model.owm.current.CurrentWeatherOWM;
import com.jean.servlet.model.owm.detail.DayWeatherDataOWM;
import com.jean.servlet.model.owm.hours.HoursWeatherDataOWM;

public class MapperOWM {

	public static GeneralDayWeather buildModelDayWeather(GeneralWeatherStateOWM<DayWeatherDataOWM> dayWeatherOWM) {

		GeneralDayWeather generalDayWeather = new GeneralDayWeather();
		List<DayWeather> dayWeathers = new ArrayList<>();

		generalDayWeather.setCityId((dayWeatherOWM.getCity().getId()));
		generalDayWeather.setCityName(dayWeatherOWM.getCity().getName());
		generalDayWeather.setCountry(dayWeatherOWM.getCity().getCountry());
		generalDayWeather.setCoordLat(dayWeatherOWM.getCity().getCoord().getLat());
		generalDayWeather.setCoordLon(dayWeatherOWM.getCity().getCoord().getLon());

		for (DayWeatherDataOWM dayWeatherDataOWM : dayWeatherOWM.getList()) {

			DayWeather dayWeather = new DayWeather();

			dayWeather.setCurrentDate(new Date(dayWeatherDataOWM.getDt()));
			dayWeather.setClouds(dayWeatherDataOWM.getClouds());
			dayWeather.setHumidity(dayWeatherDataOWM.getHumidity());
			dayWeather.setPressure(Utils.millibarToMmHg(dayWeatherDataOWM.getPressure()));
			dayWeather.setRainVolume(dayWeatherDataOWM.getRain());
			dayWeather.setTempDay(Utils.kelvinToCelsius(dayWeatherDataOWM.getTemp().getDay()));
			dayWeather.setTempEvening(Utils.kelvinToCelsius(dayWeatherDataOWM.getTemp().getEve()));
			dayWeather.setTempMorning(Utils.kelvinToCelsius(dayWeatherDataOWM.getTemp().getMorn()));
			dayWeather.setTempNight(Utils.kelvinToCelsius(dayWeatherDataOWM.getTemp().getNight()));
			dayWeather.setTempMin(Utils.kelvinToCelsius(dayWeatherDataOWM.getTemp().getMin()));
			dayWeather.setTempMax(Utils.kelvinToCelsius(dayWeatherDataOWM.getTemp().getMax()));
			dayWeather.setWindDeg(dayWeatherDataOWM.getDeg());
			dayWeather.setWindSpeed(dayWeatherDataOWM.getSpeed());
			dayWeather.setClouds(dayWeatherDataOWM.getClouds());
			dayWeather.setCloudDescription(dayWeatherDataOWM.getWeather().get(0).getDescription());
			dayWeather.setCloudMain(dayWeatherDataOWM.getWeather().get(0).getMain());
			dayWeather.setWindDirection(Utils.getDirection(dayWeatherDataOWM.getDeg()));

			dayWeathers.add(dayWeather);
		}

		generalDayWeather.getDayWeathers().addAll(dayWeathers);

		return generalDayWeather;

	}

	public static GeneralHourWeather buildModelHourWeather(GeneralWeatherStateOWM<HoursWeatherDataOWM> hourWeatherOWM) {

		GeneralHourWeather generalHourWeather = new GeneralHourWeather();
		List<HourWeather> hourWeathers = new ArrayList<>();

		generalHourWeather.setCityId((hourWeatherOWM.getCity().getId()));
		generalHourWeather.setCityName(hourWeatherOWM.getCity().getName());
		generalHourWeather.setCountry(hourWeatherOWM.getCity().getCountry());
		generalHourWeather.setCoordLat(hourWeatherOWM.getCity().getCoord().getLat());
		generalHourWeather.setCoordLon(hourWeatherOWM.getCity().getCoord().getLon());

		Map<java.util.Date, List<HourWeather>> dayHourWeather = new HashMap<>();

		for (HoursWeatherDataOWM hoursWeatherDataOWM : hourWeatherOWM.getList()) {
			if(hoursWeatherDataOWM.getWind() == null){
				hoursWeatherDataOWM.setWind(new WindOWM());
			}
			HourWeather hourWeather = new HourWeather();

			hourWeather.setDate(new Date(hoursWeatherDataOWM.getDt()));
			hourWeather.setClouds(hoursWeatherDataOWM.getClouds().getAll());
			hourWeather.setDateText(hoursWeatherDataOWM.getDt_txt());
			hourWeather.setGeneralTemp(Utils.kelvinToCelsius(hoursWeatherDataOWM.getMain().getTemp()));
			hourWeather.setTempMin(Utils.kelvinToCelsius(hoursWeatherDataOWM.getMain().getTemp_min()));
			hourWeather.setTempMax(Utils.kelvinToCelsius(hoursWeatherDataOWM.getMain().getTemp_max()));
			hourWeather.setPressure(Utils.millibarToMmHg(hoursWeatherDataOWM.getMain().getPressure()));
			hourWeather.setHumadity(hoursWeatherDataOWM.getMain().getPressure());
			hourWeather.setRainVolume(hoursWeatherDataOWM.getRain().getVolume());
			hourWeather.setSeaLevel(hoursWeatherDataOWM.getMain().getSea_level());
			hourWeather.setWindDeg(hoursWeatherDataOWM.getWind().getDeg());
			hourWeather.setWindSpeed(hoursWeatherDataOWM.getWind().getSpeed());
			
			hourWeather.setWindDirection(Utils.getDirection(hoursWeatherDataOWM.getWind().getDeg()));
			hourWeather.setCloudMain(hoursWeatherDataOWM.getWeather().get(0).getMain());
			hourWeather.setCloudDescription(hoursWeatherDataOWM.getWeather().get(0).getDescription());

			hourWeathers.add(hourWeather);

		}

		hourWeathers.forEach(weather -> {
			List<HourWeather> list = dayHourWeather.containsKey(weather.getDate()) ? dayHourWeather.get(weather.getDate()) : new ArrayList<>();
			list.add(weather);
			dayHourWeather.put(weather.getDate(), list);
		});

		generalHourWeather.setDayHourWeathers(dayHourWeather);
		generalHourWeather.getHourWeathers().addAll(hourWeathers);

		return generalHourWeather;

	}

	public static CurrentWeather buildModelCurrentWeather(CurrentWeatherOWM currentWeatherOWM) {

		CurrentWeather currentWeather = new CurrentWeather();

		currentWeather.setCityId(currentWeatherOWM.getId());
		currentWeather.setCityName(currentWeatherOWM.getName());
		currentWeather.setCloudDescription(currentWeatherOWM.getWeather().get(0).getDescription());
		currentWeather.setCloudMain(currentWeatherOWM.getWeather().get(0).getMain());
		currentWeather.setClouds(currentWeatherOWM.getClouds().getAll());
		currentWeather.setCoordLat(currentWeatherOWM.getCoord().getLat());
		currentWeather.setCoordLon(currentWeatherOWM.getCoord().getLon());
		currentWeather.setCountry(currentWeatherOWM.getSys().getCountry());
		currentWeather.setDate(new Date(currentWeatherOWM.getDt()));
		currentWeather.setHumidity(currentWeatherOWM.getMain().getHumidity());
		currentWeather.setPressure(Utils.millibarToMmHg(currentWeatherOWM.getMain().getPressure()));
		currentWeather.setRainVolume(currentWeatherOWM.getRain().getVolume());
		currentWeather.setSeaLevel(currentWeatherOWM.getMain().getSea_level());
		currentWeather.setSunRise(new Timestamp(currentWeatherOWM.getSys().getSunrise()));
		currentWeather.setSunDown(new Timestamp(currentWeatherOWM.getSys().getSunset()));
		currentWeather.setTemp(Utils.kelvinToCelsius(currentWeatherOWM.getMain().getTemp()));
		currentWeather.setTempMin(Utils.kelvinToCelsius(currentWeatherOWM.getMain().getTemp_min()));
		currentWeather.setTempMax(Utils.kelvinToCelsius(currentWeatherOWM.getMain().getTemp_max()));
		currentWeather.setTempKf(currentWeatherOWM.getMain().getTemp_kf());
		currentWeather.setWindDeg(currentWeatherOWM.getWind().getDeg());
		currentWeather.setWindSpeed(currentWeatherOWM.getWind().getSpeed());
		currentWeather.setWindDirection(Utils.getDirection(currentWeatherOWM.getWind().getDeg()));

		return currentWeather;

	}
}
