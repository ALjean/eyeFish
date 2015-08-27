package com.jean.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;




import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.jean.BaseTest;
import com.jean.CustomDfmException;
import com.jean.entity.Fish;

public class FishAnalyzerTest extends BaseTest {
  
    Fish fish = null;
    Date date = null;
    
    @Before
    public void init() throws CustomDfmException, ParseException{
	 fish = fishDao.read(1);
	 DateFormat format  = new SimpleDateFormat("yyyy-MM-dd");
	 date = format.parse("2015-08-29");
    }
    
    @Test
    public void getHungryRatingTest() throws CustomDfmException{
	List<String> list = fishAnalyzer.getHungryRating(fish);
	System.out.println(list);
	System.out.println(fish);
    }
}
