package com.jean.dao;

import java.sql.Date;
import java.util.List;

import com.jean.entity.Bait;

public interface BaitDao {

	public List<Bait> getBaitsForFishByDate(Date date, int fishId);
}
