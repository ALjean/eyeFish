package com.jean.dao;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.entity.NibblePeriod;

import java.util.List;

/**
 * Created by jean on 12.03.16.
 */
public interface FishNibbleDao {

//    void save(FishNibble fishNibble) throws CustomDfmException;
//    void save(FishNibble fishNibble, boolean isCommitOff) throws CustomDfmException;
    List<NibblePeriod> getAllFishNibbleByFishId(int fishId) throws DaoDfmException;
}
