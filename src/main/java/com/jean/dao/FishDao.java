package com.jean.dao;

import com.jean.CustomDfmException;
import com.jean.entity.Fish;

/**
 * Created by stas on 30.05.15.
 */
public interface FishDao {


    void create(Fish fish) throws CustomDfmException;

    Fish read(int id);

    Fish update(Fish fish);

    boolean delete(int id);

}
