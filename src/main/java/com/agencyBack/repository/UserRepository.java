package com.agencyBack.repository;

import com.agencyBack.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>{

}
