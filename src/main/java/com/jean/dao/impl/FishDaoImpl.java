package com.jean.dao.impl;

import com.jean.DaoDfmException;
import com.jean.dao.FishDao;
import com.jean.entity.*;
import com.jean.enums.PressureStates;
import com.jean.util.Log;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by stas on 30.05.15.
 */

@Repository
public class FishDaoImpl extends BaseDaoImpl implements FishDao {

	@Override
	public Integer saveFish(Fish fish) throws DaoDfmException {

		String insertIntoFishes = "INSERT INTO fishes (fish_name, description, fish_type, is_stability, is_high, is_low, is_rise, is_down) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		String insertIntoFishSettings = "INSERT INTO fish_settings (fish_id, param_name, min_range, max_range, nibble_level) VALUES (?, ?, ?, ?, ?)";
		String insertIntoNibblePeriods = "INSERT INTO nibble_periods (fish_id, start_period, end_period, nibble_level) VALUES (?, ?, ?, ?)";
		String insertIntoDaysActivity = "INSERT INTO days_activity (fish_id, activity_name) VALUES (?, ?)";
		String insertIntoLivingAreas = "INSERT INTO living_areas (fish_id, area_name) VALUES (?, ?)";

		Connection connection = null;
		PreparedStatement statement = null;

		int fishId = 0;

		try {
			connection = getConnection();
			statement = connection.prepareStatement(insertIntoFishes, Statement.RETURN_GENERATED_KEYS);

			Log.startDaoLog("saveFish", fish.toString());

			statement.setString(1, fish.getName());
			statement.setString(2, fish.getDescription());
			statement.setString(3, fish.getFishType());
			statement.setDouble(4, fish.getPressureStates().get(PressureStates.IS_STABILITY));
			statement.setDouble(5, fish.getPressureStates().get(PressureStates.IS_STABILITY_HIGH));
			statement.setDouble(6, fish.getPressureStates().get(PressureStates.IS_STABILITY_LOW));
			statement.setDouble(7, fish.getPressureStates().get(PressureStates.IS_RISE));
			statement.setDouble(8, fish.getPressureStates().get(PressureStates.IS_DOWN));
			statement.executeUpdate();

			fishId = getGeneratedKey(statement);

			statement = connection.prepareStatement(insertIntoFishSettings);
			for (FishSetting fishSetting : fish.getFishSetting()) {
				statement.setInt(1, fishId);
				statement.setString(2, fishSetting.getParamName());
				statement.setDouble(3, fishSetting.getMinValue());
				statement.setDouble(4, fishSetting.getMaxValue());
				statement.setDouble(5, fishSetting.getNibbleLevel());
				statement.addBatch();
			}
			statement.executeBatch();
			closePreparedStatement(statement);

			statement = connection.prepareStatement(insertIntoNibblePeriods);
			for (NibblePeriod nibblePeriod : fish.getNibbles()) {
				statement.setInt(1, fishId);
				statement.setDate(2, nibblePeriod.getStartPeriod());
				statement.setDate(3, nibblePeriod.getEndPeriod());
				statement.setDouble(4, nibblePeriod.getNibbleLevel());
				statement.executeBatch();
			}
			statement.executeBatch();
			closePreparedStatement(statement);

			statement = connection.prepareStatement(insertIntoDaysActivity);
			for (DayActivity activityName : fish.getDaysActivity()) {
				statement.setInt(1, fishId);
				statement.setString(2, activityName.getActivityName());
				statement.executeBatch();
			}
			statement.executeBatch();
			closePreparedStatement(statement);

			statement = connection.prepareStatement(insertIntoLivingAreas);
			for (LivingArea areaName : fish.getLivingArea()) {
				statement.setInt(1, fishId);
				statement.setString(2, areaName.getAreaName());
				statement.executeBatch();
			}
			statement.executeBatch();
			closePreparedStatement(statement);

			connection.commit();

			Log.endDaoLog("saveFish", "fishId is " + fishId);

		} catch (SQLException e) {
			rollback(connection);
			Log.daoException("saveFish", e.getMessage());
			throw new DaoDfmException("Some problem with save fish " + "Message: " + e.getMessage(), e);
		} finally {
			close(statement, connection);
		}

		return fishId;
	}

