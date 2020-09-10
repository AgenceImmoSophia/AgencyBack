package com.agencyBack.repository;


import com.agencyBack.entity.Good;
import org.springframework.data.repository.CrudRepository;

public interface GoodRepository extends CrudRepository<Good, Long> {
}
