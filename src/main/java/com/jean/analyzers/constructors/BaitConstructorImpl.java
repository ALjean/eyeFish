package com.jean.analyzers.constructors;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jean.DaoDfmException;
import com.jean.dao.BaitDao;
import com.jean.entity.bait.Bait;

@Component
public class BaitConstructorImpl implements BaitConstructor {
	
//	@Autowired
//	private BaitDao baitDao;

	@Override
	public List<Bait> getBaitsDependsOnWeathers(long fishId, Date date) throws DaoDfmException {
		
//		return baitDao.getBaits(null, null, null, fishId, date);
		return null;
	}

}
