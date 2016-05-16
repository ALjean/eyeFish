//package com.jean.dao.impl;
//
//import com.jean.DaoDfmException;
//import com.jean.dao.WeatherDao;
//import com.jean.entity.GeneralWeather;
//import com.jean.entity.Weather;
//
//import org.apache.log4j.Logger;
//import org.springframework.stereotype.Repository;
//
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by stas on 18.07.15.
// */
//@Repository
//public class WeatherDaoImpl extends BaseDaoImpl implements WeatherDao {
//
//	private static final Logger log = Logger.getLogger(FishDaoImpl.class);
//
//
//	public void save(List<GeneralWeather> generalWeathers) throws DaoDfmException {
//
//		Connection connection = null;
//
//		try {
//
//			connection = getConnection();
//			PreparedStatement statement = connection.prepareStatement(" ");
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//	public List<Weather> getAllWeather() throws DaoDfmException {
//		String sql = "SELECT id, city, date, temp_day, temp_night, temp_even, temp_morn, pressure, wind_speed, wind_deg, humidity, clouds FROM daily_forecast_weathers";
//		List<Weather> weathers = new ArrayList<>();
//
//		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
//
//			ResultSet rs = preparedStatement.executeQuery();
//
//			while (rs.next()) {
//				weathers.add(getWeatherFromRs(rs));
//			}
//
//			log.info(weathers.size() > 0 ? "Weather list: " + weathers.size() : "Weather result is zero");
//
//		} catch (SQLException e) {
//			log.error("some problem when get List Weather");
//			throw new DaoDfmException("some problem when get List Weather", e);
//		}
//
//		return weathers;
//	}
//
//	@Override
//	public List<Weather> getLimitWeatherByDate(java.util.Date date) throws DaoDfmException {
//		String sql = "SELECT id, city, date, temp_day, temp_night, temp_even, temp_morn, pressure, wind_speed, wind_deg, humidity, "
//				+ "clouds FROM daily_forecast_weathers WHERE date <= ? ORDER BY id DESC LIMIT 5";
//
//		List<Weather> weathers = new ArrayList<>();
//
//		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
//			preparedStatement.setDate(1, new Date(date.getTime()));
//			ResultSet rs = preparedStatement.executeQuery();
//
//			while (rs.next()) {
//				weathers.add(getWeatherFromRs(rs));
//			}
//
//		} catch (SQLException e) {
//			log.error("some problem when get List Weather");
//			throw new DaoDfmException("some problem when get List Weather", e);
//		}
//
//		return weathers;
//	}
//
//	private Weather getWeatherFromRs(ResultSet rs) throws SQLException {
//		Weather weather = new Weather();
//		weather.setId(rs.getInt("id"));
//		weather.setCity(rs.getString("city"));
//		weather.setDate(rs.getDate("date"));
//		weather.setTempDay(rs.getFloat("temp_day"));
//		weather.setTempEven(rs.getFloat("temp_even"));
//		weather.setTempMorn(rs.getFloat("temp_morn"));
//		weather.setTempNight(rs.getFloat("temp_night"));
//		weather.setPressure(rs.getFloat("pressure"));
//		weather.setWindSpeed(rs.getFloat("wind_speed"));
//		weather.setWindDeg(rs.getFloat("wind_deg"));
//		weather.setHumidity(rs.getInt("humidity"));
//		weather.setClouds(rs.getInt("clouds"));
//
//		return weather;
//	}
//
//	private Integer isExsistCityId(int cityId) throws DaoDfmException {
//
//		String sql = "SELECT gen_weather_id FROM general_weather WHERE city_id = ?";
//		int result = 0;
//
//		try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
//
//			statement.setInt(1, cityId);
//			ResultSet rs = statement.executeQuery();
//
//			if (rs.next()) {
//				result = rs.getInt("gen_weather_id");
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return result;
//	}
//
//	@Override
//	public void save(Weather weathers) throws DaoDfmException {
//		// TODO Auto-generated method stub
//
//	}
//
//}
