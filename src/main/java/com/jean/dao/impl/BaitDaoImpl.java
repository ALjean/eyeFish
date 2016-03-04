package com.jean.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.jean.CustomDfmException;
import com.jean.dao.BaitDao;
import com.jean.entity.Bait;
import com.jean.entity.BaitProperties;

@Component
public class BaitDaoImpl extends BaseDaoImpl implements BaitDao {

    private static Logger log = LoggerFactory.getLogger(BaitDaoImpl.class);

    @Override
    public List<Bait> getBaitsForFishByDate(Date date, int fishId) throws CustomDfmException {

	String sql = "SELECT b.id, b.name, b.bait_type, b.description, bf.is_priority "
		+ "FROM baits AS b INNER JOIN bindings_baits_to_fishes AS bf ON bf.bait_id = b.id "
		+ "INNER JOIN binding_baits_to_seasons AS bs ON bs.bait_id = b.id WHERE bf.fish_id = ? " + "AND "
		+ "? BETWEEN bs.start_period AND bs.end_period ";

	List<Bait> baits = new ArrayList<Bait>();

	log.info("Starting method getBaitsForFishByDate(), with parameter values: [ fishId: " + fishId + ", date: " + date + " ]");

	try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

	    preparedStatement.setInt(1, fishId);
	    preparedStatement.setDate(2, date);

	    ResultSet rs = preparedStatement.executeQuery();

	    while (rs.next()) {
		baits.add(getBaitFromRs(rs));
	    }

	    log.info(baits.size() > 0 ? "Size list of baits is " + baits.size() : "list of baits is empty");

	} catch (SQLException e) {
	    throw new CustomDfmException("Some problem with fetching list of baits " + "Message: " + e.getMessage());
	}

	return baits;
    }

    @Override
    public List<BaitProperties> getBaitColors(double cloudLevel) throws CustomDfmException {

	String sql = "SELECT bc.color_name, bc.description  " + "FROM baits_colors AS bc " + "WHERE ? BETWEEN bc.cloud_min AND bc.cloud_max;";

	List<BaitProperties> baitsProperties = new ArrayList<BaitProperties>();

	log.info("Starting method getBaitColors(), with parameter values: [ cloudLevel: " + cloudLevel + " ]");

	try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

	    preparedStatement.setDouble(1, cloudLevel);

	    ResultSet rs = preparedStatement.executeQuery();

	    while (rs.next()) {
		baitsProperties.add(getBaitPropsFromRs(rs));
	    }

	    log.info(baitsProperties.size() > 0 ? "Size list of bait properties is " + baitsProperties.size() : "list of bait properties is empty");

	} catch (SQLException e) {
	    throw new CustomDfmException("Some problem with fetching list of baits. " + "Message: " + e.getMessage());
	}
	return baitsProperties;
    }

    @Override
    public List<BaitProperties> getBaitColors(String colorName) throws CustomDfmException {

	String sql = "SELECT bc.color_name, bc.description  " + "FROM baits_colors AS bc " + "WHERE color_name LIKE ?";

	List<BaitProperties> baitsProperties = new ArrayList<BaitProperties>();

	log.info("Starting method getBaitColors(), with parameter values: [ colorName: " + colorName + " ]");

	try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

	    preparedStatement.setString(1, colorName);

	    ResultSet rs = preparedStatement.executeQuery();

	    while (rs.next()) {
		baitsProperties.add(getBaitPropsFromRs(rs));
	    }

	    log.info(baitsProperties.size() > 0 ? "Size list of bait properties is " + baitsProperties.size() : "list of bait properties is empty");

	} catch (SQLException e) {
	    throw new CustomDfmException("Some problem with fetching list of baits. " + "Message: " + e.getMessage());
	}
	return baitsProperties;
    }

    private Bait getBaitFromRs(ResultSet rs) throws SQLException {
	Bait bait = new Bait();
	bait.setBaitProperties(new ArrayList<BaitProperties>());
	bait.setId(rs.getInt("id"));
	bait.setBaitType(rs.getString("bait_type"));
	bait.setName(rs.getString("name"));
	bait.setDescription(rs.getString("description"));
	return bait;
    }

    private BaitProperties getBaitPropsFromRs(ResultSet rs) throws SQLException {
	BaitProperties baitProp = new BaitProperties();
	baitProp.setName(rs.getString("color_name"));
	baitProp.setDescription(rs.getString("description"));
	return baitProp;
    }

}
