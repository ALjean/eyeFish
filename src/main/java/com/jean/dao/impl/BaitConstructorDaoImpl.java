package com.jean.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.jean.DaoDfmException;
import com.jean.dao.BaitConstructorDao;
import com.jean.entity.Bait;
import com.jean.entity.PondEnvirmoment;
import com.jean.enums.ParamNames;
import com.jean.util.BaitSetting;
import com.jean.util.Log;
import com.jean.util.Qualifier;

@Repository
public class BaitConstructorDaoImpl extends BaseDaoImpl implements BaitConstructorDao {

	public List<Bait> getOptimalBaits(Integer fishId, String baitType, String baitName, PondEnvirmoment pondEnv)
			throws DaoDfmException {

		List<Bait> baits = new ArrayList<Bait>();

		List<Integer> baitsId = getBaitsId(fishId, baitType, baitName, pondEnv.getDate());

		if (baitsId.isEmpty()) {
			throw new DaoDfmException("List baitId is empty");
		}
		for (Integer id : baitsId) {
			baits.addAll(getBaitsByPondParams(pondEnv, getParameterNames(id, false), id));
		}

		return baits;
	}

	private List<Bait> getBaitsByPondParams(PondEnvirmoment pondEnv, List<String> names, int baitId)
			throws DaoDfmException {

		StringBuilder sql = new StringBuilder(

				"SELECT DISTINCT b.bait_id, b.bait_type, b.bait_name, b.description, bs.setting_id, bs.setting_name, bs.setting_type, bs.description, q.qual_id, q.param_name, q.min_level, q.max_level "
						+ "FROM " + "qualifiers AS q " + "INNER JOIN "
						+ "bait_settings AS bs ON bs.setting_id = q.setting_id " + "INNER JOIN "
						+ "baits_to_fishes AS bf ON bf.bait_id = bs.bait_id " + "INNER JOIN "
						+ "baits_to_seasons AS b_seas ON b_seas.bait_id = bs.bait_id " + "INNER JOIN "
						+ "baits AS b ON b.bait_id = bf.bait_id " + "WHERE " + "b.bait_id = ?");
		if (names.size() > 0) {
			for (String paramName : names) {
				sql.append(" AND q.param_name = '" + paramName + "' AND (" + setParamNamesInSql(paramName, pondEnv)
						+ " BETWEEN q.min_level AND q.max_level )");
			}
		}
		List<Bait> baits = new ArrayList<Bait>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql.toString());
			preparedStatement.setInt(1, baitId);
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
					}
				}

				if (bait != null) {
					baits.add(bait);
				}
			}

			Log.endDaoLog("getBaitsByPondParameters", "fetch size is " + baits.size());

		} catch (SQLException e) {
			Log.daoException("getBaitsByPondParameters", e.getMessage());
			throw new DaoDfmException("Some problem with fetching list of baits " + "Message: " + e.getMessage(), e);
		} finally {
			close(rs, preparedStatement, connection);

		}

		return baits;
	}

	private List<Integer> getBaitsId(Integer fishId, String baitType, String baitName, Date date)
			throws DaoDfmException {

		String sql =

				"SELECT DISTINCT b.bait_id, b.bait_type, b.bait_name, b.description FROM baits_to_fishes AS bf INNER JOIN baits_to_seasons AS bs ON bs.bait_id = bf.bait_id INNER JOIN baits AS b ON b.bait_id = bf.bait_id WHERE (bf.fish_id = ? OR ? IS NULL) AND (b.bait_type LIKE ? OR ? IS NULL) AND ((? BETWEEN bs.start_period AND bs.end_period) OR ? IS NULL)";

		List<Integer> baitsId = new ArrayList<Integer>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);

			Log.startDaoLog("getBaitsId", "fishId: " + fishId + ", baitName: " + baitName + ", date: " + date);

			if (fishId != null) {
				preparedStatement.setFloat(1, fishId);
				preparedStatement.setFloat(2, fishId);
			} else {
				preparedStatement.setNull(1, Types.DOUBLE);
				preparedStatement.setNull(2, Types.DOUBLE);
			}

			if (!StringUtils.isEmpty(baitType)) {
				preparedStatement.setString(3, baitType.replace("*", "%"));
				preparedStatement.setString(4, baitType.replace("*", "%"));
			} else {
				preparedStatement.setNull(3, Types.CHAR);
				preparedStatement.setNull(4, Types.CHAR);
			}

			if (date != null) {
				preparedStatement.setDate(5, date);
				preparedStatement.setDate(6, date);
			} else {
				preparedStatement.setNull(5, Types.CHAR);
				preparedStatement.setNull(6, Types.CHAR);
			}

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				baitsId.add(rs.getInt("b.bait_id"));
			}
		} catch (SQLException e) {
			Log.daoException("getBaitsId", e.getMessage());
			throw new DaoDfmException("Some problem with fetching list of baitsId " + "Message: " + e.getMessage(), e);
		} finally {
			close(rs, preparedStatement, connection);
		}
		return baitsId;
	}

	private List<String> getParameterNames(int baitId, boolean isPeeperConnected) throws DaoDfmException {

		String sql =

				"SELECT DISTINCT q.param_name " + "FROM " + "baits AS b " + "INNER JOIN "
						+ "bait_settings AS bs ON b.bait_id = bs.bait_id " + "INNER JOIN "
						+ "qualifiers AS q ON q.setting_id = bs.setting_id " + "WHERE " + "b.bait_id = ?;";

		List<String> names = new ArrayList<String>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		try {

			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);

			Log.startDaoLog("getParametersNames", "baitId: " + baitId);
			preparedStatement.setFloat(1, baitId);
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String name = rs.getString("q.param_name");
				if (!isPeeperConnected) {
					if (!name.equals(ParamNames.DEEP_LEVEL.name()) && !name.equals(ParamNames.ALGA_LEVEL.name())) {
						names.add(name);
					} 
				}else{
					names.add(name);
				}
			}
		} catch (SQLException e) {
			Log.daoException("getParameterNames", e.getMessage());
			throw new DaoDfmException(
					"Some problem with fetching list parameter namees " + "Message: " + e.getMessage(), e);
		} finally {
			close(rs, preparedStatement, connection);
		}
		return names;
	}

	private Float setParamNamesInSql(String paramName, PondEnvirmoment pondEnv) throws DaoDfmException {

		float result = -100;

		if (paramName.equals(ParamNames.ALGA_LEVEL.name())) {
			result = pondEnv.getAlgalevel();
		}
		if (paramName.equals(ParamNames.DEEP_LEVEL.name())) {
			result = pondEnv.getDeepLevel();
		}
		if (paramName.equals(ParamNames.CLOUD_LEVEL.name())) {
			result = pondEnv.getCloudLevel();
		}
		if (paramName.equals(ParamNames.ENVIRMOMENT_TEMPERATURE.name())) {
			result = pondEnv.getTemp();
		}
		if (paramName.equals(ParamNames.PRESSURE.name())) {
			result = pondEnv.getPressure();
		}
		if (paramName.equals(ParamNames.RAIN_LEVEL.name())) {
			result = pondEnv.getRainLevel();
		}
		if (paramName.equals(ParamNames.WIND_SPEED.name())) {
			result = pondEnv.getWindSpeed();
		}

		if (result == -100) {
			throw new DaoDfmException("ParameterName wasn't selected");
		}
		return result;

	}
}
