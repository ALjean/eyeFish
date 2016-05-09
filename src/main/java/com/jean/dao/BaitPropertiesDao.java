package com.jean.dao;

import com.jean.DaoDfmException;
import com.jean.entity.Bait;
import com.jean.entity.BaitPropertie;
import java.util.List;

public interface BaitPropertiesDao {

    Integer saveBaitPropertie(BaitPropertie baitPropertie) throws DaoDfmException;

    List<BaitPropertie> getBaitPropertiesForBait(Bait bait);

}
