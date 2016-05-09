package com.jean.service.impl;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.dao.FishDao;
import com.jean.entity.Fish;
import com.jean.service.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FishServiceImpl implements FishService {

    @Autowired
    private FishDao fishDao;


//    @Override
//    public Fish get(int id) throws CustomDfmException, DaoDfmException {
//        return fishDao.get(id);
//    }

    @Override
    public boolean create(Fish fish) throws CustomDfmException, DaoDfmException {
        fishDao.saveFish(fish);
        return false;
    }

    @Override
    public void update(Fish fish) throws DaoDfmException {
            fishDao.updateFish(fish);
    }

    @Override
    public void remove(List<Integer> ids) throws CustomDfmException, DaoDfmException {
        fishDao.deleteFish(ids);
    }

    @Override
    public List<Fish> getAll() {
        return null;
    }
}
