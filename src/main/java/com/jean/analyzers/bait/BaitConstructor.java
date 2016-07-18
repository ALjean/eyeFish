package com.jean.analyzers.bait;

import java.util.List;

import com.jean.DaoDfmException;
import com.jean.entity.Bait;
import com.jean.entity.Fish;
import com.jean.entity.HourWeather;
import com.jean.entity.PeeperDTO;
import com.jean.entity.PondEnvirmoment;

public interface BaitConstructor {

	List<Bait> getBaits(int fishId, String baitType, HourWeather hourWeather, PeeperDTO peepperDTO) throws DaoDfmException;
}
