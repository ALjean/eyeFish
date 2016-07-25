package com.jean.dao.impl;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.jean.DaoDfmException;

import com.jean.dao.BaitDao;
import com.jean.entity.Bait;
import com.jean.entity.BaitSetting;
import com.jean.entity.DateHolder;
import com.jean.entity.PondEnvirmoment;
import com.jean.entity.Qualifier;
import com.jean.enums.ParamNames;
import com.jean.util.Log;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class BaitDaoImpl extends BaseDaoImpl implements BaitDao {

	@Override
	public Integer saveBait(Bait bait) throws DaoDfmException {

		String sqlInsertBaits = "INSERT INTO baits (bait_name, bait_type, description) VALUES (?, ?, ?)";
		String sqlInsertBaitSettings = "INSERT INTO bait_settings (bait_id, setting_name, setting_type, description) VALUES (?, ?, ?, ?)";
		String sqlInsertQulifers = "INSERT INTO qualifiers (setting_id, param_name, min_level, max_level) VALUES (?, ?, ?, ?)";
		String sqlInsertToBindingToFishes = "INSERT INTO baits_to_fishes (bait_id, fish_id) VALUES (?, ?)";
		String sqlInsertToBindingToSeasons = "INSERT INTO baits_to_seasons (bait_id, start_period, end_period) VALUES (?, ?, ?)";

		Connection connection = null;
		PreparedStatement statement = null;
		int baitId = 0;
		int settingId;

		try {
			Log.startDaoLog("saveBait", bait.toString());

			connection = getConnection();

			statement = connection.prepareStatement(sqlInsertBaits, Statement.RETURN_GENERATED_KEYS);
			setBaitStatement(bait, statement);
			statement.executeUpdate();
			baitId = getGeneratedKey(statement);
			closePreparedStatement(statement);

			statement = connection.prepareStatement(sqlInsertBaitSettings, Statement.RETURN_GENERATED_KEYS);
			for (BaitSetting baitSetting : bait.getBaitSetting()) {

				setBaitSetting(baitId, baitSetting, statement);
				statement.executeUpdate();
				settingId = getGeneratedKey(statement);

				statement = connection.prepareStatement(sqlInsertQulifers);
				for (int i = 0; baitSetting.getQualifers().size() > i; i++) {
					Qualifier qualifier = baitSetting.getQualifers().get(i);
					setQulifierStatement(settingId, qualifier, statement);
					statement.addBatch();
				}
				statement.executeBatch();
				closePreparedStatement(statement);

				statement = connection.prepareStatement(sqlInsertBaitSettings, Statement.RETURN_GENERATED_KEYS);
			}
			closePreparedStatement(statement);

			statement = connection.prepareStatement(sqlInsertToBindingToFishes);
			for (Integer fishId : bait.getFishId()) {
				statement.setInt(1, baitId);
				statement.setInt(2, fishId);
				statement.addBatch();
			}
			statement.executeBatch();
			closePreparedStatement(statement);

			statement = connection.prepareStatement(sqlInsertToBindingToSeasons);
			for (DateHolder dates : bait.getDates()) {
				statement.setInt(1, baitId);
				statement.setDate(2, dates.getStart_period());
				statement.setDate(3, dates.getEnd_period());
				statement.executeUpdate();
			}
			statement.executeBatch();
			closePreparedStatement(statement);

			connection.commit();

			Log.endDaoLog("saveBait", "baitId is " + baitId);

		} catch (SQLException e) {
			rollback(connection);
			Log.daoException("saveBait", e.getMessage());
			throw new DaoDfmException("Some problem with save bait. " + "Message: " + e.getMessage(), e);
		} finally {
			close(statement, connection);
		}

		return baitId;
	}

	@Override
	public List<Bait> getBaits(Integer baitId, String baitType, String baitName, Integer fishId, Date date)
			throws DaoDfmException {

		String sql =

				"SELECT DISTINCT b.bait_id, b.bait_type, b.bait_name, b.description, bs.setting_id, bs.setting_name, bs.setting_type, bs.description, q.qual_id, q.param_name, q.min_level, q.max_level "
						+ "FROM " + "qualifiers AS q " + "INNER JOIN "
						+ "bait_settings AS bs ON bs.setting_id = q.setting_id " + "INNER JOIN "
						+ "baits_to_fishes AS bf ON bf.bait_id = bs.bait_id " + "INNER JOIN "
						+ "baits_to_seasons AS b_seas ON b_seas.bait_id = bs.bait_id " + "INNER JOIN "
						+ "baits AS b ON b.bait_id = bf.bait_id " + "WHERE " + "(bf.fish_id = ? OR ? IS NULL) " + "AND "
						+ "(b.bait_id = ? OR ? IS NULL) " + "AND " + "(b.bait_name LIKE ? OR ? IS NULL) " + "AND"
						+ "(b.bait_type LIKE ? OR ? IS NULL) " + "AND "
						+ "((? BETWEEN b_seas.start_period AND b_seas.end_period) OR ? IS NULL)";

		List<Bait> baits = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);

			Log.startDaoLog("getBaits",
					"fishId: " + fishId + ", baitId: " + baitId + ", baitName: " + baitName + ", date: " + date);

			if (fishId != null) {
				preparedStatement.setFloat(1, fishId);
				preparedStatement.setFloat(2, fishId);
			} else {
				preparedStatement.setNull(1, Types.DOUBLE);
				preparedStatement.setNull(2, Types.DOUBLE);
			}

			if (baitId != null) {
				preparedStatement.setInt(3, baitId);
				preparedStatement.setInt(4, baitId);
			} else {
				preparedStatement.setNull(3, Types.INTEGER);
				preparedStatement.setNull(4, Types.INTEGER);
			}

			if (!StringUtils.isEmpty(baitName)) {
				preparedStatement.setString(5, baitName.replace("*", "%"));
				preparedStatement.setString(6, baitName.replace("*", "%"));
			} else {
				preparedStatement.setNull(5, Types.CHAR);
				preparedStatement.setNull(6, Types.CHAR);
			}

			if (!StringUtils.isEmpty(baitType)) {
				preparedStatement.setString(7, baitType.replace("*", "%"));
				preparedStatement.setString(8, baitType.replace("*", "%"));
			} else {
				preparedStatement.setNull(7, Types.CHAR);
				preparedStatement.setNull(8, Types.CHAR);
			}

			if (date != null) {
				preparedStatement.setDate(9, date);
				preparedStatement.setDate(10, date);
			} else {
				preparedStatement.setNull(9, Types.CHAR);
				preparedStatement.setNull(10, Types.CHAR);
			}

			rs = preparedStatement.executeQuery();

			Bait tempBait = null;
			BaitSetting tempSetting = null;

			while (rs.next()) {

				Bait bait = null;
				BaitSetting baitSetting = null;
				Qualifier qualifier = new Qualifier();

				qualifier.setQuaId(rs.getInt("q.qual_id"));
				qualifier.setParamName(rs.getString("q.param_name"));
				qualifier.setMin(rs.getFloat("q.min_level"));
				qualifier.setMax(rs.getFloat("q.max_level"));

				if (tempSetting == null || tempSetting.getSettingId() != rs.getInt("bs.setting_id")) {
					baitSetting = new BaitSetting();
					baitSetting.getQualifers().add(qualifier);
					baitSetting.setSettingId(rs.getInt("bs.setting_id"));
					baitSetting.setSettingName(rs.getString("bs.setting_name"));
					baitSetting.setSettingType(rs.getString("bs.setting_type"));
					baitSetting.setDescription(rs.getString("bs.description"));
					tempSetting = baitSetting;
				} else {
					tempSetting.getQualifers().add(qualifier);
				}

				if (tempBait == null || tempBait.getBaitId() != rs.getInt("b.bait_id")) {
					bait = new Bait();
					bait.getBaitSetting().add(baitSetting);
					bait.setBaitId(rs.getInt("b.bait_id"));
					bait.setBaitType(rs.getString("b.bait_type"));
					bait.setBaitName(rs.getString("b.bait_name"));
					bait.setDescription(rs.getString("b.description"));
					tempBait = bait;
				} else {
					if (baitSetting != null) {
						tempBait.getBaitSetting().add(baitSetting);
					} else {
						tempBait.getBaitSetting().add(tempSetting);
					}
				}

				if (bait != null) {
					baits.add(bait);
				}

			}

			Log.endDaoLog("getBaits", "fetch size is " + baits.size());

		} catch (SQLException e) {
			Log.daoException("getBaits", e.getMessage());
			throw new DaoDfmException("Some problem with fetching list of baits " + "Message: " + e.getMessage(), e);
		} finally {
			close(rs, preparedStatement, connection);
		}

		return baits;

	}

	@Override
	public void updateBait(Bait bait) throws DaoDfmException {

		String sqlInsertBaits = "UPDATE baits SET bait_name = ?, bait_type = ?, description = ? WHERE bait_id = ?";
		String sqlInsertBaitSettings = "UPDATE bait_settings SET setting_name = ?, setting_type = ?, description = ? WHERE setting_id = ?";
		String sqlInsertQulifers = "UPDATE qualifiers SET param_name = ?, min_level = ?, max_level = ? WHERE setting_id = ?";
		String sqlInsertToBindingToFishes = "UPDATE baits_to_fishes SET fish_id = ? WHERE bait_id = ?";
		String sqlInsertToBindingToSeasons = "UPDATE baits_to_seasons SET start_period = ?, end_period = ? WHERE bait_id = ?";

		Connection connection = getConnection();
		PreparedStatement statement = null;

		try {
			Log.startDaoLog("updateBait", bait.toString());

			statement = connection.prepareStatement(sqlInsertBaits);
			statement.setString(1, bait.getBaitName());
			statement.setString(2, bait.getBaitName());
			statement.setString(3, bait.getDescription());
			statement.setInt(4, bait.getBaitId());
			statement.executeUpdate();
			closePreparedStatement(statement);

			statement = connection.prepareStatement(sqlInsertBaitSettings);

			for (BaitSetting baitSetting : bait.getBaitSetting()) {

				statement.setString(1, baitSetting.getSettingName());
				statement.setString(2, baitSetting.getSettingType());
				statement.setString(3, baitSetting.getDescription());
				statement.setInt(4, baitSetting.getSettingId());
				statement.executeUpdate();
				closePreparedStatement(statement);

				statement = connection.prepareStatement(sqlInsertQulifers);
				for (int i = 0; baitSetting.getQualifers().size() > i; i++) {
					Qualifier qualifier = baitSetting.getQualifers().get(i);
					statement.setString(1, qualifier.getParamName());
					statement.setFloat(2, qualifier.getMin());
					statement.setFloat(3, qualifier.getMax());
					statement.setFloat(4, baitSetting.getSettingId());
					statement.addBatch();
				}
				statement.executeBatch();
				closePreparedStatement(statement);

				statement = connection.prepareStatement(sqlInsertBaitSettings);
			}
			closePreparedStatement(statement);

			statement = connection.prepareStatement(sqlInsertToBindingToFishes);
			for (Integer fishId : bait.getFishId()) {
				statement.setInt(1, fishId);
				statement.setInt(2, bait.getBaitId());
				statement.addBatch();
			}
			statement.executeBatch();
			closePreparedStatement(statement);

			statement = connection.prepareStatement(sqlInsertToBindingToSeasons);
			for (DateHolder dates : bait.getDates()) {
				statement.setDate(1, dates.getStart_period());
				statement.setDate(2, dates.getEnd_period());
				statement.setInt(3, bait.getBaitId());
				statement.addBatch();
			}
			statement.executeBatch();
			closePreparedStatement(statement);

			connection.commit();

			Log.endDaoLog("updateBait", "baitId is " + bait.getBaitId());

		} catch (

		SQLException e) {
			rollback(connection);
			Log.daoException("saveBait", e.getMessage());
			throw new DaoDfmException("Some problem with save bait. " + "Message: " + e.getMessage(), e);
		} finally {
			close(statement, connection);
		}
	}

	@Override
	public Integer deleteBait(List<Integer> listId) throws DaoDfmException {

		String sql = "DELETE FROM baits WHERE bait_id = ?";

		int[] result;

		Connection connection = null;
		PreparedStatement statement = null;
		try {

			Log.startDaoLog("deleteBait", "listId size: " + listId.size());

			connection = getConnection();
			statement = connection.prepareStatement(sql);

			for (Integer baitId : listId) {
				statement.setInt(1, baitId);
				statement.addBatch();
			}
			result = statement.executeBatch();
			connection.commit();

			Log.endDaoLog("deleteBait", "listId size: " + listId.size());

			if (result != null) {
				return 1;
			} else {
				return 0;
			}

		} catch (SQLException e) {
			rollback(connection);
			Log.daoException("deleteBait", e.getMessage());
			throw new DaoDfmException("Some problem with deleting list of baits " + "Message: " + e.getMessage(), e);
		} finally {

			close(statement, connection);
		}

	}

	private void setBaitStatement(Bait bait, PreparedStatement statement) throws SQLException {
		statement.setString(1, bait.getBaitName());
		statement.setString(2, bait.getBaitType());
		statement.setString(3, bait.getDescription());
	}

	private void setQulifierStatement(int settingId, Qualifier qualifier, PreparedStatement statement)
			throws SQLException {
		statement.setInt(1, settingId);
		statement.setString(2, qualifier.getParamName());
		statement.setFloat(3, qualifier.getMin());
		statement.setFloat(4, qualifier.getMax());
	}

	private void setBaitSetting(int baitId, BaitSetting baitSetting, PreparedStatement statement) throws SQLException {
		statement.setInt(1, baitId);
		statement.setString(2, baitSetting.getSettingName());
		statement.setString(3, baitSetting.getSettingType());
		statement.setString(4, baitSetting.getDescription());
	}

}
