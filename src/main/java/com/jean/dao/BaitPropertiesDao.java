package com.jean.dao;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.entity.BaitProperties;
import com.jean.enums.BaitSettings;
import com.jean.enums.BrightLevel;

import java.util.List;

public interface BaitPropertiesDao {

    List<BaitProperties> getBaitPropertiesByType(BaitSettings baitType) throws DaoDfmException;

    List<BaitProperties> getBaitColors(double cloudLevel) throws DaoDfmException;

    List<BaitProperties> getBaitColors(BrightLevel brightLevel) throws DaoDfmException;

    List<BaitProperties> getBaitTastes(double temperature) throws DaoDfmException;
}
