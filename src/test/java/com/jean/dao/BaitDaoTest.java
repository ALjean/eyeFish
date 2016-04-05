package com.jean.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jean.DaoDfmException;

import org.junit.Before;
import org.junit.Test;

import com.jean.BaseTest;
import com.jean.CustomDfmException;
import com.jean.analyzers.weather.ConstantsAnalyzer.KEY_MESSAGE;
import com.jean.entity.Bait;
import com.jean.entity.BaitPropertie;
import com.jean.entity.BaitType;
import com.jean.entity.DateHolder;
import com.jean.enums.ParamNames;
import com.jean.util.BaitSetting;
import com.jean.util.ParameterName;
import com.jean.util.ParameterNamesHolder;
import com.jean.util.Qualifier;

public class BaitDaoTest extends BaseTest {

    private int fishId;
    private int generateKey;
    private String key;
    private Date date;
    private Bait bait;
    private List<BaitSetting> baitSettings;
    private List<Qualifier> qualifiers;
    private List<DateHolder> dates;
    private List<Integer> idFishes;
    private List<Bait> baits;

    @Before
    public void init() {
	fishId = 7;
	key = KEY_MESSAGE.STYRO_POP_UP.toString();
	date = Date.valueOf("2016-06-22");
	
	idFishes = new ArrayList<Integer>();
	idFishes.addAll(Arrays.asList(new Integer[] {7}));
	
	dates = new ArrayList<DateHolder>();
	dates.add(new DateHolder(Date.valueOf("2016-07-01"), Date.valueOf("2016-09-30")));
	dates.add(new DateHolder(Date.valueOf("2016-02-01"), Date.valueOf("2016-04-30")));
	
	qualifiers = new ArrayList<Qualifier>(); 
	qualifiers.add(new Qualifier(ParameterNamesHolder.getParamName(ParamNames.CLOUD_LEVEL.name()), 23, 50));
	qualifiers.add(new Qualifier(ParameterNamesHolder.getParamName(ParamNames.DEEP_LEVEL.name()), 1.2, 2));
	
	baitSettings = new ArrayList<BaitSetting>(); 
	baitSettings.add(new BaitSetting(0, "Color", "Natural", "Use natural colors for the best result", qualifiers));	
	
	bait = new Bait(0, "Slizzard", "For superlative fish? for example Yazzz!", baitSettings, idFishes, dates);
    }

    //@Test
    public void getBaitsForFishByDateTest() throws CustomDfmException, DaoDfmException {
	baits = baitDao.getBaitsToFishesByDate(fishId, date);
	assertTrue(!baits.isEmpty());
	System.out.println(baits);
    }

    //@Test(expected = DaoDfmException.class)
    public void getBaitsForFishByDateExceptionTest() throws DaoDfmException {
	baits = baitDao.getBaitsToFishesByDate(123, date);
    }

   // @Test
    public void getBaitByIdTest() throws DaoDfmException, CustomDfmException {
	Bait bait = baitDao.getBait(4);
	assertNotNull(bait);
	System.out.println(bait);
    }

   // @Test
    public void getBaitsBySeasonTest() throws DaoDfmException {
	baits = baitDao.getBaitsBySeason(date);
	assertTrue(!baits.isEmpty());
	System.out.println(baits);
    }

   // @Test
   /* public void getBaitsTest() throws DaoDfmException, CustomDfmException {
	baits = baitDao.getBaits(null, null, null, null, null);
	assertTrue(!baits.isEmpty());
	System.out.println(baits);
    }*/

    @Test
    public void saveBaitTest() throws DaoDfmException, CustomDfmException {
	generateKey = baitDao.saveBait(bait);
	assertTrue(generateKey > 0);
	System.out.println(generateKey);
    }

   // @Test(expected = CustomDfmException.class)
    public void deleteBaitExceptionTest() throws DaoDfmException, CustomDfmException {
	baitDao.deleteBait(123);
    }

   // @Test
    public void deleteBaitTest() throws DaoDfmException, CustomDfmException {
	baitDao.deleteBait(50);
    }
    
    //@Test
    public void updateBaitTest() throws DaoDfmException, CustomDfmException{
	
    }

}
