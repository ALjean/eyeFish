package com.jean.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.analyzers.behavior.BehaviorAnalyzer;
import com.jean.dao.FishDao;
import com.jean.entity.Behavior;
import com.jean.entity.BehaviorsDTO;
import com.jean.entity.Fish;
import com.jean.entity.GeneralHourWeather;
import com.jean.entity.HourWeather;
import com.jean.service.BehaviorService;
import com.jean.util.Utils;

@Service
public class BehaviorServiceImpl implements BehaviorService {

	@Autowired
	private BehaviorAnalyzer behaviorAnalyzer;

	@Autowired
	private FishDao fishDao;

	@Override
	public List<BehaviorsDTO> getFishBehavior(List<String> calculatedDates, List<Integer> fishIds,
			GeneralHourWeather generalHourWeather) throws DaoDfmException, CustomDfmException {

		BehaviorsDTO behaviorsDTO = null;
		List<BehaviorsDTO> behaviorsDTOList = new ArrayList<>();

		for (int id : fishIds) {
			Fish fish = fishDao.getFishes(id, null, null, null, null).get(0);
			behaviorsDTO = new BehaviorsDTO();
			behaviorsDTO.setFish(fish);
			behaviorsDTOList.add(behaviorsDTO);
			for (String currentDate : calculatedDates) {
				if (behaviorsDTO.getBehaviors().containsKey(currentDate)) {
					behaviorsDTO.getBehaviors().get(currentDate).add(behaviorAnalyzer.getFishBehavior(
							generalHourWeather.getDayHourWeathers().get(Utils.parseJsonDateTxt(currentDate)), fish));
				} else {
					List<Behavior> behaviors = new ArrayList<Behavior>();

					behaviors.add(behaviorAnalyzer.getFishBehavior(
							generalHourWeather.getDayHourWeathers().get(Utils.parseJsonDateTxt(currentDate)), fish));

					behaviorsDTO.getBehaviors().put(currentDate, behaviors);
				}
			}
		}

		return behaviorsDTOList;

	}

}
