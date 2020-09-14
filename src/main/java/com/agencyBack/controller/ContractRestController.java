package com.agencyBack.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.agencyBack.entity.Contract;
import com.agencyBack.service.impl.ContractServiceImpl;

import javassist.NotFoundException;

@RestController
public class ContractRestController {
	
	// ATTRIBUTES
	
	private final ContractServiceImpl contractService;
	
	public ContractRestController (ContractServiceImpl contractService) {
		this.contractService = contractService;
	}
	
	@PostMapping(value = "/createContract")
	public Contract createContract (@RequestBody Contract newContract) {
		return this.contractService.create(newContract);
	}
	
	@GetMapping(value = "/contract/{id}")
	public Contract findContractById (@PathVariable("id") Long id) throws NotFoundException {
		Contract foundContract = this.contractService.getById(id);
		return foundContract;
	}
	
	@GetMapping("/allContracts")
	public Iterable<Contract> findAllContracts(){
		return this.contractService.getAll();
	}
	
	@PutMapping(value = "/contract/{id}/editContract")
	public void editContractById (@PathVariable ("id") Long id, @RequestBody Contract contract) throws NotFoundException {
		this.contractService.edit(contract);
	}
	
	@DeleteMapping("/deleteContract/{id}")
	public void deleteContractById (@PathVariable("id") Long id) throws NotFoundException {
		this.contractService.deleteById(id);
	}
	

}
