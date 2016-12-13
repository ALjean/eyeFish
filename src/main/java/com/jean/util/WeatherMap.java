package com.jean.util;

import com.jean.entity.weather.HourWeather;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by jean on 10.12.16.
 */
public class WeatherMap {

    private TreeMap<LocalDate, List<HourWeather>> map;

    public WeatherMap(){
        map = new TreeMap<>();
    }

    public void put(String key, HourWeather value){
        LocalDateTime dateTime = Utils.parseTextDate(key);
        LocalDate dateKey = WeatherMap.initMapKey(dateTime);

        put(dateKey, value);

    }


    public void put(long key, HourWeather value){
        LocalDateTime dateTime = Utils.parseTextDate(key);
        LocalDate dateKey = WeatherMap.initMapKey(dateTime);
        put(dateKey, value);
    }

    public TreeMap<LocalDate, List<HourWeather>> getMap(){
        return map;
    }

    private void put(LocalDate dateKey, HourWeather value){
        if(map.containsKey(dateKey)){
            map.get(dateKey).add(value);
        }else{
            List<HourWeather> hourWeathers = new ArrayList<>();
            hourWeathers.add(value);
            map.put(dateKey, hourWeathers);
        }
    }



    private static LocalDate initMapKey(LocalDateTime date){
        return LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());
    }


    private static boolean compereDays(LocalDateTime a, LocalDateTime b){
        return a.getDayOfYear() == b.getDayOfYear() && a.getMonth().equals(a.getMonth());
    }
}
