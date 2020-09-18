package com.agencyBack.service.impl;

import org.springframework.stereotype.Service;

import com.agencyBack.repository.EstateAgentRepository;
import com.agencyBack.service.EstateAgentService;

@Service
public class EstateAgentServiceImpl extends UserServiceImpl implements EstateAgentService{

	public EstateAgentServiceImpl(EstateAgentRepository estateAgentRepository) {
		super(estateAgentRepository);
	}

}
