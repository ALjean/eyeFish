package com.jean.service;

import com.jean.BaseTest;
import com.jean.Constants;
import com.jean.CustomDfmException;
import com.jean.entity.AbstractFish;
import com.jean.entity.FactoryProduser;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;

/**
 * Created by root on 27.09.15.
 */
public class FishAnalyzerServiceTest extends BaseTest {

    private AbstractFish fish;
    private Date date;

    @Before
    public void init() throws ParseException, CustomDfmException {
        fish = new FactoryProduser().createFish(Constants.FISH_TYPE_CALM);
        String string = "2015-08-13 00:00:00";

        date = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH).parse(string);
    }

    @Test
    @Ignore
    public void getBehaviorFishByDayTest() throws CustomDfmException {
        fishAnalyzerService.getBehaviorFishByDay(fish, date);
        System.out.println("-------------");
    }
}
