package com.jean.dao;

import java.sql.Date;
import java.util.List;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.entity.Bait;
import com.jean.entity.PondEnvirmoment;

public interface BaitDao {

    List<Bait> getBaits(Integer baitId, String baitType, String baitName, Integer fishId, Date date) throws DaoDfmException;

    List<Bait> getBaitsByPondParams(String baitType, String baitName, Integer fishId, PondEnvirmoment pondEnv, boolean isPeeperConnected) throws DaoDfmException;
    
    List<Bait> getOptimalBaits(Integer fishId, String baitType, String baitName, PondEnvirmoment pondEnv) throws DaoDfmException;

    Integer saveBait(Bait bait) throws DaoDfmException;

    Integer deleteBait(List<Integer> listId) throws DaoDfmException;

    void updateBait(Bait bait) throws DaoDfmException;

}
