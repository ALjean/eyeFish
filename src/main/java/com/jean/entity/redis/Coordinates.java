package com.jean.entity.redis;

import com.jean.enums.RedisKeys;

import java.io.Serializable;

/**
 * Created by jean on 16.05.16.
 */
public class Coordinates implements Serializable {


	private static final long serialVersionUID = 6623918083270584656L;
	private float longitude;
	private float latitude;
	private RedisKeys redisKeys;



	public Coordinates(RedisKeys redisKeys, float longitude, float latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.redisKeys = redisKeys;
	}


	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public RedisKeys getRedisKeys() {
		return redisKeys;
	}

	public void setRedisKeys(RedisKeys redisKeys) {
		this.redisKeys = redisKeys;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Coordinates that = (Coordinates) o;

		return Float.compare(that.longitude, longitude) == 0 && Float.compare(that.latitude, latitude) == 0;

	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		temp = Float.floatToIntBits(longitude);
		result = (int) (temp ^ (temp >>> 32));
		temp = Float.floatToIntBits(latitude);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
}
