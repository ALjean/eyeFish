package com.jean.dao;

import java.sql.Date;
import java.util.List;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.entity.Bait;
import com.jean.entity.PondEnvirmoment;

public interface BaitDao {

	List<Bait> getBaits(Integer baitId, String baitName, Integer fishId, Date date)
			throws DaoDfmException, CustomDfmException;

	List<Bait> getBaitsByPondParams(Integer baitId, String baitName, Date date, Integer fishId, PondEnvirmoment pondEnv)
			throws DaoDfmException, CustomDfmException;

	Integer saveBait(Bait bait) throws DaoDfmException, CustomDfmException;

	Integer deleteBait(List<Integer> listId) throws DaoDfmException, CustomDfmException;

	void updateBait(Bait bait) throws DaoDfmException, CustomDfmException;

}
