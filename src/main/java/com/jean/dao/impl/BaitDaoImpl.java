package com.jean.dao.impl;

import java.sql.Date;
import java.util.List;

import com.jean.dao.BaitDao;
import com.jean.entity.Bait;

public class BaitDaoImpl extends BaseDaoImpl implements BaitDao {

	@Override
	public List<Bait> getBaitsForFishByDate(Date date, int fishId) {
		
		String sql = 
				
				"SELECT b.id, b.name, b.bait_type, b.description, bf.is_priority "
				+ "FROM "
				+ "baits AS b INNER JOIN bindings_baits_to_fishes AS bf ON bf.bait_id = b.id "
				+ "INNER JOIN baits_seasons_properties AS bsp ON bsp.bait_id = b.id "
				+ "WHERE bf.fish_id =" + fishId 
				+ "AND "
				+ date + "BETWEEN bsp.start_period AND bsp.end_period ";
		
		return null;
	}

}
