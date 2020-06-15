package com.axamit.repository;


import com.axamit.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {


    @Query(value = "select *  FROM visit as v  WHERE v.date >= NOW() - INTERVAL 1 DAY", nativeQuery = true)
    @Transactional
    public List<Visit> findVisitsLastDay();


    @Query(value = "select *  FROM visit as v  WHERE (v.date BETWEEN :from AND :to)", nativeQuery = true)
    @Transactional
    public List<Visit> findVisitsForPeriod(@Param("from") Date from,
                                           @Param("to") Date to);
}
