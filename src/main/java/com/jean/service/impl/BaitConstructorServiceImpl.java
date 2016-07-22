package com.jean.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jean.DaoDfmException;
import com.jean.dao.BaitConstructorDao;
import com.jean.dao.BaitDao;
import com.jean.entity.Bait;
import com.jean.entity.HourWeather;
import com.jean.entity.PondEnvirmoment;
import com.jean.service.BaitConstructorService;

@Service
public class BaitConstructorServiceImpl implements BaitConstructorService {

	@Autowired
	private BaitConstructorDao baitDao;

	@Override
	public List<Bait> getOptimalBaits(int fishId, String baitType, String baitName, HourWeather hourWeather,
			boolean isPeeperConnected) throws DaoDfmException {

		PondEnvirmoment pondEnv = new PondEnvirmoment();

		pondEnv.setTemp(hourWeather.getGeneralTemp());
		pondEnv.setDate(java.sql.Date.valueOf(hourWeather.getDateText().substring(0, 10).trim()));
		pondEnv.setPressure(hourWeather.getPressure());
		pondEnv.setCloudLevel(hourWeather.getClouds());
		pondEnv.setRainLevel(hourWeather.getRainVolume());
		pondEnv.setWindSpeed(hourWeather.getWindSpeed());

		return baitDao.getOptimalBaits(fishId, baitType, baitName, pondEnv);
	}

}
