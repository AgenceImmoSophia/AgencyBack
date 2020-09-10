package com.agencyBack.repository;

import org.springframework.data.repository.CrudRepository;

import com.agencyBack.entity.Address;

public interface AddressRepository extends CrudRepository<Address,Long> {

}
