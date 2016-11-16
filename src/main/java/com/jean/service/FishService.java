package com.jean.service;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.entity.fish.Fish;

import java.sql.SQLException;
import java.util.List;

public interface FishService {

	List<Fish> getFishes(Integer fishId, String fishName, String fishType, String dayActivity, String livingArea)
			throws DaoDfmException;

	Integer save(Fish fish) throws CustomDfmException, DaoDfmException;

	void update(Fish fish) throws DaoDfmException;

	void delete(List<Integer> ids) throws CustomDfmException, DaoDfmException;

}
