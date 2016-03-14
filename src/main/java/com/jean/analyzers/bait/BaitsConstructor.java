package com.jean.analyzers.bait;

import java.util.List;
import com.jean.entity.Fish;
import com.jean.entity.Bait;
import com.jean.entity.EcosystemProperties;

public interface BaitsConstructor {

    public List<Bait> getTheBestBaits(Fish fish, EcosystemProperties properties);
}
