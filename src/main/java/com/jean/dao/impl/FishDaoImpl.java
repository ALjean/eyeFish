package com.jean.dao.impl;

import com.jean.CustomDfmException;
import com.jean.dao.FishDao;
import com.jean.entity.Fish;
import com.jean.entity.Spawning;
import com.jean.entity.WeatherState;
import com.jean.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by stas on 30.05.15.
 */

@Component
public class FishDaoImpl extends BaseDaoImpl implements FishDao {

    private static final Logger log = LoggerFactory.getLogger(FishDaoImpl.class);


    @Override
    public void save(Fish fish) throws CustomDfmException {

        String sql = "INSERT INTO fish (name, description) VALUES (?, ?)";
        int result;

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, fish.getName());
            preparedStatement.setString(2, fish.getDescription());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new CustomDfmException(e, "some problem with save fish");
        }


        if (result != 0) {
            log.info("Fish model save with name: " + fish.getName());
        }

    }

    @Override
    public Fish read(int id) throws CustomDfmException {
        String sql = "SELECT f.name, f.description, ws.id type_data_id, ws.type_data_weather, ws.mark, ws.min, ws.max, ws.fish_id, s.id spawn_id, s.spawning, s.gluttony, s.sick FROM fish f INNER JOIN  weather_state ws ON f.id = ws.fish_id INNER JOIN spawning s ON f.id = s.fish_id WHERE f.id = ?";
        Fish fish = new Fish();


        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            Map<String, WeatherState> hungry = new HashMap<>();
            Map<String, WeatherState> location = new HashMap<>();

            Spawning spawning = new Spawning();


            while (rs.next()) {
                fish.setId(rs.getInt("fish_id"));
                fish.setDescription(rs.getString("description"));
                fish.setName(rs.getString("name"));

                WeatherState weatherState = new WeatherState();
                weatherState.setId(rs.getInt("type_data_id"));
                weatherState.setTypeDataWeather(rs.getString("type_data_weather"));
                weatherState.setMin(rs.getLong("min"));
                weatherState.setMax(rs.getLong("max"));
                String key = rs.getString("mark");

                spawning.setId(rs.getInt("spawn_id"));
                spawning.setSpawning(rs.getDate("spawning"));
                spawning.setGluttony(rs.getDate("gluttony"));
                spawning.setSick(rs.getDate("sick"));

                if (key.equals(Constants.Hungry.NOTEAT.toString()) || key.equals(Constants.Hungry.WEAKLY.toString()) ||
                        key.equals(Constants.Hungry.MODESTLY.toString()) || key.equals(Constants.Hungry.ACTIVE.toString())) {
                    hungry.put(key, weatherState);
                }

                if (key.equals(Constants.Location.DIP.toString()) || key.equals(Constants.Location.MIDDLE.toString()) ||
                        key.equals(Constants.Location.UP.toString())) {
                    location.put(key, weatherState);
                }

            }

            fish.setSpawning(spawning);
            fish.setHungry(hungry);
            fish.setLocation(location);


        } catch (SQLException e) {
            throw new CustomDfmException(e, "some problem when you try read fish");
        }

        return fish;
    }

    @Override
    public Fish update(Fish fish) {
        String sql = "";

        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
