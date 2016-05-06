package com.jean.service;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.entity.Fish;

import java.sql.SQLException;
import java.util.List;

public interface FishService {

//    Fish get(int id) throws CustomDfmException, DaoDfmException;
    boolean create(Fish fish) throws CustomDfmException, DaoDfmException;
    void update(Fish fish);
    void remove(int id) throws CustomDfmException, DaoDfmException;
    List<Fish> getAll();


}
