package com.jean.service;
import static org.junit.Assert.*;
import com.jean.BaseTest;
import com.jean.model.owm.DayWeatherDataOWM;
import com.jean.model.owm.GeneralWeatherStateOWM;
import com.jean.model.owm.HoursWeatherDataOWM;

import org.junit.Ignore;
import org.junit.Test;


public class WeatherServiceTest extends BaseTest {
    
    @Test
    @Ignore
    public void testGetHoursWeatherStateForCheckListGenericType(){
        
	GeneralWeatherStateOWM<HoursWeatherDataOWM> hoursWeatherStateOWM = weatherService.getHoursWeatherState();
        assertTrue(hoursWeatherStateOWM.getList().get(0).getClass().equals(HoursWeatherDataOWM.class));
    }

    @Test
    @Ignore
    public void testGetDayWeatherStateForListCheckListGenericType(){
       
	GeneralWeatherStateOWM<DayWeatherDataOWM> dayWeatherStateOWM = weatherService.getDayWeatherState();
	assertTrue(dayWeatherStateOWM.getList().get(0).getClass().equals(DayWeatherDataOWM.class));
        
    }


}
