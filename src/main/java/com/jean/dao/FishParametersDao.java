package com.jean.dao;

import com.jean.CustomDfmException;
import com.jean.entity.FishParameter;

/**
 * Created by jean on 12.03.16.
 */
public interface FishParametersDao {

    void save(FishParameter fishParameter) throws CustomDfmException;
}
