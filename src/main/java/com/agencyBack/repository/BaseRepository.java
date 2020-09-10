package com.agencyBack.repository;

import org.springframework.data.repository.CrudRepository;

public interface BaseRepository<T> extends CrudRepository<T, Long> {
}
