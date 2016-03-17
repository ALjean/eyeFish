package com.jean.dao;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.entity.Fish;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by stas on 30.05.15.
 */
public interface FishDao {


    void save(Fish fish) throws DaoDfmException;

    Fish get(int id) throws DaoDfmException;

    Fish update(Fish fish);

    void delete(int id) throws DaoDfmException;

    List<Fish> getAllWeather() throws DaoDfmException;

    Fish getFishByTempForNibble(int temp, int fishId) throws DaoDfmException;

}
