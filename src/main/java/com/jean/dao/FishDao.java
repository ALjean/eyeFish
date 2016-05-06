package com.jean.dao;

import com.jean.DaoDfmException;
import com.jean.entity.Fish;
import java.util.List;

/**
 * Created by stas on 30.05.15.
 */
public interface FishDao {


    Integer saveFish(Fish fish) throws DaoDfmException;

    List<Fish> getFishes(int id) throws DaoDfmException;

    void update(Fish fish);

    void delete(int id) throws DaoDfmException;

    List<Fish> getAllWeather() throws DaoDfmException;

    Fish getFishByTempForNibble(int temp, int fishId) throws DaoDfmException;

}
