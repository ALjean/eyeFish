package com.jean.service;

import com.jean.dao.entity.fish.Fish;

import java.util.List;

public interface FishService {

	List<Fish> getAllFishes();

	Fish getById(Long id);

	List<Fish> getFishes(Integer fishId, String fishName, String fishType, String dayActivity, String livingArea);

	Fish save(Fish fish);

	Fish update(Fish fish);

	void delete(Long id);

}
