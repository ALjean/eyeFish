package com.jean.service;

import java.sql.Date;
import java.util.List;

import com.jean.DaoDfmException;
import com.jean.entity.Bait;

public interface BaitService {

	public List<Bait> getBaits(Integer baitId, String baitType, String baitName, Integer fishId, String date) throws DaoDfmException;
	
	public Integer saveBait(Bait bait);
	
	public void ubdateBait();
	
	public void deleteBait(List<Integer> ids);
}
