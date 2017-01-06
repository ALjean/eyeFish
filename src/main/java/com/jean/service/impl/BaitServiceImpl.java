package com.jean.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jean.DaoDfmException;
import com.jean.dao.BaitDao;
import com.jean.entity.bait.Bait;
import com.jean.service.BaitService;

@Service
public class BaitServiceImpl implements BaitService {

//	@Autowired
//	private BaitDao baitDao;

	@Override
	public List<Bait> getBaits(Integer baitId, String baitType, String baitName, Long fishId, String date)
			throws DaoDfmException, IllegalArgumentException {

		Date sqlDate = null;
		
		if (!StringUtils.isEmpty(date)) {
			sqlDate = java.sql.Date.valueOf(date);
		}

//		return baitDao.getBaits(baitId, baitType, baitName, fishId, sqlDate);
		return null;
	}

	@Override
	public Integer saveBait(Bait bait) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ubdateBait() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBait(List<Integer> ids) {
		// TODO Auto-generated method stub

	}

}
