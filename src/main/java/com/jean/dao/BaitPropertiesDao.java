package com.jean.dao;

import com.jean.CustomDfmException;
import com.jean.entity.BaitProperties;
import com.jean.enums.BaitSettings;
import com.jean.enums.BaitType;
import com.jean.enums.BrightLevel;

import java.util.List;

public interface BaitPropertiesDao {

    List<BaitProperties> getBaitPropertiesByType(BaitSettings baitType) throws CustomDfmException;

    List<BaitProperties> getBaitColors(double cloudLevel) throws CustomDfmException;

    List<BaitProperties> getBaitColors(BrightLevel brightLevel) throws CustomDfmException;

    List<BaitProperties> getBaitTastes(double temperature) throws CustomDfmException;
}
