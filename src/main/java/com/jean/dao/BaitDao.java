package com.jean.dao;

import java.sql.Date;
import java.util.List;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.entity.Bait;

public interface BaitDao {

    List<Bait> getBaitsForFishByDate(Date date, int fishId) throws DaoDfmException;


    String getMessage(String key) throws DaoDfmException;

    Integer save(Bait bait) throws DaoDfmException;

    void delete(int id) throws DaoDfmException;

    List<Bait> getBaitListToFish(int id) throws DaoDfmException;
}
