package com.jean.dao;

import com.jean.CustomDfmException;
import com.jean.entity.Fish;

/**
 * Created by stas on 30.05.15.
 */
public interface FishDao {


    void save(Fish fish) throws CustomDfmException;

    Fish read(int id) throws CustomDfmException;

    Fish update(Fish fish);

    boolean delete(int id);

}
