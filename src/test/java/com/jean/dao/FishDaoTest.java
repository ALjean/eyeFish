package com.jean.dao;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.entity.DayActivity;
import com.jean.entity.Fish;
import com.jean.entity.FishSetting;
import com.jean.entity.LivingArea;
import com.jean.entity.NibblePeriod;
import com.jean.enums.DaysActivity;
import com.jean.enums.FishTypes;
import com.jean.enums.LiveArea;
import com.jean.enums.ParamNames;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.stereotype.Component;
import com.jean.BaseTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stas on 30.05.15.
 */

@Component
public class FishDaoTest extends BaseTest {

	private Fish fish;

	private List<FishSetting> fishSettings;
	private List<NibblePeriod> nibblePeriods;
	private List<DayActivity> daysActivity;
	private List<LivingArea> livingAreas;

	@Before
	public void init() throws CustomDfmException {

		fishSettings = new ArrayList<FishSetting>();
		fishSettings.add(new FishSetting(0, 0, ParamNames.ENVIRMOMENT_TEMPERATURE.name(), 0.0, 7.0, 23.5));
		fishSettings.add(new FishSetting(0, 0, ParamNames.ENVIRMOMENT_TEMPERATURE.name(), 8.0, 12.0, 57.23));
		fishSettings.add(new FishSetting(0, 0, ParamNames.ENVIRMOMENT_TEMPERATURE.name(), 13.8, 19.0, 77.23));

		nibblePeriods = new ArrayList<NibblePeriod>();
		nibblePeriods.add(new NibblePeriod(0, 0, Date.valueOf("2016-05-23"), Date.valueOf("2016-06-01"), 0.0));
		nibblePeriods.add(new NibblePeriod(0, 0, Date.valueOf("2016-06-02"), Date.valueOf("2016-09-01"), 53.45));
		nibblePeriods.add(new NibblePeriod(0, 0, Date.valueOf("2016-09-02"), Date.valueOf("2016-12-31"), 89.32));

		daysActivity = new ArrayList<DayActivity>();
		daysActivity.add(new DayActivity(0, 0, DaysActivity.MORNING.name()));
		daysActivity.add(new DayActivity(0, 0, DaysActivity.MORNING.name()));

		livingAreas = new ArrayList<LivingArea>();
		livingAreas.add(new LivingArea(0, 0, LiveArea.MIDDLE.name()));
		livingAreas.add(new LivingArea(0, 0, LiveArea.TOP.name()));

		fish = new Fish(0, "Roach", "Europian Roach", FishTypes.CALM.name(), livingAreas, daysActivity, fishSettings,
				nibblePeriods);
	}

	@Test
	public void saveFish() throws DaoDfmException {

		int result = fishDao.saveFish(fish);
		assertTrue("Key must be not 0", result > 0);
		System.out.println(result);
	}

	@Test
	public void getAllFishes() throws DaoDfmException {

		List<Fish> fishes = fishDao.getFishes(null, null, null, null, null);
		assertTrue(!fishes.isEmpty());

		System.out.println(fishes.size() + "\n");

		for (Fish fish : fishes) {
			System.out.println(fish.getId());
			System.out.println(fish.getName());
			System.out.println(fish.getFishType());
			System.out.println(fish.getDescription());
			System.out.println(fish.getFishSetting());
			System.out.println(fish.getNibbles());
			System.out.println(fish.getDaysActivity());
			System.out.println(fish.getLivingArea());
			System.out.println();
		}
	}

	@Test
	public void getFishById() throws DaoDfmException {
		int itr = 0;
		List<Fish> fishes = fishDao.getFishes(7, null, null, null, null);
		assertTrue("Empty list", !fishes.isEmpty());

		for (Fish fish : fishes) {
			assertTrue("Don't confirm to expected key", fish.getId() == 7);
			itr++;
		}
		assertTrue("Return more than one object", itr == 1);
	}

	@Test
	public void getFishByName() throws DaoDfmException {
		int itr = 0;
		List<Fish> fishes = fishDao.getFishes(null, "**arp", null, null, null);
		assertTrue("Empty list", !fishes.isEmpty());

		for (Fish fish : fishes) {
			assertTrue("Don't confirm to expected name", fish.getName().equals("Carp"));
			itr++;
		}
		assertTrue("Return more than one object", itr == 1);
	}

	@Test
	public void getFishByType() throws DaoDfmException {
		List<Fish> fishes = fishDao.getFishes(null, null, "***M", null, null);
		assertTrue("Empty list", !fishes.isEmpty());

		for (Fish fish : fishes) {
			assertTrue("Don't confirm to expected name", fish.getFishType().equals("CALM"));
		}
	}

	@Test
	public void getFishByActivity() throws DaoDfmException {
		List<Fish> fishes = fishDao.getFishes(null, null, null, "***NG", null);
		assertTrue("Empty list", !fishes.isEmpty());
	}
	
	@Test
	public void getFishByArea() throws DaoDfmException {
		List<Fish> fishes = fishDao.getFishes(null, null, null, null, "**OM");
		assertTrue("Empty list", !fishes.isEmpty());
	}
	
	@Test
	public void getFishByWrongParams() throws DaoDfmException {
		List<Fish> fishes = fishDao.getFishes(23, "HJK", null, null, "**RROR");
		assertTrue("List is not empty", fishes.isEmpty());
	}
	
	@Test
	public void updateFish() throws DaoDfmException{
		List<Fish> fishes = fishDao.getFishes(40, null, null, null, null);
		Fish fish = fishes.get(0);
		fish.setName("Yaz");
		fish.getFishSetting().get(0).setNibbleLevel(100);
		fish.getNibbles().get(0).setNibbleLevel(100);
		fish.getDaysActivity().get(0).setActivityName(DaysActivity.MORNING.name());
		fishDao.updateFish(fish);
	}
	
	@Test
	public void deleteFish() throws DaoDfmException{

		int result = fishDao.deleteFish(Arrays.asList(new Integer[] { 41, 42 }));
		assertTrue(result == 1);
	}

}
