package com.jean.analyzers.fish;

import java.util.List;
import com.jean.entity.AbstractFish;
import com.jean.entity.Bait;
import com.jean.entity.EcosystemProperties;

public interface BaitsConstructor {

    public List<Bait> getTheBestBaits(AbstractFish fish, EcosystemProperties properties);
}
