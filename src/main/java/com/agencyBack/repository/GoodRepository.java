package com.agencyBack.repository;


import com.agencyBack.entity.Good;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface GoodRepository extends BaseRepository<Good> {
    Good findGoodByNameOfGood (String name);
    List<Good> findAllByOrderByIdAsc();
}
