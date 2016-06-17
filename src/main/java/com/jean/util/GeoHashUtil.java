package com.jean.util;

public class GeoHashUtil {

	public static boolean isNearestPoint(double lat1, double lon1, double lat2, double lon2) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 1.609344;
		if(dist > 5){
			return false;
		}
		return true;
	}

	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}

	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}
	
	public static void main(String[] args){
		System.out.println(isNearestPoint(34.5, 50, 34.5, 50));
	}
}
