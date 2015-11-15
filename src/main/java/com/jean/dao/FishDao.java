package com.jean.dao;

import com.jean.CustomDfmException;
import com.jean.entity.AbstractFish;

/**
 * Created by stas on 30.05.15.
 */
public interface FishDao {


    void save(AbstractFish fish) throws CustomDfmException;

    AbstractFish read(int id) throws CustomDfmException;

    AbstractFish update(AbstractFish fish);

    boolean delete(int id);

    int getFishByTempRange(int min, int max);

}
