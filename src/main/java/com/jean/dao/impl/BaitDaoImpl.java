package com.jean.dao.impl;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.enums.BaitTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jean.dao.BaitDao;
import com.jean.entity.Bait;
import com.jean.entity.Message;

import org.springframework.stereotype.Repository;

@Repository
public class BaitDaoImpl extends BaseDaoImpl implements BaitDao {

    private static Logger log = LoggerFactory.getLogger(BaitDaoImpl.class);

    @Override
    public List<Bait> getBaits(int fishId, Date date) throws DaoDfmException {

	String sql = "SELECT b.bait_id, b.bait_name, bt.bait_type_name, b.description " + "FROM "
		+ "baits AS b INNER JOIN bait_types AS bt ON bt.bait_type_id = b.bait_type_id " + "INNER JOIN "
		+ "baits_to_fishes AS btf ON btf.bait_id = b.bait_id " + "INNER JOIN " + "baits_to_seasons AS bts ON bts.bait_id = b.bait_id "
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

	String sqlSelectTypeId = "SELECT bait_type_id FROM bait_types WHERE bait_type_name LIKE ?";
	String sqlInsertBait = "INSERT INTO baits (bait_name, bait_type_id, description) VALUES (?, ?, ?)";

	Connection connection = getConnection();

	PreparedStatement statement = null;

	int typeId;
	int primaryKey;

	try {

	    statement = connection.prepareStatement(sqlSelectTypeId);
	    statement.setString(1, bait.getType().name());
	    ResultSet rs = statement.executeQuery();

	    rs.next();
	    typeId = rs.getInt("bait_type_id");

	    statement = connection.prepareStatement(sqlInsertBait, Statement.RETURN_GENERATED_KEYS);
	    statement.setString(1, bait.getName());
	    statement.setInt(2, typeId);
	    statement.setString(3, bait.getDescription());
	    statement.executeUpdate();

	    ResultSet keySet = statement.getGeneratedKeys();
	    keySet.next();
	    primaryKey = keySet.getInt(1);

	    connection.commit();

	} catch (SQLException e) {
	    throw new DaoDfmException("Some problem with save bait. " + "Message: " + e.getMessage(), e);
	}

	return primaryKey;
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
	    result = statement.executeUpdate();

	    statement = connection.prepareStatement(sqlDeleteSeason);
	    statement.setInt(1, baitId);
	    result = statement.executeUpdate();

	    statement = connection.prepareStatement(sqlDeleteBait);
	    statement.setInt(1, baitId);
	    result = statement.executeUpdate();
	    
	    connection.commit();

	} catch (SQLException e) {
	    throw new CustomDfmException("SQLEror: " + baitId + e.getMessage());
	}

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
    public Bait getBait(int baitId) throws DaoDfmException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<Bait> getBaits(int fishId) throws DaoDfmException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Integer updateBait(Bait bait) throws DaoDfmException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Message getMessage(String key) throws DaoDfmException {

	String sql = "SELECT mess_text FROM messages WHERE key LIKE ?";

	Message message = new Message();

	try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

	    preparedStatement.setString(1, key);

	    ResultSet rs = preparedStatement.executeQuery();

	    while (rs.next()) {
		// result = rs.getString("mess_text");
	    }
	} catch (SQLException e) {
	    throw new DaoDfmException("Some problem with fetching message text. " + "Message: " + e.getMessage(), e);
	}
	return message;
    }

    @Override
    public Message getMessage(int messageId) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<String> getMessages() throws DaoDfmException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Integer saveMessage(Message message) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Integer updateMessage(Message mesage) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void deleteMessage(int messageId) {
	// TODO Auto-generated method stub

    }

    private Bait getBaitFromRs(ResultSet rs) throws SQLException {
	Bait bait = new Bait();
	bait.setId(rs.getInt("bait_id"));
	bait.setType(BaitTypes.valueOf(rs.getString("bait_type_name")));
	bait.setName(rs.getString("bait_name"));
	bait.setDescription(rs.getString("description"));
	return bait;
    }

}
