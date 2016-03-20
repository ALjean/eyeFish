package com.jean.dao;

import com.jean.DaoDfmException;
import com.jean.entity.BaitProperties;
import com.jean.enums.BaitSettings;
import com.jean.enums.BrightLevel;

import java.util.List;
import java.util.Map;

public interface BaitPropertiesDao {

    List<BaitProperties> getBaitPropertiesByType(BaitSettings baitType) throws DaoDfmException;

    Map<String, String> getBaitColors(double cloudLevel, double algaLevel, double deepLevel) throws DaoDfmException;

    List<BaitProperties> getBaitColors(BrightLevel brightLevel) throws DaoDfmException;

    List<BaitProperties> getBaitTastes(double temperature, String paramName) throws DaoDfmException;
}
