package com.jean.dao.impl;

import com.jean.DaoDfmException;
import com.jean.dao.BaitPropertiesDao;
import com.jean.entity.BaitPropertie;
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
    public Map<String, String> getBaitColors(double cloudLevel, double algaLevel, double deepLevel) throws DaoDfmException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<BaitPropertie> getBaitColors(BaitPropertie brightLevel) throws DaoDfmException {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<BaitPropertie> getBaitTastes(double temperature, String paramName) throws DaoDfmException {
	// TODO Auto-generated method stub
	return null;
    }

}
