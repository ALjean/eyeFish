package com.jean.dao.impl;

import com.jean.DaoDfmException;
import com.jean.dao.BaitPropertiesDao;
import com.jean.entity.BaitProperties;
import com.jean.enums.BaitPropertieTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BaitPropertiesDaoImpl extends BaseDaoImpl implements BaitPropertiesDao {

    private static Logger log = LoggerFactory.getLogger(BaitPropertiesDaoImpl.class);

    @Override
    public List<BaitProperties> getBaitPropertiesByType(BaitPropertieTypes baitType) throws DaoDfmException {
	return null;
    }

    @Override
    public Map<String, String> getBaitColors(double cloudLevel, double algaLevel, double deepLevel) throws DaoDfmException {
	
	Map<String, String> colorsSet = new HashMap<String, String>();
	
	String sql = 
		
		"SELECT p_name.parameters_name, c.color_name FROM bait_colors_properties AS c_prop "
		+ "INNER JOIN "
		+ "parameters_names AS p_name ON c_prop.parameter_id = p_name.id "
		+ "INNER JOIN "
		+ "bait_colors AS c ON c_prop.color_id = c.id "
		+ "WHERE "
		+ "p_name.parameters_name = 'CLOUD_LEVEL' AND ? BETWEEN c_prop.min_value AND c_prop.max_value "
		+ "OR "
		+ "p_name.parameters_name = 'DEEP_LEVEL' AND ? BETWEEN c_prop.min_value AND c_prop.max_value "
		+ "OR "
		+ "p_name.parameters_name = 'ALGA_LEVEL' AND ? BETWEEN c_prop.min_value AND c_prop.max_value";
	
	log.info("Starting method getBaitColors(), with parameter values: "
		+ "[ cloudLevel: " + cloudLevel + " algaLevel: " + algaLevel + " deepLevel: " + deepLevel + " ]");
	
	try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
	    
	    preparedStatement.setDouble(1, cloudLevel);
	    preparedStatement.setDouble(2, deepLevel);
	    preparedStatement.setDouble(3, algaLevel);
	    
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	return colorsSet;
    }

    @Override
    public List<BaitProperties> getBaitColors(BaitProperties brightLevel) throws DaoDfmException {

	String sql = "SELECT bs.name, bs.description  " + "FROM baits_settings AS bs " + "WHERE bs.name LIKE ? AND bs.type = ?";

	List<BaitProperties> baitsProperties = new ArrayList<>();

	log.info("Starting method getBaitColors(), with parameter values: [ colorName: " + brightLevel + " ]");

	try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

	   // preparedStatement.setString(1, brightLevel.name());
	    preparedStatement.setString(2, BaitPropertieTypes.COLOR.name());

	    ResultSet rs = preparedStatement.executeQuery();

	    while (rs.next()) {
		baitsProperties.add(getBaitPropsFromRs(rs));
	    }

	    if (baitsProperties.isEmpty()) {
		throw new DaoDfmException("For some reason list of colors is empty");
	    }

	} catch (SQLException e) {
	    throw new DaoDfmException("Some problem with fetching list of baits. " + "Message: " + e.getMessage(), e);
	}

	log.info("End method getBaitColors(), list size is: " + baitsProperties.size());

	return baitsProperties;
    }

    @Override
    public List<BaitProperties> getBaitTastes(double temperature, String paramName) throws DaoDfmException {

	String sql = "SELECT bs.name, bs.description " + "FROM baits_settings AS bs " + "WHERE ? BETWEEN bs.temp_min AND bs.temp_max AND bs.type = ?";

	List<BaitProperties> baitsProperties = new ArrayList<>();

	log.info("Starting method getBaitTastes(), with parameter values: [ temperature: " + temperature + " ]");

	try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

	    preparedStatement.setDouble(1, temperature);
	    preparedStatement.setString(2, BaitPropertieTypes.TASTE.name());

	    ResultSet rs = preparedStatement.executeQuery();

	    while (rs.next()) {
		baitsProperties.add(getBaitPropsFromRs(rs));
	    }

	    if (baitsProperties.isEmpty()) {
		throw new DaoDfmException("For some reason list of tastes is empty");
	    }

	} catch (SQLException e) {
	    throw new DaoDfmException("Some problem with fetching list of tastes. " + "Message: " + e.getMessage(), e);
	}

	log.info("End method getBaitTastes(), list size is: " + baitsProperties.size());

	return baitsProperties;

    }

    private BaitProperties getBaitPropsFromRs(ResultSet rs) throws SQLException {
	BaitProperties baitProp = new BaitProperties();
	baitProp.setId(rs.getInt("id"));
	baitProp.setName(rs.getString("name"));
	baitProp.setDescription(rs.getString("description"));
	return baitProp;
    }

}
