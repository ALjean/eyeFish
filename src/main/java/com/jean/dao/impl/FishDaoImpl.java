package com.jean.dao.impl;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.dao.FishDao;
import com.jean.entity.*;
import com.jean.Constants;
import com.jean.enums.FishTypes;
import com.jean.enums.ParamNames;
import com.jean.util.Log;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 30.05.15.
 */

@Repository
public class FishDaoImpl extends BaseDaoImpl implements FishDao {

	private static final Logger log = Logger.getLogger(Log.class);

	@Override
	public Integer saveFish(Fish fish) throws DaoDfmException {

		String insertIntoFishes = "INSERT INTO fishes (fish_name, description, fish_type, area, activity) VALUES (?, ?, ?, ?, ?)";
		String insertIntoFishSettings = "INSERT INTO fish_settings (fish_id, param_name, min_range, max_range, nibble_level) VALUES (?, ?, ?, ?, ?)";
		String insertIntoNibblePeriods = "INSERT INTO nibble_periods (fish_id, start_period, end_period, nibble_level) VALUES (?, ?, ?, ?)";

		Connection connection = null;
		PreparedStatement statement = null;

		int fishId;

		try {
			connection = getConnection();
			statement = connection.prepareStatement(insertIntoFishes, Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, fish.getName());
			statement.setString(2, fish.getDescription());
			statement.setString(3, fish.getFishType().name());
			statement.setString(4, fish.getLivingArea().name());
			statement.setString(5, fish.getDaysActivity().name());
			statement.executeUpdate();

			fishId = getGeneratedKey(statement);

			for (FishSetting fishSetting : fish.getFishSetting()) {
				statement.setInt(1, fishId);
				statement.setString(2, fishSetting.getParamName());
				statement.setDouble(3, fishSetting.getMinValue());
				statement.setDouble(4, fishSetting.getMaxValue());
				statement.setDouble(5, fishSetting.getNibbleLevel());
				statement.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
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
