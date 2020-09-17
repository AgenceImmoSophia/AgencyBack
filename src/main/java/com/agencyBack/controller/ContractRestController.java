package com.agencyBack.controller;

import org.springframework.web.bind.annotation.*;
import com.agencyBack.entity.Contract;
import com.agencyBack.service.ContractService;
import javassist.NotFoundException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContractRestController {

	// ATTRIBUTES

	private final ContractService contractService;

	public ContractRestController(ContractService contractService) {
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
