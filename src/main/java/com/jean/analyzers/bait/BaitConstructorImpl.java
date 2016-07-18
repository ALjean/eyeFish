package com.jean.analyzers.bait;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jean.DaoDfmException;
import com.jean.dao.BaitDao;
import com.jean.entity.Bait;
import com.jean.entity.Fish;
import com.jean.entity.HourWeather;
import com.jean.entity.PeeperDTO;
import com.jean.entity.PondEnvirmoment;
import com.jean.util.Utils;

@Component
public class BaitConstructorImpl implements BaitConstructor {

	@Autowired
	BaitDao baitDao;

	@Override
	public List<Bait> getBaits(int fishId, String baitType, HourWeather hourWeather, PeeperDTO peeperDTO)
			throws DaoDfmException {

		PondEnvirmoment pondEnv = new PondEnvirmoment();

		if (peeperDTO != null) {
			pondEnv.setAlgalevel(peeperDTO.getAlgaLevel());
			pondEnv.setDeepLevel(peeperDTO.getDeepLevel());
			pondEnv.setTemp(peeperDTO.getWaterTemperature());
		} else {
			pondEnv.setTemp(hourWeather.getGeneralTemp());
		}
		pondEnv.setDate(hourWeather.getDate());
		pondEnv.setPressure(hourWeather.getPressure());
		pondEnv.setCloudLevel(hourWeather.getClouds());
		pondEnv.setRainLevel(hourWeather.getRainVolume());
		pondEnv.setWindSpeed(hourWeather.getWindSpeed());

		return baitDao.getBaitsByPondParams(baitType, null, fishId, pondEnv);
	}

}
