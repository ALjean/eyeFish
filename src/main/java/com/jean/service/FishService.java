package com.jean.service;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.entity.fish.Fish;

import java.sql.SQLException;
import java.util.List;

public interface FishService {

	public List<Fish> getFishes(Integer fishId, String fishName, String fishType, String dayActivity, String livingArea)
			throws DaoDfmException;

	public Integer save(Fish fish) throws CustomDfmException, DaoDfmException;

	public void update(Fish fish) throws DaoDfmException;

	public void delete(List<Integer> ids) throws CustomDfmException, DaoDfmException;

}
