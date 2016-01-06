package com.jean.dao;

import com.jean.Constants;
import com.jean.CustomDfmException;
import com.jean.entity.AbstractFish;
import com.jean.entity.FactoryProduser;
import com.jean.entity.NibbleStateParam;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.stereotype.Component;
import com.jean.BaseTest;

import java.sql.SQLException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 30.05.15.
 */

@Component
public class FishDaoTest extends BaseTest {

    private AbstractFish fish;

    private int id;
    private int temp;

    @Before
    public void init() throws CustomDfmException {
        fish = FactoryProduser.createFish(Constants.FISH_TYPE_CALM);
        fish.setName("TestTaskName");
        fish.setDescription("Test Description JUNIT");

        List<NibbleStateParam> nibbleStateParams = new ArrayList<>();


        for(int i = 0; i < 10; i++){
            NibbleStateParam nibbleStateParam = new NibbleStateParam();
            nibbleStateParam.setMaxValue(20 + i);
            nibbleStateParam.setMinValue(15 - i);
            nibbleStateParam.setNibble(0.75f);
            nibbleStateParams.add(nibbleStateParam);
        }

        fish.setNibbleStateParams(nibbleStateParams);

        id = 3;
        temp = 10;

    }

    @Test
    @Ignore
    public void createFishTest() throws CustomDfmException, SQLException {
        fishDao.save(fish);
        System.out.println("Test 1");
    }

    @Test
    @Ignore
    public void readFishTest() throws CustomDfmException {
        AbstractFish t= fishDao.read(id);
//        assertEquals(t.getName(), "TestTaskName");
        System.out.println("Test 2");
    }

    @Test
    @Ignore
    public void deleteFishTest() throws SQLException, CustomDfmException {
        fishDao.delete(15);
        System.out.println("---------------");
    }

    @Test
    @Ignore
    public void getFishByTempForNibbleTest() throws CustomDfmException {
        AbstractFish fish = fishDao.getFishByTempForNibble(temp, id);
        System.out.println("Test 3");
    }
}
