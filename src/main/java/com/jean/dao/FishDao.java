package com.jean.dao;

import com.jean.DaoDfmException;
import com.jean.entity.Fish;

import java.util.List;

/**
 * Created by stas on 30.05.15.
 */
public interface FishDao {

    Integer saveFish(Fish fish) throws DaoDfmException;

    List<Fish> getFishes(Integer fishId, String fishName, String fishType, String dayActivity, String livingArea) throws DaoDfmException;

    void updateFish(Fish fish) throws DaoDfmException;

    Integer deleteFish(List<Integer> listId) throws DaoDfmException;

}
