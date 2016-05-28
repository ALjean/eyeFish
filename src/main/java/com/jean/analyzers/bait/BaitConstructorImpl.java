package com.jean.analyzers.bait;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jean.DaoDfmException;
import com.jean.dao.BaitDao;
import com.jean.entity.Bait;
import com.jean.entity.Fish;
import com.jean.entity.HourWeather;
import com.jean.entity.PondEnvirmoment;
import com.jean.util.Utils;

@Component
public class BaitConstructorImpl implements BaitConstructor{

	@Autowired
	BaitDao baitDao;
	
	@Override
	public List<Bait> getBaits(HourWeather hourWeather, Fish fish) throws DaoDfmException {
		PondEnvirmoment envirmoment = new PondEnvirmoment(
				hourWeather.getClouds(), 
				hourWeather.getRainVolume(), 
				hourWeather.getGeneralTemp(), 
				0.0, 
				hourWeather.getPressure(), 
				0.0, 
				0.0, 
				hourWeather.getWindSpeed());
		
		return baitDao.getBaitsByPondParams(null, null, new java.sql.Date(Utils.getJavaUtilDate(hourWeather.getDateText()).getTime()), fish.getId(), envirmoment);
	
	}

}
