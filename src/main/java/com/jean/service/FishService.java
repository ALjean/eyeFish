package com.jean.service;

import com.jean.CustomDfmException;
import com.jean.entity.AbstractFish;

import java.sql.SQLException;
import java.util.List;

public interface FishService {

    AbstractFish get(int id) throws CustomDfmException;
    boolean create(AbstractFish fish) throws SQLException, CustomDfmException;
    void update(AbstractFish fish);
    boolean remove(int id);
    List<AbstractFish> getAll();


}
