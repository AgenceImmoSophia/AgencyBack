package com.agencyBack;

import com.agencyBack.controller.UserRestController;
import com.agencyBack.entity.Address;
import com.agencyBack.entity.Client;
import com.agencyBack.entity.Contract;
import com.agencyBack.entity.EstateAgent;
import com.agencyBack.entity.Good;
import com.agencyBack.entity.Owner;
import com.agencyBack.entity.Visit;
import com.agencyBack.repository.AddressRepository;
import com.agencyBack.repository.ClientRepository;
import com.agencyBack.repository.ContractRepository;
import com.agencyBack.repository.EstateAgentRepository;
import com.agencyBack.repository.GoodRepository;
import com.agencyBack.repository.OwnerRepository;
import com.agencyBack.repository.VisitRepository;
import com.agencyBack.service.AddressService;
import com.agencyBack.service.ClientService;
import com.agencyBack.service.EstateAgentService;
import com.agencyBack.service.GoodService;
import com.agencyBack.service.OwnerService;
import com.agencyBack.service.impl.GoodServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AgencyBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgencyBackApplication.class, args);
	}



//INFO: Used for testing
//    @Bean
//    public CommandLineRunner demo(GoodService goodService, OwnerService ownerService, OwnerRepository ownerRepository){
//        return args -> {
//        	Good good= new Good();
//        	Owner owner = new Owner();
//        	owner.setName("Bob");
//        	good.setPrice(151361f);
//        	good.setOwner(owner);
//        	owner.setId(2l);
//        	ownerRepository.save(owner);
//        	goodService.create(good);
//        };
//    }
//	@Bean
//    public CommandLineRunner demo(AddressService addressService, ClientService clientService, ClientRepository clientRepository){
//        return args -> {
//        	Client client = new Client();
//        	client.setId(1l);
//        	client.setName("Michel");
//        	client.setPhoneNumberPers("0606060606");
//        	Address address1 = new Address();
//        	address1.setId(1l);
//        	address1.setCountry("France");
//        	client.setAddress(address1);
//        	addressService.create(address1);
//        	clientRepository.save(client);
//        	
//        	
//        };
//    }
	
//	@Bean
//  public CommandLineRunner demo(AddressService addressService, EstateAgentRepository estateAgentRepository){
//      return args -> {
//      	EstateAgent agent = new EstateAgent();
//      	agent.setId(1l);
//      	agent.setName("Roger");
//      	agent.setPhoneNumberPers("0706060606");
//      	Address address2 = new Address();
//      	address2.setId(1l);
//      	address2.setCountry("France");
//      	agent.setAddress(address2);
//      	agent.setUsername("rogerAgent1");
//      	agent.setPassword("superMotDePasse");
//      	addressService.create(address2);
//      	estateAgentRepository.save(agent);
//      	
//      };
//  }
	
	@Bean
  public CommandLineRunner demo(AddressRepository addressRepository, EstateAgentRepository estateAgentRepository, ClientRepository clientRepository, OwnerRepository ownerRepository, GoodRepository goodRepository, ContractRepository contractRepository, VisitRepository visitRepository){
      return args -> {
      	EstateAgent agent = new EstateAgent();
      	agent.setId(1l);
      	agent.setName("Roger");
      	agent.setPhoneNumberPers("0706060606");
      	Address address2 = new Address();
      	address2.setId(1l);
      	address2.setCountry("France");
      	agent.setAddress(address2);
      	agent.setUsername("rogerAgent1");
      	agent.setPassword("superMotDePasse");
      	addressRepository.save(address2);
      	
      	Client client = new Client();
    	client.setId(2l);
    	client.setName("Michel");
    	client.setPhoneNumberPers("0606060606");
    	
    	Owner owner = new Owner();
    	owner.setId(3l);
    	owner.setName("Bob");
    	
    	estateAgentRepository.save(agent);
    	clientRepository.save(client);
    	ownerRepository.save(owner);
    	
    	Good good= new Good();
    	goodRepository.save(good);
    	
    	Contract contract = new Contract();
    	contract.setId(1l);
    	contract.setPrice(15f);
    	contract.setClient(client);
    	contract.setEstateAgent(agent);
    	contract.setGood(good);
    	contractRepository.save(contract);
    	
    	good.setNameOfGood("maison");
    	good.setPrice(151361f);
    	good.setOwner(owner);
    	Address address3 = new Address();
      	address3.setId(2l);
      	address3.setCountry("France");
      	good.setAddress(address3);
    	addressRepository.save(address3);
    	good.setContract(contract);
    	goodRepository.save(good);
    	
    	Good good2 = new Good();
    	good2.setId(2l);
    	goodRepository.save(good2);
    	
    	List<Good> listGood = client.getListGood();
    	listGood.add(good);
    	listGood.add(good2);
    	client.setListGood(listGood); 
    	List<String> listCode = client.getListCode();
    	listCode.add("1515");
    	client.setListCode(listCode);
    	clientRepository.save(client);
   	
    	List<Good> listOwnGood = owner.getListGood();
    	listOwnGood.add(good);
    	owner.setListGood(listOwnGood);
    	ownerRepository.save(owner);
    	
    	Visit visit = new Visit();
      	visit.setId(1l);
      	visit.setGood(good);
      	visit.setClient(client);
      	visit.setEstateAgent(agent);
      	visitRepository.save(visit);
      	
      	List<Visit> listVisit = good.getClientVisit();
      	listVisit.add(visit);
      	good.setClientVisit(listVisit);
      	goodRepository.save(good);
//      	
      };
  }
}
