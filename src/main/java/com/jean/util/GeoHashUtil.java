package com.jean.util;

public class GeoHashUtil {

	public static double getDistance(double lat1, double lon1, double lat2, double lon2) {
		double earthRadius = 6371; //meters
	    double dLat = Math.toRadians(lat2-lat1);
	    double dLng = Math.toRadians(lon2-lon1);
	    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
	               Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
	               Math.sin(dLng/2) * Math.sin(dLng/2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	    double dist = ((double) (earthRadius * c));
		return dist;
	}

	public static void main(String[] args) {
		System.out.println(getDistance(49.35, 34.34, 49.35, 34.34));
	}
}
