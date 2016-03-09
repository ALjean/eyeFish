package com.jean.dao;

import java.sql.Date;
import java.util.List;

import com.jean.CustomDfmException;
import com.jean.entity.Bait;
import com.jean.entity.BaitProperties;

public interface BaitDao {

    List<Bait> getBaitsForFishByDate(Date date, int fishId) throws CustomDfmException;


    String getMessage(String key) throws CustomDfmException;

    Integer save(Bait bait) throws CustomDfmException;

    void delete(int id) throws CustomDfmException;

    List<Bait> getBaitListToFish(int id) throws CustomDfmException;
}
