package com.agencyBack.repository;

import org.springframework.stereotype.Repository;

import com.agencyBack.entity.EstateAgent;


@Repository
public interface EstateAgentRepository extends UserRepository{
	EstateAgent findEstateAgentByUsername (String username);

}
