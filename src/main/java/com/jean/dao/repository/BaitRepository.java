package com.jean.dao.repository;

import com.jean.dao.entity.bait.Bait;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



import java.util.List;


public interface BaitRepository extends JpaRepository<Bait, Long> {


    @Query("SELECT b FROM Bait b WHERE b.name = :baitName AND b.type = :baitType")
    List<Bait> findByParams(@Param("baitName") String baitName, @Param("baitType") String baitType);
}
