package com.jean.service.impl;

import com.jean.CustomDfmException;
import com.jean.dao.FishDao;
import com.jean.entity.Fish;
import com.jean.service.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class FishServiceImpl implements FishService {

    @Autowired
    private FishDao fishDao;


    @Override
    public Fish get(int id) throws CustomDfmException {
        return fishDao.read(id);
    }

    @Override
    public boolean create(Fish fish) throws SQLException, CustomDfmException {
        fishDao.save(fish);
        return false;
    }

    @Override
    public void update(Fish fish) {
            fishDao.update(fish);
    }

    @Override
    public void remove(int id) throws SQLException, CustomDfmException {
        fishDao.delete(id);
    }

    @Override
    public List<Fish> getAll() {
        return null;
    }
}
