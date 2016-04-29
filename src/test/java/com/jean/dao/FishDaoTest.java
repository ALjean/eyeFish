package com.jean.dao;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.entity.Fish;
import com.jean.entity.FishSetting;
import com.jean.enums.DaysActivity;
import com.jean.enums.FishTypes;
import com.jean.enums.LiveArea;
import com.jean.enums.ParamNames;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.stereotype.Component;
import com.jean.BaseTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 30.05.15.
 */

@Component
public class FishDaoTest extends BaseTest {

	private Fish fish;

	@Before
	public void init() throws CustomDfmException {
		
	}
}
