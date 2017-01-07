package com.jean.repository;

import com.jean.entity.fish.Fish;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FishRepository extends Repository<Fish, Integer> {



    @Query("SELECT f FROM Fish f WHERE f.name = :fishName AND f.fishType = :fishType AND f.daysActivity IN (:dayActivity) AND f.livingAreas IN (:livingArea)")
    List<Fish> findByParams(@Param("baitName") String baitName, @Param("baitType") String baitType);


}
