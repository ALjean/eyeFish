package com.jean.util;

import com.jean.BaseTest;
import org.junit.Test;

/**
 * Created by root on 18.07.15.
 */
public class UtilsTest extends BaseTest {

    private float input = 295;

    @Test
    public void kelvinToCelsiusTest() {
        float result  = Utils.kelvinToCelsius(input);
        System.out.println(result);
    }
}
