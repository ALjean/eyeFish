package com.jean.dao;

import com.jean.CustomDfmException;
import com.jean.entity.AbstractFish;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by stas on 30.05.15.
 */
public interface FishDao {


    void save(AbstractFish fish) throws CustomDfmException, SQLException;

    AbstractFish read(int id) throws CustomDfmException;

    AbstractFish update(AbstractFish fish);

    boolean delete(int id);

    List<AbstractFish> getAllWeather() throws CustomDfmException;

    AbstractFish getFishByTempForNibble(int temp, int fishId) throws CustomDfmException;

}
