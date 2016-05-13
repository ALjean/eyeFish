package com.jean.schedule;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.dao.WeatherDao;
import com.jean.entity.Weather;
import com.jean.servlet.model.owm.DayWeatherDataOWM;
import com.jean.servlet.model.owm.GeneralWeatherStateOWM;
import com.jean.service.WeatherService;
import com.jean.Constants;
import com.jean.util.ModelBuilder;
import com.jean.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by stas on 18.07.15.
 */
@Component
public class DataWeatherDataBaseWriter {


    @Autowired
    private WeatherDao weatherDao;

    @Autowired
    private WeatherService weatherService;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 10800000)
    public void weatherWriter() throws CustomDfmException {

        System.out.println("The time is now " + dateFormat.format(new Date())) ;
    }



    public void parseOwnWeather() throws CustomDfmException, DaoDfmException {
        /*TODO Gen weather*/
        List<Weather> weathers = new ArrayList<>();
        List<String> cites = initListCities();

//        cites.stream().forEach(city ->{
//            GeneralWeatherStateOWM weatherOwm = weatherService.getDayWeatherState(city);
//            weathers.addAll(ModelBuilder.buildWeathers(weatherOwm));
//        });



        weatherDao.save(weathers);




    }


    private List<String> initListCities() {
        List<String> list = new ArrayList<>();
        list.add("Kiev");
        list.add("Kharkiv");
        list.add("Lviv");
        list.add("Zpor");
        list.add("Kiev");
        return list;
    }
}