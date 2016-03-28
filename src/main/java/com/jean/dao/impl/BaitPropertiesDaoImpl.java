package com.jean.dao.impl;

import com.jean.DaoDfmException;
import com.jean.dao.BaitPropertiesDao;
import com.jean.entity.Bait;
import com.jean.entity.BaitPropertie;
import com.jean.entity.BaitPropertieType;
import com.jean.entity.ParameterName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BaitPropertiesDaoImpl extends BaseDaoImpl implements BaitPropertiesDao {

    private static Logger log = LoggerFactory.getLogger(BaitPropertiesDaoImpl.class);

    @Override
    public Integer saveBaitPropertie(BaitPropertie baitPropertie) throws DaoDfmException {

	String sql =

	"INSERT INTO bait_properties AS bp " + "(bp.prop_name, bp.description, bp.prop_type_id, bp.param_name_id, bp.min_range, bp.max_range) "
		+ "VALUES (?, ?, ?, ?, ?, ?)";

	int primaryKey;

	try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

	    setBaitpropertieStatement(preparedStatement, baitPropertie);
	    preparedStatement.executeLargeUpdate();

	    primaryKey = getGeneratedKey(preparedStatement);

	} catch (SQLException e) {
	    throw new DaoDfmException("Some problem with save bait. " + "Message: " + e.getMessage(), e);
	}

	return primaryKey;
    }

    private void setBaitpropertieStatement(PreparedStatement statement, BaitPropertie baitPropertie) throws SQLException {

	statement.setString(1, baitPropertie.getBaitPropName());
	statement.setString(2, baitPropertie.getDescription());
	statement.setInt(3, baitPropertie.getBaitPropTypes().getId());
	statement.setInt(4, baitPropertie.getParamNames().getId());
	statement.setDouble(5, baitPropertie.getMinRange());
	statement.setDouble(6, baitPropertie.getMaxRange());
    }

    private BaitPropertie getBaitPropertieFromRs(ResultSet rs) throws SQLException {

	BaitPropertie baitPropertie = new BaitPropertie();

	baitPropertie.setId(rs.getInt("prop_name"));
	baitPropertie.setBaitPropName(rs.getString("bp.prop_name"));
	baitPropertie.setBaitPropTypes(new BaitPropertieType(rs.getInt("prop_type_id"), rs.getString("prop_type")));
	baitPropertie.setParamNames(new ParameterName(rs.getInt("param_name_id"), rs.getString("parameters_name"), rs.getInt("priority_level")));
	baitPropertie.setMinRange(rs.getDouble("min_range"));
	baitPropertie.setMaxRange(rs.getDouble("max_range"));

	return baitPropertie;
    }

    @Override
    public List<BaitPropertie> getBaitPropertiesForBait(Bait bait) {
	
	StringBuffer sql = new StringBuffer(
		
		"SELECT * FROM bait_properties AS bp "
		+ "INNER JOIN parameters_names AS pn ON bp.param_name_id = pn.param_name_id "
		+ "INNER JOIN"
		+ "bait_propertie_types AS bpt ON bp.prop_type_id = bpt.prop_type_id"
		+ "WHERE 1=1" );
	
	for(ParameterName paramName : bait.getParameterNames()){
	    sql.append(" ");
	}
	return null;
    }

}
