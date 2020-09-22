package com.agencyBack.service;

import com.agencyBack.entity.EstateAgent;

public interface EstateAgentService extends UserService {
	
	public EstateAgent findEstateAgentByUsername (String username);

}
