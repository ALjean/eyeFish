package com.jean.service.impl;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.dao.FishDao;
import com.jean.entity.Fish;
import com.jean.service.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FishServiceImpl implements FishService {

    @Autowired
    private FishDao fishDao;

	@Override
	public List<Fish> getFishes(Integer fishId, String fishName, String fishType, String dayActivity, String livingArea)
			throws DaoDfmException {
		
		return fishDao.getFishes(fishId, fishName, fishType, dayActivity, livingArea);
	}

	@Override
	public Integer save(Fish fish) throws CustomDfmException, DaoDfmException {
		
		if(fish == null){
			throw new CustomDfmException("Fish must be not null");
		}
		
		int result = fishDao.saveFish(fish);
		
		if(result == 0){
			throw new DaoDfmException("Fish didn't save.");
		}else{
			return result;
		}
		
	}

	@Override
	public void update(Fish fish) throws DaoDfmException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(List<Integer> ids) throws CustomDfmException, DaoDfmException {
		// TODO Auto-generated method stub
		
	}


}
