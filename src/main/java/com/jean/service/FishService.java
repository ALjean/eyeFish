package com.jean.service;

import com.jean.CustomDfmException;
import com.jean.entity.AbstractFish;

import java.sql.SQLException;
import java.util.List;

public interface FishService {

    AbstractFish get(int id) throws CustomDfmException;
    boolean create(AbstractFish fish) throws SQLException, CustomDfmException;
    void update(AbstractFish fish);
    void remove(int id) throws SQLException, CustomDfmException;
    List<AbstractFish> getAll();


}
