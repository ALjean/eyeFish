package com.jean.dao;

import com.jean.CustomDfmException;
import com.jean.entity.Fish;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by stas on 30.05.15.
 */
public interface FishDao {


    void save(Fish fish) throws CustomDfmException, SQLException;

    Fish read(int id) throws CustomDfmException;

    Fish update(Fish fish);

    void delete(int id) throws CustomDfmException, SQLException;

    List<Fish> getAllWeather() throws CustomDfmException;

    Fish getFishByTempForNibble(int temp, int fishId) throws CustomDfmException;

}
