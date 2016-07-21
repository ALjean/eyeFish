package com.jean.service;

import java.util.List;

import com.jean.DaoDfmException;
import com.jean.entity.Bait;
import com.jean.entity.HourWeather;
import com.jean.entity.PeeperDTO;

public interface BaitConstructorService {

	public List<Bait> getOptimalBaits(int fishId, String baitType, String baitName, HourWeather hourWeather, boolean isPeeperConected) throws DaoDfmException;
}
