package com.jean.service;

import com.jean.BaseTest;
import com.jean.CustomDfmException;
import com.jean.entity.Fish;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;

/**
 * Created by root on 27.09.15.
 */
public class FishServiceTest extends BaseTest {

    private Fish fish;
    private Date date;

    @Before
    public void init() throws ParseException {
        fish = new Fish();
        String string = "2015-08-13 00:00:00";

        date = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH).parse(string);
    }

    @Test
    public void getBehaviorFishByDayTest() throws CustomDfmException {
        fishService.getBehaviorFishByDay(fish, date);
        System.out.println("-------------");
    }
}
