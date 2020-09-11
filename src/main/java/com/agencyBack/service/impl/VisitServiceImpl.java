package com.agencyBack.service.impl;

import org.springframework.stereotype.Service;

import com.agencyBack.entity.Visit;
import com.agencyBack.repository.VisitRepository;
import com.agencyBack.service.VisitService;

@Service
public class VisitServiceImpl extends BaseServiceImpl<Visit> implements VisitService {
	
	public VisitServiceImpl(VisitRepository visitRepository) {
		super(visitRepository, new Visit());
	}
}
