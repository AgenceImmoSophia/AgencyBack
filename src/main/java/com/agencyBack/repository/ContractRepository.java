package com.agencyBack.repository;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;
import com.agencyBack.entity.Contract;

public interface ContractRepository extends CrudRepository<Contract, Long> {

	Contract getContractById(Long id);
	
	Contract getContractByPrice(float price);
	
	Contract getContractByDate(Date date);
	
}
