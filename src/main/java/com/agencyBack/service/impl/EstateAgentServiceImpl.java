package com.agencyBack.service.impl;

import org.springframework.stereotype.Service;

import com.agencyBack.entity.EstateAgent;
import com.agencyBack.repository.EstateAgentRepository;
import com.agencyBack.service.EstateAgentService;

@Service
public class EstateAgentServiceImpl extends UserServiceImpl implements EstateAgentService{
	
	private EstateAgentRepository estateAgentRepository;

	public EstateAgentServiceImpl(EstateAgentRepository estateAgentRepository) {
		super(estateAgentRepository);
		this.estateAgentRepository = estateAgentRepository;
	}

	@Override
	public EstateAgent findEstateAgentByUsername(String username) {
		EstateAgent estateAgentFound= this.estateAgentRepository.findEstateAgentByUsername(username);
        return estateAgentFound;
	}

}
