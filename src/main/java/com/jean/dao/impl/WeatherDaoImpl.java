package com.jean.dao.impl;

import com.jean.CustomDfmException;
import com.jean.dao.WeatherDao;
import com.jean.entity.Weather;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by stas on 18.07.15.
 */
@Repository
public class WeatherDaoImpl extends BaseDaoImpl implements WeatherDao {

    @Override
    public void create(Weather weather) throws CustomDfmException {
        String sql = "INSERT INTO weather (city, date, temp, temp_min, temp_max, pressure, wind_speed, wind_deg, clouds) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";


        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, weather.getCity());
            preparedStatement.setDate(2, new Date(weather.getDate().getTime()));
            preparedStatement.setFloat(3, weather.getTemperature());
            preparedStatement.setFloat(4, weather.getMinTemperature());
            preparedStatement.setFloat(5, weather.getMaxTemperature());
            preparedStatement.setInt(6, weather.getPressure());
            preparedStatement.setFloat(7, weather.getWindSpeed());
            preparedStatement.setFloat(8, weather.getWindDeg());
            preparedStatement.setInt(9, weather.getClouds());
            int result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new CustomDfmException(e, "some problem with save weather");
        }

    }
}