	@Override
	public List<Fish> getFishes(Integer fishId, String fishName, String fishType, String dayActivity, String livingArea)
			throws DaoDfmException {

		String sql =

				"SELECT DISTINCT "
						+ "f.fish_id, f.fish_name, f.description, f.fish_type, f.is_stability, f.is_high, f.is_low, f.is_rise, f.is_down, d.fish_id, d.activity_id, d.activity_name,l.fish_id, l.area_id, l.area_name, fs.fish_id,  fs.setting_id, fs.param_name, fs.min_range, fs.max_range, fs.nibble_level, n.period_id, n.fish_id, n.start_period, n.end_period, n.nibble_level "
						+ "FROM " + "fishes AS f " + "INNER JOIN " + "fish_settings AS fs ON f.fish_id = fs.fish_id "
						+ "INNER JOIN " + "days_activity AS d ON d.fish_id = f.fish_id " + "INNER JOIN "
						+ "living_areas AS l ON l.fish_id = f.fish_id " + "INNER JOIN "
						+ "nibble_periods AS n ON n.fish_id = f.fish_id " + "WHERE 1=1 "
						+ "AND (f.fish_id = ? OR ? IS NULL) " + "AND (f.fish_name LIKE ? OR ? IS NULL) "
						+ "AND (f.fish_type LIKE ? OR ? IS NULL) " + "AND (d.activity_name LIKE ? OR ? IS NULL) "
						+ "AND (l.area_name LIKE ? OR ? IS NULL) ";

		List<Fish> fishes = new ArrayList<>();

		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement statement = null;

		try {
			Log.startDaoLog("getFishes", "fishId: " + fishId + ", fishName: " + fishName + ", fishType: " + fishType
					+ ", dayActivity: " + dayActivity + ", livingArea: " + livingArea);

			connection = getConnection();
			statement = connection.prepareStatement(sql);

			if (fishId != null) {
				statement.setInt(1, fishId);
				statement.setInt(2, fishId);
			} else {
				statement.setNull(1, Types.INTEGER);
				statement.setNull(2, Types.INTEGER);
			}

			if (!StringUtils.isEmpty(fishName)) {
				statement.setString(3, fishName.replace("*", "%"));
				statement.setString(4, fishName.replace("*", "%"));
			} else {
				statement.setNull(3, Types.VARCHAR);
				statement.setNull(4, Types.VARCHAR);
			}

			if (!StringUtils.isEmpty(fishType)) {
				statement.setString(5, fishType.replace("*", "%"));
				statement.setString(6, fishType.replace("*", "%"));
			} else {
				statement.setNull(5, Types.VARCHAR);
				statement.setNull(6, Types.VARCHAR);
			}

			if (!StringUtils.isEmpty(dayActivity)) {
				statement.setString(7, dayActivity.replace("*", "%"));
				statement.setString(8, dayActivity.replace("*", "%"));
			} else {
				statement.setNull(7, Types.VARCHAR);
				statement.setNull(8, Types.VARCHAR);
			}

			if (!StringUtils.isEmpty(livingArea)) {
				statement.setString(9, livingArea.replace("*", "%"));
				statement.setString(10, livingArea.replace("*", "%"));
			} else {
				statement.setNull(9, Types.VARCHAR);
				statement.setNull(10, Types.VARCHAR);
			}

			rs = statement.executeQuery();

			Fish fish = null;
			while (rs.next()) {

				boolean toAdd = false;

				if (fish == null || fish.getId() != rs.getInt("f.fish_id")) {
					fish = new Fish();
					fish.setId(rs.getInt("f.fish_id"));
					fish.setName(rs.getString("f.fish_name"));
					fish.setFishType(rs.getString("f.fish_type"));
					fish.setDescription(rs.getString("f.description"));
					Map<String, Double> maps = fish.getPressureStates();
					maps.put(PressureStates.IS_STABILITY.name(), rs.getDouble("f.is_stability"));
					maps.put(PressureStates.IS_STABILITY_HIGH.name(), rs.getDouble("f.is_high"));
					maps.put(PressureStates.IS_STABILITY_LOW.name(), rs.getDouble("f.is_low"));
					maps.put(PressureStates.IS_RISE.name(), rs.getDouble("f.is_rise"));
					maps.put(PressureStates.IS_DOWN.name(), rs.getDouble("f.is_down"));
					toAdd = true;
				}

				if (fish.getFishSetting().isEmpty()) {
					fish.getFishSetting().add(fetchFishSettinsFromRs(rs));
				} else {
					boolean result = true;
					for (FishSetting setting : fish.getFishSetting()) {
						if (setting.getId() == rs.getInt("fs.setting_id")) {
							result = false;
							break;
						}
					}
					if (result) {
						fish.getFishSetting().add(fetchFishSettinsFromRs(rs));
					}

				}

				if (fish.getNibbles().isEmpty()) {
					fish.getNibbles().add(fetchNibblePeriodFromRs(rs));
				} else {
					boolean result = true;
					for (NibblePeriod period : fish.getNibbles()) {
						if (period.getId() == rs.getInt("n.period_id")) {
							result = false;
							break;
						}
					}
					if (result) {
						fish.getNibbles().add(fetchNibblePeriodFromRs(rs));
					}

				}
				if (fish.getLivingArea().isEmpty()) {
					fish.getLivingArea().add(fetchLivingAreaFromRs(rs));
				} else {
					boolean result = true;
					for (LivingArea area : fish.getLivingArea()) {
						if (area.getId() == rs.getInt("l.area_id")) {
							result = false;
							break;
						}
					}
					if (result) {
						fish.getLivingArea().add(fetchLivingAreaFromRs(rs));
					}
				}

				if (fish.getDaysActivity().isEmpty()) {
					fish.getDaysActivity().add(fetchDayActivityFromRs(rs));
				} else {
					boolean result = true;
					for (DayActivity activity : fish.getDaysActivity()) {
						if (activity.getId() == rs.getInt("d.activity_id")) {
							result = false;
							break;
						}
					}
					if (result) {
						fish.getDaysActivity().add(fetchDayActivityFromRs(rs));
					}
				}

				if (toAdd) {
					fishes.add(fish);
				}
			}

			Log.endDaoLog("getFishes", "fetch size is " + fishes.size());

		} catch (SQLException e) {
			Log.daoException("getFishes", e.getMessage());
			throw new DaoDfmException("Some problem with fetching list of fishes " + "Message: " + e.getMessage(), e);
		} finally {
			close(rs, statement, connection);
		}

		return fishes;
	}

