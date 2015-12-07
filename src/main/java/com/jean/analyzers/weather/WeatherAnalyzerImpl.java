package com.jean.analyzers.weather;



public class WeatherAnalyzerImpl implements WeatherAnalyzer {

    @Override
    public double StabilityChecker(float[] temperatureParams) {

        // Result should be represented in percent.
        double result = 0;

        // Amount of day which take part in analyze process.
        int countDay = 1;

        // General temperature changes during period of compute.
        float generalChange = Math.abs((temperatureParams[temperatureParams.length - 1] - temperatureParams[0]));

        for (int i = 0; i < temperatureParams.length - 1; i++) {

            if (generalChange > ConstantsAnalyzer.MAX_GENERAL_TEMPERATURE_CHANGES) {
                return ConstantsAnalyzer.PERCENT_TEMPERATURE_CHANGES / 2;
            }

	    /*
         * Changes which had happened between different days (for example)
	     * or two different values of temperature.
	     */
            float dayChange = Math.abs(temperatureParams[i + 1] - temperatureParams[i]);

	    /*
	     * If changes during the day have critical character, we must
	     * analyze next part of data - after critical point. We reset amount
	     * of day and finally result, and try compute again.
	     */
            if (dayChange > ConstantsAnalyzer.CRITICAL_TEMPERATURE_CHANGES) {
                result = 0;
                countDay = 0;
            }

	    /*
	     * If we didn't have any changes, we have added to the result 0.01
	     * "percent changes" (it's like "badly percent" - the more the
	     * worse). Also we have increment count of day, because it,s
	     * "normal day" and he should take part in finally compute of
	     * result.
	     */
            if (dayChange == 0) {
                result += 0.01;

                // In other case we compute result use usually methods.
            } else {
                result += dayChange * ConstantsAnalyzer.PERCENT_TEMPERATURE_CHANGES;
            }

            countDay++;
        }

	/*
	 * Check result, if we have all period horrible changes, we return
	 * minimal value.
	 */
        if (result == 0) {
            return ConstantsAnalyzer.PERCENT_TEMPERATURE_CHANGES / 2;

	    /*
	     * Return finally result. It's mean value for all compute period -
	     * that's why we reseted count of day. And finally we subtracted 100
	     * from result, because we have "badly percent", but we need
	     * "percent of activity"
	     */
        } else {
            return Math.abs((result / countDay) - 100);
        }
    }

    @Override
    public double windAnalyzer(Wind wind, double temperature) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double pressureChecker(float[] pressureParams) {

        double result = 0;

        float generalChange = pressureParams[pressureParams.length - 1] - pressureParams[0];

        if (Math.abs(generalChange) > ConstantsAnalyzer.CRITICAL_PRESSURE_CHANGES) {
            return ConstantsAnalyzer.CRITICAL_PRESSURE_CHANGES / 2;
        }
        if (generalChange == 0 || generalChange > 0) {
            return ConstantsAnalyzer.PERCENT_PRESSURE_CHANGES * ConstantsAnalyzer.CRITICAL_PRESSURE_CHANGES;
        }
        if (generalChange < 0) {
            return Math.abs(Math.abs(generalChange) * ConstantsAnalyzer.PERCENT_PRESSURE_CHANGES / pressureParams.length - 100);
        }

        return result;
    }

    @Override
    public double badWeatherAnalyzer(double rain, double clouds, double temperature) {
        // TODO Auto-generated method stub
        return 0;
    }

    public static void main(String[] args) {

        WeatherAnalyzer analyzer = new WeatherAnalyzerImpl();

        float[] temperatureParams = {32.5f, 32.8f, 33f, 33.5f, 31.2f};

        float[] pressureParams = {740.25f, 742.3f, 743f, 743.4f, 736f};

        System.out.println("Stability of weather are: " + analyzer.StabilityChecker(temperatureParams));

        System.out.println("Pressure activity are: " + analyzer.pressureChecker(pressureParams));

    }

}
