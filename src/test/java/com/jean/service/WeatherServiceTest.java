package com.jean.service;
import static org.junit.Assert.*;
import com.jean.BaseTest;
import com.jean.model.owm.DayWeatherDataOWM;
import com.jean.model.owm.GeneralWeatherStateOWM;
import com.jean.model.owm.HoursWeatherDataOWM;

import org.junit.Test;

/**
 * Created by root on 01.08.15.
 */
public class WeatherServiceTest extends BaseTest {


    
    @Test
    public void testGetHoursWeatherStateForCheckListGenericType(){
        
	GeneralWeatherStateOWM<HoursWeatherDataOWM> hoursWeatherStateOWM = weatherService.getHoursWeatherState();
        assertTrue(hoursWeatherStateOWM.getList().get(0).getClass().equals(HoursWeatherDataOWM.class));
    }

    @Test
    public void testGetDayWeatherStateForListCheckListGenericType(){
       
	GeneralWeatherStateOWM<DayWeatherDataOWM> dayWeatherStateOWM = weatherService.getDayWeatherState();
	assertTrue(dayWeatherStateOWM.getList().get(0).getClass().equals(DayWeatherDataOWM.class));
        
    }


}
