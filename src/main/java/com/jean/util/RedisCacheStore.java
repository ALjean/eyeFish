package com.jean.util;

import com.jean.entity.GeneralDayWeather;
import com.jean.entity.GeneralHourWeather;
import com.jean.servlet.model.Coordinates;
import com.jean.servlet.model.RedisStoreEntry;
import com.jean.servlet.model.RedisStoreKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by jean on 16.05.16.
 */
@Component
public class RedisCacheStore<T> {

    private enum KEYS {
        DayWeather, HourWeather
    }

    @Autowired
    private RedisTemplate<String, String> template;


    public void setCacheValue(String key, int timeLife, RedisStoreEntry storeEntry) {
        template.expire(key, timeLife, TimeUnit.MINUTES);
        template.opsForHash().put(key, storeEntry.generateRedisHashKey(), storeEntry);
    }

    public T findCacheValue(String key, Object storeKey) {

        return (T)template.opsForHash().get(key, genKey(storeKey));
    }

//    public void setHourWeather(GeneralHourWeather generalHourWeather) {
//        template.expire(KEYS.HourWeather.name(), 10, TimeUnit.MINUTES);
//        template.opsForHash().put(KEYS.HourWeather.name(), "hashkey", generalHourWeather);
//    }
//
//    public GeneralHourWeather findHourWeather(Coordinates coordinates) {
//        template.expire(KEYS.HourWeather.name(), 10, TimeUnit.MINUTES);
////        template.keys()
//        return (GeneralHourWeather) template.opsForHash().get(KEYS.HourWeather.name(), "hashkey");
//    }

    private boolean findKey(double lon, double lat) {
        Set<String> keys = template.keys("*");
        keys.forEach(key -> {

        });
        double hashLon = 0;
        double hashLat = 0;
        int R = 5;

        return Math.pow((lon-hashLon), 2) + Math.pow((lat-hashLat), 2) <= Math.pow(R, 2);

    }

    private String genKey(Coordinates coordinates){

    }

    private Object genKey(Object key){
        return key;
    }


}