	@Override
	public void updateFish(Fish fish) throws DaoDfmException {

		String sqlInsertFish = "UPDATE fishes SET fish_name = ?, description = ?, fish_type = ?, is_stability = ?, is_high = ?, is_low = ?, is_rise = ?, is_down = ? WHERE fish_id = ?";
		String sqlInsertFishSetting = "UPDATE fish_settings SET param_name = ?, min_range = ?, max_range = ?, nibble_level = ? WHERE setting_id = ?";
		String sqlInsertNibblePeriod = "UPDATE nibble_periods SET start_period = ?, end_period = ?, nibble_level = ? WHERE period_id = ?";
		String sqlInsertLivingArea = "UPDATE living_areas SET area_name = ? WHERE area_id = ?";
		String sqlInsertDayActivity = "UPDATE days_activity SET activity_name = ? WHERE activity_id = ?";

		Connection connection = getConnection();
		PreparedStatement statement = null;

		try {

			Log.startDaoLog("updateFish", fish.toString());

			statement = connection.prepareStatement(sqlInsertFish);
			statement.setString(1, fish.getName());
			statement.setString(2, fish.getDescription());
			statement.setString(3, fish.getFishType());
			statement.setDouble(4, fish.getPressureStates().get(PressureStates.IS_STABILITY));
			statement.setDouble(5, fish.getPressureStates().get(PressureStates.IS_STABILITY_HIGH));
			statement.setDouble(6, fish.getPressureStates().get(PressureStates.IS_STABILITY_LOW));
			statement.setDouble(7, fish.getPressureStates().get(PressureStates.IS_RISE));
			statement.setDouble(8, fish.getPressureStates().get(PressureStates.IS_DOWN));
			statement.setInt(9, fish.getId());
			statement.executeUpdate();
			closePreparedStatement(statement);

			statement = connection.prepareStatement(sqlInsertFishSetting);
			for (FishSetting setting : fish.getFishSetting()) {
				statement.setString(1, setting.getParamName());
				statement.setDouble(2, setting.getMinValue());
				statement.setDouble(3, setting.getMaxValue());
				statement.setDouble(4, setting.getNibbleLevel());
				statement.setInt(5, setting.getId());
				statement.addBatch();
			}
			statement.executeBatch();
			closePreparedStatement(statement);

			statement = connection.prepareStatement(sqlInsertNibblePeriod);
			for (NibblePeriod period : fish.getNibbles()) {
				statement.setDate(1, period.getStartPeriod());
				statement.setDate(2, period.getEndPeriod());
				statement.setDouble(3, period.getNibbleLevel());
				statement.setInt(4, period.getId());
				statement.addBatch();
			}
			statement.executeBatch();
			closePreparedStatement(statement);

			statement = connection.prepareStatement(sqlInsertLivingArea);
			for (LivingArea area : fish.getLivingArea()) {
				statement.setString(1, area.getAreaName());
				statement.setInt(2, area.getId());
				statement.addBatch();
			}
			statement.executeBatch();
			closePreparedStatement(statement);

			statement = connection.prepareStatement(sqlInsertDayActivity);
			for (DayActivity activity : fish.getDaysActivity()) {
				statement.setString(1, activity.getActivityName());
				statement.setInt(2, activity.getId());
				statement.addBatch();
			}
			statement.executeBatch();
			closePreparedStatement(statement);

			connection.commit();

			Log.endDaoLog("updateFish", "update fish with id: " + fish.getId());

		} catch (SQLException e) {
			rollback(connection);
			Log.daoException("updateFish", e.getMessage());
			throw new DaoDfmException("Some problem with fetching list of fishes " + "Message: " + e.getMessage(), e);
		} finally {
			close(statement, connection);
		}

	}

