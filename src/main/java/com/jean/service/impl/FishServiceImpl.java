package com.jean.service.impl;

//import com.jean.dao.FishDao;
import com.jean.dao.entity.fish.Fish;
import com.jean.dao.repository.FishRepository;
import com.jean.service.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FishServiceImpl implements FishService {

	@Autowired
	private FishRepository fishRepository;


	@Override
	@Transactional
	public List<Fish> getAllFishes(){
		return fishRepository.findAll().stream();
	}

	public Fish getById(Long id){
		return fishRepository.findOne(id);
	}

	@Override
	public List<Fish> getFishes(Integer fishId, String fishName, String fishType, String dayActivity, String livingArea) {
		
//		return fishDao.getFishes(fishId, fishName, fishType, dayActivity, livingArea);
		return null;
	}

	@Override
	public Fish save(Fish fish) {

		return fishRepository.save(fish);
//		int result = fishDao.saveFish(fish);
		
/*		if(result == 0){
			throw new DaoDfmException("Fish didn't save.");
		}else{
			return result;
		}*/

		
	}

	@Override
	public Fish update(Fish fish){
//		Fish p = fishRepository.findOne(fish.getId());
		return fishRepository.save(fish);
		
	}

	@Override
	public void delete(Long id) {
		fishRepository.delete(id);
		// TODO Auto-generated method stub
		
	}


}
