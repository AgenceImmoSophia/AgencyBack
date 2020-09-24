package com.agencyBack.repository;


import com.agencyBack.entity.Good;
import com.agencyBack.entity.Owner;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface GoodRepository extends BaseRepository<Good> {
    Good findGoodByNameOfGood (String name);
    List<Good> findGoodByOwner(Owner owner);
    List<Good> findAllByOrderByIdAsc();
}
