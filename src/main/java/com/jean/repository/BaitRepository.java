package com.jean.repository;

import com.jean.entity.bait.Bait;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.Repository;


import java.util.List;


public interface BaitRepository extends Repository<Bait, Integer> {


    @Query("SELECT b FROM Bait b WHERE b.name = :baitName AND b.type = :baitType")
    List<Bait> findByParams(@Param("baitName") String baitName, @Param("baitType") String baitType);
}
