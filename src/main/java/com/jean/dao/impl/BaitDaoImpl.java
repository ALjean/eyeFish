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

	String sql = "SELECT b.id, b.name, b.bait_type, b.description, bf.is_priority " + "FROM baits AS b INNER JOIN bindings_baits_to_fishes AS bf ON bf.bait_id = b.id INNER JOIN baits_seasons_properties AS bsp ON bsp.bait_id = b.id WHERE bf.fish_id = ? AND ? BETWEEN bsp.start_period AND bsp.end_period ";

	List<Bait> baits = new ArrayList<Bait>();
	
	log.info("Starting method getBaitsForFishByDate(), with parameter values: [ fishId: "+ fishId + ", date: " + date + " ]" );

	try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

	    preparedStatement.setInt(1, fishId);
	    preparedStatement.setDate(2, date);

	    ResultSet rs = preparedStatement.executeQuery();

	    while (rs.next()) {
		baits.add(getBaitFromRs(rs));
	    }
	    
	    log.info(baits.size() > 0 ? "Size list of baits is " + baits.size() : "list of baits is empty");

	} catch (SQLException e) {
	    throw new CustomDfmException("Some problem with fetching list of baits");
	}

	return baits;
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
}
