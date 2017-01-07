package com.jean.repository;

import com.jean.entity.fish.Fish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FishRepository extends JpaRepository<Fish, Long> {



    @Query("SELECT f FROM Fish f WHERE f.name = :fishName AND f.fishType = :fishType AND f.daysActivity IN (:dayActivity) AND f.livingAreas IN (:livingArea)")
    List<Fish> findByParams(@Param("fishName") String fishName, @Param("fishType") String fishType, @Param("dayActivity") String dayActivity, @Param("livingArea") String livingArea);


}
