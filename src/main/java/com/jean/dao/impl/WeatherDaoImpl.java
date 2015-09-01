package com.jean.dao.impl;

import com.jean.CustomDfmException;
import com.jean.dao.WeatherDao;
import com.jean.entity.Weather;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 18.07.15.
 */
@Repository
public class WeatherDaoImpl extends BaseDaoImpl implements WeatherDao {

    @Override
    public void save(Weather weather) throws CustomDfmException {
	String sql = "INSERT INTO weather (city, date, temp_day, temp_night, temp_even, temp_morn, pressure, wind_speed, wind_deg, humidity, clouds) "
		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
	    preparedStatement.setString(1, weather.getCity());
	    preparedStatement.setDate(2, new Date(weather.getDate().getTime()));
	    preparedStatement.setFloat(3, weather.getTempDay());
	    preparedStatement.setFloat(4, weather.getTempNight());
	    preparedStatement.setFloat(5, weather.getTempEven());
	    preparedStatement.setFloat(6, weather.getTempMorn());
	    preparedStatement.setFloat(7, weather.getPressure());
	    preparedStatement.setFloat(8, weather.getWindSpeed());
	    preparedStatement.setFloat(9, weather.getWindDeg());
	    preparedStatement.setInt(10, weather.getHumidity());
	    preparedStatement.setInt(11, weather.getClouds());
	    int result = preparedStatement.executeUpdate(); // todo
	} catch (SQLException e) {
	    throw new CustomDfmException(e, "some problem with save weather");
	}

    }

    public List<Weather> getAllWeather() throws CustomDfmException {
	String sql = "SELECT id, city, date, temp_day, temp_night, temp_even, temp_morn, pressure, wind_speed, wind_deg, humidity, clouds FROM weather";
	List<Weather> weathers = new ArrayList<>();

	try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
	    ResultSet rs = preparedStatement.executeQuery();

	    while (rs.next()) {
		Weather weather = new Weather();
		weather.setId(rs.getInt("id"));
		weather.setCity(rs.getString("city"));
		weather.setDate(rs.getDate("date"));
		weather.setTempDay(rs.getFloat("temp_day"));
		weather.setTempEven(rs.getFloat("temp_even"));
		weather.setTempMorn(rs.getFloat("temp_morn"));
		weather.setTempNight(rs.getFloat("temp_night"));
		weather.setPressure(rs.getFloat("pressure"));
		weather.setWindSpeed(rs.getFloat("wind_speed"));
		weather.setWindDeg(rs.getFloat("wind_deg"));
		weather.setHumidity(rs.getInt("humidity"));
		weather.setClouds(rs.getInt("clouds"));

		weathers.add(weather);
	    }

	} catch (SQLException e) {
	    throw new CustomDfmException(e, "some problem when get List Weather");
	}

	return weathers;
    }

    @Override
    public List<Weather> getLimitWeatherByDate() throws CustomDfmException {
	String sql = "SELECT id, city, date, temp_day, temp_night, temp_even, temp_morn, pressure, wind_speed, wind_deg, humidity, clouds FROM weather where date <= '2015-09-04 00:00:00' limit 4";

	List<Weather> weathers = new ArrayList<>();

	try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
	    ResultSet rs = preparedStatement.executeQuery();

	    while (rs.next()) {
		Weather weather = new Weather();
		weather.setId(rs.getInt("id"));
		weather.setCity(rs.getString("city"));
		weather.setDate(rs.getDate("date"));
		weather.setTempDay(rs.getFloat("temp_day"));
		weather.setTempEven(rs.getFloat("temp_even"));
		weather.setTempMorn(rs.getFloat("temp_morn"));
		weather.setTempNight(rs.getFloat("temp_night"));
		weather.setPressure(rs.getFloat("pressure"));
		weather.setWindSpeed(rs.getFloat("wind_speed"));
		weather.setWindDeg(rs.getFloat("wind_deg"));
		weather.setHumidity(rs.getInt("humidity"));
		weather.setClouds(rs.getInt("clouds"));

		weathers.add(weather);
	    }

	} catch (SQLException e) {
	    throw new CustomDfmException(e, "some problem when get List Weather");
	}

	return weathers;
    }
}
