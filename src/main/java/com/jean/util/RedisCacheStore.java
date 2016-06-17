package com.jean.util;

import com.jean.entity.GeneralDayWeather;
import com.jean.entity.GeneralHourWeather;
import com.jean.servlet.model.Coordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by jean on 16.05.16.
 */
@Component
public class RedisCacheStore {

	private enum RedisKeys {
		DayWeather, HourWeather
	}

	@Autowired
	private RedisTemplate<Object, Object> template;

	public void setDayWeather(GeneralDayWeather generalDayWeather) {
		template.expire(RedisKeys.DayWeather.name(), 1, TimeUnit.HOURS);
		template.opsForHash().put(RedisKeys.DayWeather.name(),
				generalDayWeather.generateRedisHashKey(RedisKeys.DayWeather.name()), generalDayWeather);
	}

	public void setHourWeather(GeneralHourWeather generalHourWeather) {
		template.expire(RedisKeys.HourWeather.name(), 1, TimeUnit.HOURS);
		template.opsForHash().put(RedisKeys.HourWeather.name(),
				generalHourWeather.generateRedisHashKey(RedisKeys.HourWeather.name()), generalHourWeather);
	}

	public GeneralDayWeather findDayWeather(Coordinates coordinates) {
		return (GeneralDayWeather) template.opsForHash().get(RedisKeys.DayWeather.name(), 
				findWeatherKey(coordinates, RedisKeys.DayWeather.name()));
	}

	public GeneralHourWeather findHourWeather(Coordinates coordinates) {
		return (GeneralHourWeather) template.opsForHash().get(RedisKeys.HourWeather.name(),
				findWeatherKey(coordinates, RedisKeys.HourWeather.name()));
	}

	private Coordinates findWeatherKey(Coordinates coordinates, String redisCoordKey) {
		Set redisSet = Collections.unmodifiableSet(template.opsForHash().keys(redisCoordKey));
		Set<Coordinates> keys = new HashSet<>(redisSet);
		for (Coordinates coord : keys) {
			if (GeoHashUtil.isNearestPoint(coord.getLatitude(), coord.getLongitude(), coordinates.getLatitude(),
					coordinates.getLongitude())) {
				return coord;
			}
		}

		/*
		 * Set<Coordinates> foundResult = keys.stream().filter(key ->
		 * GeoHashUtil.isNearestPoint(key.getLatitude(), key.getLongitude(),
		 * coordinates.getLatitude(),
		 * coordinates.getLongitude())).collect(Collectors.toSet());
		 * 
		 * return foundResult.size() > 0 ? foundResult.iterator().next() : new
		 * Coordinates();
		 */

		return new Coordinates();
	}

}