	@Override
	public Integer deleteFish(List<Integer> listId) throws DaoDfmException {

		String sql = "DELETE FROM fishes WHERE fish_id = ?";

		int[] result = null;

		Connection connection = getConnection();
		PreparedStatement statement = null;

		try {
			Log.startDaoLog("deleteFish", "listId size: " + listId.size());

			statement = connection.prepareStatement(sql);

			for (Integer baitId : listId) {
				statement.setInt(1, baitId);
				statement.addBatch();
			}
			result = statement.executeBatch();
			connection.commit();

			Log.endDaoLog("deleteFish", "listId size: " + listId.size());

			if (result != null) {
				return 1;
			} else {
				return 0;
			}

		} catch (SQLException e) {
			rollback(connection);
			Log.daoException("deleteFish", e.getMessage());
			throw new DaoDfmException("Some problem with deleting list of fishes " + "Message: " + e.getMessage(), e);
		} finally {
			close(statement, connection);
		}

	}

	private FishSetting fetchFishSettinsFromRs(ResultSet rs) throws SQLException {
		FishSetting fishSetting = new FishSetting();
		fishSetting.setId(rs.getInt("fs.setting_id"));
		fishSetting.setFishId(rs.getInt("fs.fish_id"));
		fishSetting.setParamName(rs.getString("fs.param_name"));
		fishSetting.setMinValue(rs.getDouble("fs.min_range"));
		fishSetting.setMaxValue(rs.getDouble("fs.max_range"));
		fishSetting.setNibbleLevel(rs.getDouble("fs.nibble_level"));
		return fishSetting;
	}

	private NibblePeriod fetchNibblePeriodFromRs(ResultSet rs) throws SQLException {
		NibblePeriod nibblePeriod = new NibblePeriod();
		nibblePeriod.setId(rs.getInt("n.period_id"));
		nibblePeriod.setFishId(rs.getInt("n.fish_id"));
		nibblePeriod.setStartPeriod(rs.getDate("n.start_period"));
		nibblePeriod.setEndPeriod(rs.getDate("n.end_period"));
		nibblePeriod.setNibbleLevel(rs.getDouble("n.nibble_level"));
		return nibblePeriod;
	}

	private LivingArea fetchLivingAreaFromRs(ResultSet rs) throws SQLException {
		LivingArea area = new LivingArea();
		area.setId(rs.getInt("l.area_id"));
		area.setFishId(rs.getInt("l.fish_id"));
		area.setAreaName(rs.getString("l.area_name"));
		return area;
	}

	private DayActivity fetchDayActivityFromRs(ResultSet rs) throws SQLException {
		DayActivity activity = new DayActivity();
		activity.setId(rs.getInt("d.activity_id"));
		activity.setFishId(rs.getInt("d.fish_id"));
		activity.setActivityName(rs.getString("d.activity_name"));
		return activity;
	}
}
