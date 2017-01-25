package com.jean.service;

import java.util.List;

import com.jean.DaoDfmException;
import com.jean.dao.entity.bait.Bait;

public interface BaitService {

	List<Bait> getBaits(Integer baitId, String baitType, String baitName, Long fishId, String date) throws DaoDfmException;
	
	Integer saveBait(Bait bait);
	
	void ubdateBait();
	
	void deleteBait(List<Integer> ids);
}
