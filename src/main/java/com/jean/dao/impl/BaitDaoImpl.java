package com.jean.dao.impl;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jean.dao.BaitDao;
import com.jean.entity.Bait;
import com.jean.entity.BaitPropertieType;
import com.jean.entity.BaitType;
import com.jean.entity.DateHolder;
import com.jean.entity.ParameterName;
import com.jean.entity.PondEnvirmoment;
import com.jean.entity.RangeHolder;
import com.jean.util.BaitSetting;
import com.jean.util.Qualifier;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class BaitDaoImpl extends BaseDaoImpl implements BaitDao {

    private static Logger log = LoggerFactory.getLogger(BaitDaoImpl.class);

    @Override
    public List<Bait> getBaitsToFishesByDate(int fishId, Date date) throws DaoDfmException {

	String sql =

	"SELECT b.bait_id, b.bait_name, bt.bait_type_name, bt.bait_type_id, b.description " + "FROM " + "baits AS b " + "INNER JOIN"
		+ " bait_types AS bt ON bt.bait_type_id = b.bait_type_id " + "INNER JOIN " + "baits_to_fishes AS btf ON btf.bait_id = b.bait_id "
		+ "INNER JOIN " + "baits_to_seasons AS bts ON bts.bait_id = b.bait_id "
		+ "WHERE ? BETWEEN bts.start_period AND bts.end_period AND btf.fish_id = ?";

	List<Bait> baits = new ArrayList<>();

	log.info("Starting method getBaitsForFishByDate(), with parameter values: [ fishId: " + fishId + ", date: " + date + " ]");

	try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

	    preparedStatement.setDate(1, date);
	    preparedStatement.setInt(2, fishId);

	    ResultSet rs = preparedStatement.executeQuery();

	    while (rs.next()) {
		baits.add(getBaitFromRs(rs));
	    }

	    if (baits.isEmpty()) {
		throw new DaoDfmException("For some reason list of baits is empty");
	    }

	} catch (SQLException e) {
	    throw new DaoDfmException("Some problem with fetching list of baits " + "Message: " + e.getMessage(), e);
	}

	log.info("End method getBaitColors(), list size is: " + baits.size());

	return baits;
    }

    @Override
    public Integer saveBait(Bait bait) throws DaoDfmException, CustomDfmException {

	String sqlInsertBaits = "INSERT INTO baits (bait_name, description) VALUES (?, ?)";
	String sqlInsertBaitSettings = "INSERT INTO bait_settings (bait_id, setting_name, setting_type, description) VALUES (?, ?, ?, ?)";
	String sqlInsertQulifers = "INSERT INTO qualifiers (setting_id, param_name, min_level, max_level) VALUES (?, ?, ?, ?)";
	String sqlInsertToBindingToFishes = "INSERT INTO baits_to_fishes (bait_id, fish_id) VALUES (?, ?)";
	String sqlInsertToBindingToSeasons = "INSERT INTO baits_to_seasons (bait_id, start_period, end_period) VALUES (?, ?, ?)";

	Connection connection = getConnection();
	PreparedStatement statement = null;
	int baitId;
	int settingId;

	try {

	    statement = connection.prepareStatement(sqlInsertBaits, Statement.RETURN_GENERATED_KEYS);
	    setBaitStatement(bait, statement);
	    statement.executeUpdate();
	    baitId = getGeneratedKey(statement);

	    statement = connection.prepareStatement(sqlInsertBaitSettings, Statement.RETURN_GENERATED_KEYS);

	    for (BaitSetting baitSetting : bait.getBaitSetting()) {

		setBaitSetting(baitId, baitSetting, statement);
		statement.executeUpdate();
		settingId = getGeneratedKey(statement);

		statement = connection.prepareStatement(sqlInsertQulifers);

		for (int i = 0; baitSetting.getQualifers().size() > i; i++) {

		    Qualifier qualifier = baitSetting.getQualifers().get(i);
		    setQulifierStatement(settingId, qualifier, statement);
		    statement.executeUpdate();

		    if (i == baitSetting.getQualifers().size()) {
			statement = connection.prepareStatement(sqlInsertBaitSettings, Statement.RETURN_GENERATED_KEYS);
		    }
		}
	    }

	    statement = connection.prepareStatement(sqlInsertToBindingToFishes);
	    for (Integer fishId : bait.getFishId()) {
		statement.setInt(1, baitId);
		statement.setInt(2, fishId);
		statement.executeUpdate();
	    }

	    statement = connection.prepareStatement(sqlInsertToBindingToSeasons);
	    for (DateHolder dates : bait.getDates()) {
		statement.setInt(1, baitId);
		statement.setDate(2, dates.getStart_period());
		statement.setDate(3, dates.getEnd_period());
		statement.executeUpdate();
	    }
	    connection.commit();

	} catch (SQLException e) {
	    throw new DaoDfmException("Some problem with save bait. " + "Message: " + e.getMessage(), e);
	}

	return baitId;
    }

    public List<Bait> getBaitListToFish(int id) throws DaoDfmException {

	String sql = "";

	try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

	    preparedStatement.setInt(1, id);

	    ResultSet rs = preparedStatement.executeQuery();

	    List<Bait> list = new ArrayList<>();

	    while (rs.next()) {
		list.add(getBaitFromRs(rs));
	    }

	    return list;

	} catch (SQLException e) {
	    throw new DaoDfmException("Some problem with save message text. " + "Message: " + e.getMessage(), e);
	}

    }

    @Override
    public Bait getBait(int baitId) throws DaoDfmException, CustomDfmException {

	String sql =

	"SELECT b.bait_id, b.bait_name, bt.bait_type_id, bt.bait_type_name, b.description " + "FROM " + "baits AS b " + "INNER JOIN "
		+ "bait_types AS bt ON b.bait_type_id = bt.bait_type_id " + "WHERE b.bait_id = ?";

	Bait bait = null;

	try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

	    preparedStatement.setInt(1, baitId);
	    ResultSet rs = preparedStatement.executeQuery();
	    rs.next();
	    bait = getBaitFromRs(rs);

	} catch (SQLException e) {
	    throw new DaoDfmException("Some problem with fetching bait: " + baitId + "Message: " + e.getMessage());
	}
	return bait;

    }

    @Override
    public List<Bait> getBaitsToFishes(int fishId) throws DaoDfmException {

	String sql =

	"SELECT b.bait_id, b.bait_name, bt.bait_type_id, bt.bait_type_name, b.description " + "FROM " + "baits AS b " + "INNER JOIN "
		+ "bait_types AS bt ON b.bait_type_id = bt.bait_type_id " + "INNER JOIN " + "baits_to_fishes AS bts ON bts.bait_id = b.bait_id "
		+ "WHERE bts.fish_id = ?";

	List<Bait> baits = new ArrayList<Bait>();

	try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

	    preparedStatement.setInt(1, fishId);
	    ResultSet rs = preparedStatement.executeQuery();
	    while (rs.next()) {
		baits.add(getBaitFromRs(rs));
	    }

	    if (baits.isEmpty()) {
		throw new DaoDfmException("For some reason list of baits is empty");
	    }

	} catch (SQLException e) {
	    throw new DaoDfmException("Some problem with fetching list of baits " + "Message: " + e.getMessage(), e);
	}

	log.info("End method getBaitColors(), list size is: " + baits.size());

	return baits;
    }

    @Override
    public List<Bait> getBaitsBySeason(Date date) throws DaoDfmException {
	String sql =

	"SELECT b.bait_id, b.bait_name, bt.bait_type_name, bt.bait_type_id, b.description " + "FROM " + "baits AS b " + "INNER JOIN"
		+ " bait_types AS bt ON bt.bait_type_id = b.bait_type_id " + "INNER JOIN " + "baits_to_seasons AS bts ON bts.bait_id = b.bait_id "
		+ "WHERE ? BETWEEN bts.start_period AND bts.end_period";

	List<Bait> baits = new ArrayList<>();

	try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

	    preparedStatement.setDate(1, date);

	    ResultSet rs = preparedStatement.executeQuery();

	    while (rs.next()) {
		baits.add(getBaitFromRs(rs));
	    }

	    if (baits.isEmpty()) {
		throw new DaoDfmException("For some reason list of baits is empty");
	    }

	} catch (SQLException e) {
	    throw new DaoDfmException("Some problem with fetching list of baits " + "Message: " + e.getMessage(), e);
	}

	log.info("End method getBaitColors(), list size is: " + baits.size());

	return baits;
    }

    @Override
    public List<Bait> getBaits(Integer baitId, String baitName, Date date, Integer fishId, PondEnvirmoment pondEnv)
	    throws DaoDfmException, CustomDfmException {

	String sql =

	"SELECT DISTINCT b.bait_id, b.bait_name, b.description, bs.setting_name, bs.setting_type, b.description, q.param_name " 
	+ "FROM "
	+ "qualifiers AS q " + "INNER JOIN " + "bait_settings AS bs ON bs.setting_id = q.setting_id " 
	+ "INNER JOIN "
	+ "baits_to_fishes AS bf ON bf.bait_id = bs.bait_id " + "INNER JOIN " 
	+ "baits_to_seasons AS b_seas ON b_seas.bait_id = bs.bait_id "
	+ "INNER JOIN " 
	+ "baits AS b ON b.bait_id = bf.bait_id " + "WHERE " + "( "
	+ "q.param_name = 'CLOUD_LEVEL' AND (? BETWEEN q.min_level AND q.max_level) " 
	+ "OR "
	+ "q.param_name = 'DEEP_LEVEL' AND (? BETWEEN q.min_level AND q.max_level) " 
	+ "OR "
	+ "q.param_name = 'ENVIRONMENT_TEMPERATURE' AND (? BETWEEN q.min_level AND q.max_level) " 
	+ "OR "
	+ "q.param_name = 'WATER_TEMPERATURE' AND (? BETWEEN q.min_level AND q.max_level) " 
	+ "OR "
	+ "q.param_name = 'ALGA_LEVEL' AND (? BETWEEN q.min_level AND q.max_level) " 
	+ "OR "
	+ "q.param_name = 'RAIN_LEVEL' AND (? BETWEEN q.min_level AND q.max_level) " 
	+ "OR "
	+ "q.param_name = 'WIND_SPEED' AND (? BETWEEN q.min_level AND q.max_level) " 
	+ "OR "
	+ "q.param_name = 'PRESSURE' AND (? BETWEEN q.min_level AND q.max_level)" 
	+ ") " 
	+ "AND "
	+ "(bf.fish_id = ? OR ? IS NULL) " 
	+ "AND "
	+ "(b.bait_id = ? OR ? IS NULL) " 
	+ "AND "
	+ "(b.bait_name = ? OR ? IS NULL) " 
	+ "AND "
	+ "((? BETWEEN b_seas.start_period AND b_seas.end_period) OR ? IS NULL)";

	List<Bait> baits = new ArrayList<>();

	try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

	    preparedStatement.setDouble(1, pondEnv.getCloudLevel());
	    preparedStatement.setDouble(2, pondEnv.getDeepLevel());
	    preparedStatement.setDouble(3, pondEnv.getEnvirmomentTemp());
	    preparedStatement.setDouble(4, pondEnv.getWaterTemp());
	    preparedStatement.setDouble(5, pondEnv.getAlgalevel());
	    preparedStatement.setDouble(6, pondEnv.getRainLevel());
	    preparedStatement.setDouble(7, pondEnv.getWindSpeed());
	    preparedStatement.setDouble(8, pondEnv.getPressure());

	    if (fishId != null) {
		preparedStatement.setDouble(9, fishId);
		preparedStatement.setDouble(10, fishId);
	    } else {
		preparedStatement.setNull(9, Types.DOUBLE);
		preparedStatement.setNull(10, Types.DOUBLE);
	    }

	    if (baitId != null) {
		preparedStatement.setInt(11, baitId);
		preparedStatement.setInt(12, baitId);
	    } else {
		preparedStatement.setNull(11, Types.INTEGER);
		preparedStatement.setNull(12, Types.INTEGER);
	    }

	    if (!StringUtils.isEmpty(baitName)) {
		preparedStatement.setString(13, baitName);
		preparedStatement.setString(14, baitName);
	    } else {
		preparedStatement.setNull(13, Types.CHAR);
		preparedStatement.setNull(14, Types.CHAR);
	    }

	    if (date != null) {
		preparedStatement.setDate(15, date);
		preparedStatement.setDate(16, date);
	    } else {
		preparedStatement.setNull(15, Types.CHAR);
		preparedStatement.setNull(16, Types.CHAR);
	    }

	    ResultSet rs = preparedStatement.executeQuery();
	    
	    Bait bait = new Bait();	
	    BaitSetting baitSetting = new BaitSetting();
	    
	    while (rs.next()) {
		bait.setBaitId(rs.getInt("b.bait_id"));
		bait.setBaitName(rs.getString("b.bait_name"));
		bait.setDescription(rs.getString("b.description"));
	    }

	} catch (SQLException e) {
	    throw new DaoDfmException("Some problem with fetching list of baits " + "Message: " + e.getMessage(), e);
	}

	return baits;
    }

    @Override
    public void updateBait(Bait bait) throws DaoDfmException, CustomDfmException {

	/*
	 * String sql =
	 * "UPDATE baits AS b SET b.bait_name = ?, b.bait_type_id = ?, b.description = ? WHERE b.bait_id = ?"
	 * ; Connection connection = getConnection(); int result;
	 * 
	 * try (PreparedStatement preparedStatement =
	 * connection.prepareStatement(sql)) {
	 * 
	 * preparedStatement.setString(1, bait.getName());
	 * preparedStatement.setInt(2, bait.getBaitType().getTypeId());
	 * preparedStatement.setString(3, bait.getDescription());
	 * preparedStatement.setInt(4, bait.getId());
	 * 
	 * result = preparedStatement.executeUpdate();
	 * 
	 * if (result == 0) { throw new CustomDfmException(
	 * "Update didn't comlete: " + bait.toString()); }
	 * 
	 * connection.commit();
	 * 
	 * } catch (SQLException e) { throw new DaoDfmException("SQLEror: " +
	 * bait.toString() + e.getMessage()); }
	 */
    }

    @Override
    public void deleteBait(int baitId) throws DaoDfmException, CustomDfmException {

	String sqlDeleteBait = "DELETE FROM baits WHERE bait_id = ?";
	String sqlDeleteBinding = "DELETE FROM baits_to_fishes WHERE bait_id = ?";
	String sqlDeleteSeason = "DELETE FROM baits_to_seasons WHERE bait_id = ?";

	Connection connection = getConnection();
	PreparedStatement statement = null;
	int result;

	try {

	    statement = connection.prepareStatement(sqlDeleteBinding);
	    statement.setInt(1, baitId);
	    statement.executeUpdate();

	    statement = connection.prepareStatement(sqlDeleteSeason);
	    statement.setInt(1, baitId);
	    statement.executeUpdate();

	    statement = connection.prepareStatement(sqlDeleteBait);
	    statement.setInt(1, baitId);
	    result = statement.executeUpdate();

	    if (result == 0) {
		throw new CustomDfmException("Delete didn't comlete with baitId: " + baitId);
	    }

	    connection.commit();

	} catch (SQLException e) {
	    throw new DaoDfmException("SQLEror: " + baitId + e.getMessage());
	}

    }

    private Bait getBaitFromRs(ResultSet rs) throws SQLException {
	Bait bait = new Bait();
	/*
	 * bait.setId(rs.getInt("bait_id"));
	 * bait.setName(rs.getString("bait_name"));
	 * bait.setDescription(rs.getString("description"));
	 */
	return bait;
    }

    private void setBaitStatement(Bait bait, PreparedStatement statement) throws SQLException {
	statement.setString(1, bait.getBaitName());
	statement.setString(2, bait.getDescription());
    }

    private void setQulifierStatement(int settingId, Qualifier qualifier, PreparedStatement statement) throws SQLException {
	statement.setInt(1, settingId);
	statement.setString(2, qualifier.getParameterName().getParamName());
	statement.setDouble(3, qualifier.getMin());
	statement.setDouble(4, qualifier.getMax());
    }

    private void setBaitSetting(int baitId, BaitSetting baitSetting, PreparedStatement statement) throws SQLException {
	statement.setInt(1, baitId);
	statement.setString(2, baitSetting.getSettingName());
	statement.setString(3, baitSetting.getSettingType());
	statement.setString(4, baitSetting.getDescription());
    }

}
