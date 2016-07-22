package com.jean.dao;

import java.util.List;

import com.jean.DaoDfmException;
import com.jean.entity.Bait;
import com.jean.entity.PondEnvirmoment;

public interface BaitConstructorDao {

	public List<Bait> getOptimalBaits(Integer fishId, String baitType, String baitName, PondEnvirmoment pondEnv)
			throws DaoDfmException;
}
