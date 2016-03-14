package com.jean.service;

import com.jean.CustomDfmException;
import com.jean.entity.Fish;

import java.sql.SQLException;
import java.util.List;

public interface FishService {

    Fish get(int id) throws CustomDfmException;
    boolean create(Fish fish) throws SQLException, CustomDfmException;
    void update(Fish fish);
    void remove(int id) throws SQLException, CustomDfmException;
    List<Fish> getAll();


}
