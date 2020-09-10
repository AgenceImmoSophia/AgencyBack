package com.agencyBack.service.impl;

import com.agencyBack.entity.Visit;
import com.agencyBack.repository.VisitRepository;
import com.agencyBack.service.VisitService;

public class VisitServiceImpl extends BaseServiceImpl<Visit> implements VisitService {
	
	public VisitServiceImpl(VisitRepository visitRepository) {
		super(visitRepository, new Visit());
	}
}
