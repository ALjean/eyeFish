package com.jean.dao;

import com.jean.DaoDfmException;
import com.jean.entity.BaitPropertie;
import java.util.List;
import java.util.Map;

public interface BaitPropertiesDao {

    Map<String, String> getBaitColors(double cloudLevel, double algaLevel, double deepLevel) throws DaoDfmException;

    List<BaitPropertie> getBaitColors(BaitPropertie brightLevel) throws DaoDfmException;

    List<BaitPropertie> getBaitTastes(double temperature, String paramName) throws DaoDfmException;
}
