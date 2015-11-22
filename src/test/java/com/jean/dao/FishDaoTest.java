package com.jean.dao;

import com.jean.Constants;
import com.jean.CustomDfmException;
import com.jean.entity.AbstractFish;
import com.jean.entity.FactoryProduser;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.stereotype.Component;
import com.jean.BaseTest;

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
        id = 3;
        temp = 10;

    }

    @Test
    @Ignore
    public void createTest() throws CustomDfmException {
        fishDao.save(fish);
        System.out.println("Test 1");
    }

    @Test
    @Ignore
    public void readTest() throws CustomDfmException {
        AbstractFish t= fishDao.read(id);
//        assertEquals(t.getName(), "TestTaskName");
        System.out.println("Test 2");
    }

    @Test
    public void getFishByTempForNibbleTest() throws CustomDfmException {
        AbstractFish fish = fishDao.getFishByTempForNibble(temp, id);
        System.out.println("Test 3");
    }
}
