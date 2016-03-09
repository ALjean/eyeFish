package com.jean.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import com.jean.enums.BaitType;
import org.junit.Before;
import org.junit.Test;

import com.jean.BaseTest;
import com.jean.CustomDfmException;
import com.jean.analyzers.weather.ConstantsAnalyzer.KEY_MESSAGE;
import com.jean.entity.Bait;

public class BaitDaoTest extends BaseTest {

    private int fishId;
    private String key;
    private Date date;
    List<Bait> baits;


    @Before
    public void init() {
	fishId = 7;
	key = KEY_MESSAGE.STYRO_POP_UP.toString();
	date = Date.valueOf("2016-06-22");
    }

    @Test
    public void getBaitsForFishByDateTest() throws CustomDfmException {
	baits = baitDao.getBaitsForFishByDate(date, fishId);
	assertTrue(!baits.isEmpty());
    }


    
    @Test
    public void getMessageByKeyTest() throws CustomDfmException{
	assertTrue(baitDao.getMessage(key).length() > 0);
    }

    @Test
    public void saveTest() throws CustomDfmException{
        Bait bait = new Bait();
        bait.setName("Test");
        bait.setDescription("Adsdssdsd");
        bait.setType(BaitType.LIVEBAIT);
        baitDao.save(bait);
    }

}
