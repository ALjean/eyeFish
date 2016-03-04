package com.jean.dao;

import java.sql.Date;
import java.util.List;

import com.jean.CustomDfmException;
import com.jean.entity.Bait;
import com.jean.entity.BaitProperties;

public interface BaitDao {

	public List<Bait> getBaitsForFishByDate(Date date, int fishId) throws CustomDfmException;
	
	public List<BaitProperties> getBaitColors(double cloudLevel) throws CustomDfmException;
	
	public List<BaitProperties> getBaitColors(String colorName) throws CustomDfmException;
	
	public List<BaitProperties> getBaitTastes(double temperature) throws CustomDfmException;
	
	public String getMessage(String key) throws CustomDfmException;
}
