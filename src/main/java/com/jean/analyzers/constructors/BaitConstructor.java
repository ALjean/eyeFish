package com.jean.analyzers.constructors;

import java.sql.Date;
import java.util.List;

import com.jean.DaoDfmException;
import com.jean.dao.entity.bait.Bait;

public interface BaitConstructor {

	List<Bait> getBaitsDependsOnWeathers(long fishId, Date date) throws DaoDfmException;
}
