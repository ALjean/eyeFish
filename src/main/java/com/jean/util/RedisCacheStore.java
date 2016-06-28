package com.jean.util;

import com.jean.CustomDfmException;
import com.jean.entity.GeneralDayWeather;
import com.jean.entity.GeneralHourWeather;
import com.jean.enums.RedisKeys;
import com.jean.servlet.model.Coordinates;
import com.jean.servlet.model.RedisStoreEntry;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;
import redis.clients.jedis.GeoRadiusResponse;
import redis.clients.jedis.GeoUnit;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;
import redis.clients.jedis.params.geo.GeoRadiusParam;

import java.util.*;


/**
 * Created by jean on 16.05.16.
 */
@Component
public class RedisCacheStore {

	private static Logger log = Logger.getLogger(RedisCacheStore.class);


	@Autowired
	private JedisPool jedisPool;


	public GeneralHourWeather findHourWeather(Coordinates coordinates) throws CustomDfmException {

		Jedis jedis = jedisPool.getResource();
		GeneralHourWeather generalHourWeather = null;

		try{

			List<GeoRadiusResponse> list = jedis
					.georadius(RedisKeys.HourWeather.name(),
							coordinates.getLongitude(),
							coordinates.getLatitude(), 500, GeoUnit.KM,
							GeoRadiusParam.geoRadiusParam().withDist());

			log.info("Found GeoRadiusResponse: " + list.size());

			if(list.size() > 0 ){
				list.stream().sorted((f1, f2) ->Double.compare(f2.getDistance(), f1.getDistance()));
				generalHourWeather = (GeneralHourWeather) SerializationUtils.deserialize(list.get(0).getMember());

			}

		} catch (JedisException e){
			log.error("Can't get HourWeather from Redis");
			throw new CustomDfmException("Can't get HourWeather from Redis", e);
		}

		return generalHourWeather;
	}


	public GeneralDayWeather findDayWeather(Coordinates coordinates) throws CustomDfmException {

		Jedis jedis = jedisPool.getResource();
		GeneralDayWeather generalDayWeather = null;

		try{

			List<GeoRadiusResponse> list = jedis
					.georadius(RedisKeys.DayWeather.name(),
							coordinates.getLongitude(),
							coordinates.getLatitude(), 500, GeoUnit.KM,
							GeoRadiusParam.geoRadiusParam().withDist());

			log.info("Found GeoRadiusResponse: " + list.size());

			if(list.size() > 0 ){
				generalDayWeather = (GeneralDayWeather) SerializationUtils.deserialize(list.get(0).getMember());
			}


		} catch (JedisException e){
			log.error("Can't get DayWeather from Redis");
			throw new CustomDfmException("Can't get DayWeather from Redis", e);
		}

		return generalDayWeather;
	}




	public void setWeather(RedisStoreEntry storeEntry) throws CustomDfmException {

		Jedis jedis = jedisPool.getResource();

		try{
			jedis.expire(storeEntry.getRedisCoordinates().getRedisKeys().name(), 3600);

			byte [] serializableWeather = SerializationUtils.serialize(storeEntry);
			jedis.geoadd(
					storeEntry.getRedisCoordinates().getRedisKeys().name().getBytes(),
					storeEntry.getRedisCoordinates().getLongitude(),
					storeEntry.getRedisCoordinates().getLatitude(), serializableWeather);

		} catch (JedisException e){
			throw new CustomDfmException("Can't set class" + storeEntry.getClass().getName() + " to Redis", e);
		}
	}

}
