package com.jean.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jean.DaoDfmException;

import org.junit.Before;
import org.junit.Test;

import com.jean.BaseTest;
import com.jean.CustomDfmException;
import com.jean.analyzers.weather.ConstantsAnalyzer.KEY_MESSAGE;
import com.jean.entity.Bait;
import com.jean.entity.BaitPropertie;
import com.jean.entity.BaitType;
import com.jean.entity.DateHolder;
import com.jean.entity.PondEnvirmoment;
import com.jean.enums.ParamNames;
import com.jean.util.BaitSetting;
import com.jean.util.ParameterName;
import com.jean.util.ParameterNamesHolder;
import com.jean.util.Qualifier;

public class BaitDaoTest extends BaseTest {

	private int fishId;
	private int generateKey;
	private String key;
	private Date date;
	private Bait bait;
	private List<BaitSetting> baitSettings;
	private List<Qualifier> qualifiers;
	private List<DateHolder> dates;
	private List<Integer> idFishes;
	private List<Bait> baits;
	private PondEnvirmoment pond;

	@Before
	public void init() {
		fishId = 7;
		key = KEY_MESSAGE.STYRO_POP_UP.toString();
		date = Date.valueOf("2016-06-22");

		idFishes = new ArrayList<Integer>();
		idFishes.addAll(Arrays.asList(new Integer[] { 13 }));

		dates = new ArrayList<DateHolder>();
		dates.add(new DateHolder(Date.valueOf("2016-04-01"), Date.valueOf("2016-07-30")));
		dates.add(new DateHolder(Date.valueOf("2016-02-01"), Date.valueOf("2016-03-25")));

		qualifiers = new ArrayList<Qualifier>();
		qualifiers.add(new Qualifier(0, ParamNames.ENVIRMOMENT_TEMPERATURE.name(), 0, 12));
		qualifiers.add(new Qualifier(0, ParamNames.CLOUD_LEVEL.name(), 30, 65));

		baitSettings = new ArrayList<BaitSetting>();
		baitSettings.add(new BaitSetting(0, "Color", "Red", "Use for the best result", qualifiers));
		baitSettings.add(new BaitSetting(0, "Color", "White", "Use for the best result", qualifiers));

		bait = new Bait(0, "Castmaster", "For real predator!", baitSettings, idFishes, dates);

		pond = new PondEnvirmoment(30.0, 0.0, 11.0, 0.0, 0.0, 3.0, 0.0, 0.0);
	}

	@Test
	public void getBaitsByPondParamsTest() throws CustomDfmException, DaoDfmException {
		baits = baitDao.getBaitsByPondParams(null, null, null, 7, pond);
		assertTrue(!baits.isEmpty());
		System.out.println("\n Get baits by pond params: \n");
		for (Bait bait : baits) {
			System.out.println(bait);
		}
	}

	@Test
	public void getBaits() throws DaoDfmException, CustomDfmException {
		baits = baitDao.getBaits(null, null, null, null);
		assertTrue(baits.size() > 2);

		System.out.println("\n All baits: \n");
		for (Bait bait : baits) {
			System.out.println(bait);
		}

		baits = baitDao.getBaits(60, null, null, null);
		assertTrue(baits.size() == 1);
		baits = baitDao.getBaits(23, " ", 23, null);
		assertTrue(baits.isEmpty());
	}

	@Test
	public void saveBaitTest() throws DaoDfmException, CustomDfmException {
		generateKey = baitDao.saveBait(bait);
		assertTrue(generateKey > 0);
		System.out.println("\n Primary key for new bait: \n");
		System.out.println(generateKey);
	}

	@Test
	public void deleteBaitTest() throws DaoDfmException, CustomDfmException {
		List<Integer> list = new ArrayList<Integer>();
		list.add(87);
		int result = baitDao.deleteBait(list);
		assertTrue(result != 0);
	}

	@Test
	public void updateBaitTest() throws DaoDfmException, CustomDfmException {
		List<Bait> baits = baitDao.getBaits(4, null, null, null);
		Bait bait = baits.get(0);
		bait.setBaitName("CORNS");
		baitDao.updateBait(bait);
		List<Bait> baitsUpdate = baitDao.getBaits(4, null, null, null);
		assertTrue(baitsUpdate.get(0).getBaitName().equals("CORNS"));
	}

}
