package com.jean.dao.impl;

import com.jean.CustomDfmException;
import com.jean.dao.FishDao;
import com.jean.entity.Fish;
import com.jean.entity.Fish;
import com.jean.entity.Spawning;
import com.jean.entity.RangeWeatherParameters;
import com.jean.util.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stas on 30.05.15.
 */

@Component
public class FishDaoImpl extends BaseDaoImpl implements FishDao {

    private static final Logger log = LoggerFactory.getLogger(FishDaoImpl.class);

    private enum Location {
	UP, MIDDLE, DIP
    }

    private enum Hungry {
	NOTEAT, WEAKLY, MODESTLY, ACTIVE
    }

    // private enum Wind {}

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

	String sql = "SELECT f.name, f.description, ws.id type_data_id, ws.type_data_weather, ws.state_mark, ws.min, ws.max, ws.fish_id, s.id spawn_id, s.spawning, s.gluttony, s.sick FROM fish f INNER JOIN  weather_state ws ON f.id = ws.fish_id INNER JOIN spawning s ON f.id = s.fish_id WHERE f.id = ?";
	
	Fish fish = new Fish();

	try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
	    
	    preparedStatement.setLong(1, id);
	    
	    ResultSet rs = preparedStatement.executeQuery();

	    Map<String, List<RangeWeatherParameters>> hungry = new HashMap<String, List<RangeWeatherParameters>>();
	    Map<String, List<RangeWeatherParameters>> location = new HashMap<String, List<RangeWeatherParameters>>();

	    List<RangeWeatherParameters> params = new ArrayList<RangeWeatherParameters>();

	    Spawning spawning = new Spawning();

	    while (rs.next()) {
		
		RangeWeatherParameters weatherState = new RangeWeatherParameters();
		String stateMark = rs.getString("state_mark");
		
		fish.setId(rs.getInt("fish_id"));
		fish.setDescription(rs.getString("description"));
		fish.setName(rs.getString("name"));

		weatherState.setId(rs.getInt("type_data_id"));
		weatherState.setTypeDataWeather(rs.getString("type_data_weather"));
		weatherState.setMin(rs.getLong("min"));
		weatherState.setMax(rs.getLong("max"));
		
		if(stateMark.equalsIgnoreCase(Constants.StateMarkHungry.NOTEAT.toString())){
		    fish.getHungry().get(stateMark.toUpperCase()).add(weatherState);
		}
		
		if(stateMark.equalsIgnoreCase(Constants.StateMarkHungry.WEAKLY.toString())){
		    fish.getHungry().get(stateMark.toUpperCase()).add(weatherState);
		}
		
		if(stateMark.equalsIgnoreCase(Constants.StateMarkHungry.MODESTLY.toString())){
		    fish.getHungry().get(stateMark.toUpperCase()).add(weatherState);
		}
		
		if(stateMark.equalsIgnoreCase(Constants.StateMarkHungry.ACTIVE.toString())){
		    fish.getHungry().get(stateMark.toUpperCase()).add(weatherState);
		}

		spawning.setId(rs.getInt("spawn_id"));
		// spawning.setSpawning(rs.getDate("spawning"));
		// spawning.setGluttony(rs.getDate("gluttony"));
		// spawning.setSick(rs.getDate("sick"));

		/*
		 * if (key.equalsIgnoreCase(Hungry.ACTIVE.toString()) ||
		 * key.equalsIgnoreCase(Hungry.MODESTLY.toString()) ||
		 * key.equalsIgnoreCase(Hungry.WEAKLY.toString())) {
		 * hungry.put(key, weatherState); }
		 * 
		 * if (key.equalsIgnoreCase(Location.DIP.toString()) ||
		 * key.equalsIgnoreCase(Location.MIDDLE.toString()) ||
		 * key.equalsIgnoreCase(Location.UP.toString())) {
		 * location.put(key, weatherState); }
		 */

	    }

	    fish.setSpawning(spawning);
	    //fish.setHungry(hungry);
	    //fish.setLocation(location);

	} catch (SQLException e) {
	    throw new CustomDfmException(e, "some problem when you try read fish");
	}

	return fish;
    }

    @Override
    public Fish update(Fish fish) {
	return null;
    }

    @Override
    public boolean delete(int id) {
	return false;
    }
}
