package com.jean.dao;

import com.jean.CustomDfmException;
import com.jean.entity.FishSetting;

/**
 * Created by jean on 12.03.16.
 */
public interface FishParametersDao {

    void save(FishSetting fishParameter) throws CustomDfmException;
}
