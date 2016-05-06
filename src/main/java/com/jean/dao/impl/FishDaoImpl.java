package com.jean.dao.impl;

import com.jean.DaoDfmException;
import com.jean.dao.FishDao;
import com.jean.entity.*;
import com.jean.util.Log;


import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

/**
 * Created by stas on 30.05.15.
 */

@Repository
public class FishDaoImpl extends BaseDaoImpl implements FishDao {

	@Override
	public Integer saveFish(Fish fish) throws DaoDfmException {

		String insertIntoFishes = "INSERT INTO fishes (fish_name, description, fish_type, area, activity) VALUES (?, ?, ?, ?, ?)";
		String insertIntoFishSettings = "INSERT INTO fish_settings (fish_id, param_name, min_range, max_range, nibble_level) VALUES (?, ?, ?, ?, ?)";
		String insertIntoNibblePeriods = "INSERT INTO nibble_periods (fish_id, start_period, end_period, nibble_level) VALUES (?, ?, ?, ?)";

		Connection connection = null;
		PreparedStatement statement = null;

		int fishId = 0;

		try {
			connection = getConnection();
			statement = connection.prepareStatement(insertIntoFishes, Statement.RETURN_GENERATED_KEYS);
			
			Log.startDaoLog("saveFish", fish.toString());

			statement.setString(1, fish.getName());
			statement.setString(2, fish.getDescription());
			statement.setString(3, fish.getFishType().name());
			statement.setString(4, fish.getLivingArea().name());
			statement.setString(5, fish.getDaysActivity().name());
			statement.executeUpdate();

			fishId = getGeneratedKey(statement);

			statement = connection.prepareStatement(insertIntoFishSettings);
			for (FishSetting fishSetting : fish.getFishSetting()) {
				statement.setInt(1, fishId);
				statement.setString(2, fishSetting.getParamName());
				statement.setDouble(3, fishSetting.getMinValue());
				statement.setDouble(4, fishSetting.getMaxValue());
				statement.setDouble(5, fishSetting.getNibbleLevel());
				statement.executeUpdate();
			}
			
			statement = connection.prepareStatement(insertIntoNibblePeriods);
			for (NibblePeriod nibblePeriod : fish.getNibbles()){
				statement.setInt(1, fishId);
				statement.setDate(2, nibblePeriod.getStartPeriod());
				statement.setDate(3, nibblePeriod.getEndPeriod());
				statement.setDouble(4, nibblePeriod.getNibbleLevel());
				statement.executeUpdate();
			}
			connection.commit();
			
			Log.startDaoLog("saveFish", "fishId is " + fishId);
			
		} catch (SQLException e) {
			rollback(connection);
			Log.daoException("saveFish", e.getMessage());
		}finally{
			closePreparedStatement(statement);
			closeConnection(connection);
		}

		return fishId;
	}

	@Override
	public List<Fish> getFishes(int id) throws DaoDfmException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Fish fish) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) throws DaoDfmException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Fish> getAllWeather() throws DaoDfmException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fish getFishByTempForNibble(int temp, int fishId) throws DaoDfmException {
		// TODO Auto-generated method stub
		return null;
	}
}
