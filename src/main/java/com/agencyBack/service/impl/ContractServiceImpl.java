package com.agencyBack.service.impl;

import org.springframework.stereotype.Service;

import com.agencyBack.entity.Contract;
import com.agencyBack.repository.ContractRepository;
import com.agencyBack.service.ContractService;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl extends BaseServiceImpl<Contract> implements ContractService {

	public ContractServiceImpl(ContractRepository contractRepository) {
		super(contractRepository, new Contract());
	}

}
