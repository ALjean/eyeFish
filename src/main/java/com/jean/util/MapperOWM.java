package com.jean.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.jean.entity.owm.GeneralWeatherStateOWM;
import com.jean.entity.owm.WindOWM;
import com.jean.entity.owm.current.CurrentWeatherOWM;
import com.jean.entity.owm.detail.DayWeatherDataOWM;
import com.jean.entity.owm.hour.HoursWeatherDataOWM;
import com.jean.entity.weather.CurrentWeather;
import com.jean.entity.weather.DayWeather;
import com.jean.entity.weather.GeneralDayWeather;
import com.jean.entity.weather.GeneralHourWeather;
import com.jean.entity.weather.HourWeather;

public class MapperOWM {

	public static GeneralDayWeather buildModelDayWeather(GeneralWeatherStateOWM<DayWeatherDataOWM> dayWeatherOWM) {

		GeneralDayWeather generalDayWeather = new GeneralDayWeather();
		List<DayWeather> dayWeathers = new ArrayList<>();

		generalDayWeather.setCityId((dayWeatherOWM.getCity().getId()));
		generalDayWeather.setCityName(dayWeatherOWM.getCity().getName());
		generalDayWeather.setCountry(dayWeatherOWM.getCity().getCountry());
		generalDayWeather.setCoordLat(dayWeatherOWM.getCity().getCoord().getLat());
		generalDayWeather.setCoordLon(dayWeatherOWM.getCity().getCoord().getLon());

		dayWeatherOWM.getList().forEach(item -> {
			DayWeather dayWeather = new DayWeather();


			dayWeather.setCurrentDate(Utils.parseTextDate(item.getDt()));
			dayWeather.setClouds(item.getClouds());
			dayWeather.setHumidity(item.getHumidity());
			dayWeather.setPressure(Utils.millibarToMmHg(item.getPressure()));
			dayWeather.setRainVolume(item.getRain());
			dayWeather.setTempDay(Utils.kelvinToCelsius(item.getTemp().getDay()));
			dayWeather.setTempEvening(Utils.kelvinToCelsius(item.getTemp().getEve()));
			dayWeather.setTempMorning(Utils.kelvinToCelsius(item.getTemp().getMorn()));
			dayWeather.setTempNight(Utils.kelvinToCelsius(item.getTemp().getNight()));
			dayWeather.setTempMin(Utils.kelvinToCelsius(item.getTemp().getMin()));
			dayWeather.setTempMax(Utils.kelvinToCelsius(item.getTemp().getMax()));
			dayWeather.setWindDeg(item.getDeg());
			dayWeather.setWindSpeed(item.getSpeed());
			dayWeather.setClouds(item.getClouds());
			dayWeather.setCloudDescription(item.getWeather().get(0).getDescription());
			dayWeather.setCloudMain(item.getWeather().get(0).getMain());
			dayWeather.setWindDirection(Utils.getDirection(item.getDeg()));

			dayWeathers.add(dayWeather);
		});

		generalDayWeather.getDayWeathers().addAll(dayWeathers);

		return generalDayWeather;

	}

	public static GeneralHourWeather buildModelHourWeather(GeneralWeatherStateOWM<HoursWeatherDataOWM> hourWeatherOWM) {

		GeneralHourWeather generalHourWeather = new GeneralHourWeather();

		generalHourWeather.setCityId((hourWeatherOWM.getCity().getId()));
		generalHourWeather.setCityName(hourWeatherOWM.getCity().getName());
		generalHourWeather.setCountry(hourWeatherOWM.getCity().getCountry());
		generalHourWeather.setCoordLat(hourWeatherOWM.getCity().getCoord().getLat());
		generalHourWeather.setCoordLon(hourWeatherOWM.getCity().getCoord().getLon());


		WeatherMap map = new WeatherMap();

		hourWeatherOWM.getList().forEach(item ->{
			if(item.getWind() == null){
				item.setWind(new WindOWM());
			}
			HourWeather hourWeather = new HourWeather();
			hourWeather.setDate(Utils.parseTextDate(item.getDt_txt()));
			hourWeather.setClouds(item.getClouds().getAll());
			hourWeather.setDateText(item.getDt_txt());
			hourWeather.setGeneralTemp(Utils.kelvinToCelsius(item.getMain().getTemp()));
			hourWeather.setTempMin(Utils.kelvinToCelsius(item.getMain().getTemp_min()));
			hourWeather.setTempMax(Utils.kelvinToCelsius(item.getMain().getTemp_max()));
			hourWeather.setPressure(Utils.millibarToMmHg(item.getMain().getPressure()));
			hourWeather.setHumadity(item.getMain().getPressure());
			hourWeather.setRainVolume(item.getRain().getVolume());
			hourWeather.setSeaLevel(item.getMain().getSea_level());
			hourWeather.setWindDeg(item.getWind().getDeg());
			hourWeather.setWindSpeed(item.getWind().getSpeed());
			hourWeather.setWindDirection(Utils.getDirection(item.getWind().getDeg()));
			hourWeather.setCloudMain(item.getWeather().get(0).getMain());
			hourWeather.setCloudDescription(item.getWeather().get(0).getDescription());

			map.put(item.getDt_txt(), hourWeather);
		});

		
		generalHourWeather.setDayHourWeathers(map.getMap());

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

		currentWeather.setDate(Utils.parseTextDate(currentWeatherOWM.getDt()));
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
