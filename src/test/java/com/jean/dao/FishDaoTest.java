package com.jean.dao;

import com.jean.CustomDfmException;
import com.jean.entity.Fish;
import static org.junit.Assert.*;
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

    private Fish fish;

    private int id;

    @Before
    public void init(){
        fish = new Fish();
        fish.setName("TestTaskName");
        fish.setDescription("Test Description JUNIT");
        fish.setTempMin(234.32f);
        fish.setTempMax(444.22f);
        fish.setPressureMin(500);
        fish.setPressureMax(550);
        id = 1;
    }

//    void create(Fish fish);
//    Fish read(int id);
//    Fish update(Fish fish);
//    boolean delete(int id);

    @Test
//    @Ignore
    public void createTest() throws CustomDfmException {
        fishDao.create(fish);
        System.out.println("Test 1");
    }

    @Test
    @Ignore
    public void readTest(){
        Fish t= fishDao.read(id);
        assertEquals(t.getName(), "TestTaskName");
        System.out.println("Test 2");
    }
}
