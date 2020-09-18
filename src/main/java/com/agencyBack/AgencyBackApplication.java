package com.agencyBack;

import com.agencyBack.entity.*;
import com.agencyBack.repository.ClientRepository;
import com.agencyBack.repository.EstateAgentRepository;
import com.agencyBack.repository.OwnerRepository;
import com.agencyBack.service.AddressService;
import com.agencyBack.service.ClientService;
import com.agencyBack.service.ContractService;
import com.agencyBack.service.EstateAgentService;
import com.agencyBack.service.GoodService;
import com.agencyBack.service.OwnerService;
import com.agencyBack.service.VisitService;
import com.agencyBack.service.impl.ClientServiceImpl;
import com.agencyBack.service.impl.EstateAgentServiceImpl;
import com.agencyBack.service.impl.OwnerServiceImpl;

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
//    public CommandLineRunner demo(OwnerService ownerService, OwnerRepository ownerRepository){
//        return args -> {
//        	Owner owner = new Owner();
//        	owner.setName("Booooob");
//
//        	ownerRepository.save(owner);
//
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
	public CommandLineRunner demo(AddressService addressService, EstateAgentService estateAgentService, EstateAgentRepository ear, ClientRepository cr, OwnerRepository or, ClientService clientService, OwnerService ownerService, GoodService goodService, ContractService contractService, VisitService visitService){
      return args -> {
      	EstateAgent agent = new EstateAgent();
      	agent.setName("Roger");
      	agent.setPhoneNumberPers("0706060606");
      	Address address2 = new Address();
      	address2.setId(1l);
      	address2.setCountry("France");
      	address2.setCity("Paris");
      	address2.setStreet("OoooohChampsElysees");
      	address2.setStreetNber("1");
      	address2.setZipcode("75000");
      	agent.setAddress(address2);
      	agent.setUsername("rogerAgent1");
      	agent.setPassword("superMotDePasse");
      	addressService.create(address2);

      	Client client = new Client();
    	client.setName("Michel");
    	client.setPhoneNumberPers("0606060606");

    	Owner owner = new Owner();
    	owner.setName("Bob");

    	EstateAgentService eas = new EstateAgentServiceImpl(ear);
    	eas.create(agent);

    	ClientService cs = new ClientServiceImpl(cr);
    	cs.create(client);

    	OwnerService os = new OwnerServiceImpl(or);
    	os.create(owner);


    	Good good= new Good();
    	goodService.create(good);

    	Contract contract = new Contract();
    	contract.setId(1l);
    	contract.setPrice(15f);
    	contract.setClient(client);
    	contract.setEstateAgent(agent);
    	contract.setGood(good);
    	contractService.create(contract);

    	good.setNameOfGood("maison");
    	good.setPrice(151361f);
    	good.setOwner(owner);
    	Address address3 = new Address();
      	address3.setId(2l);
      	address3.setCountry("France");
      	address3.setCity("Nice");
      	address3.setStreet("Elysees");
      	address3.setStreetNber("2");
      	address3.setZipcode("06000");
     	good.setAddress(address3);
    	addressService.create(address3);
    	good.setContract(contract);
    	goodService.create(good);

    	Good good2 = new Good();
    	good2.setId(2l);
    	good2.setAddress(address2);
    	goodService.create(good2);

    	List<Good> listDesiredGood = client.getListDesiredGood();
    	listDesiredGood.add(good);
    	listDesiredGood.add(good2);
    	client.setListDesiredGood(listDesiredGood);
    	List<String> listCode = client.getListCode();
    	listCode.add("1515");
    	client.setListCode(listCode);
    	cs.create(client);

    	List<Good> listOwnedGood = owner.getListOwnedGood();
    	listOwnedGood.add(good);
    	owner.setListOwnedGood(listOwnedGood);
    	os.create(owner);

    	Visit visit = new Visit();
      	visit.setId(1l);
      	visit.setGood(good);
      	visit.setClient(client);
      	visit.setEstateAgent(agent);
      	visitService.create(visit);

      	List<Visit> listVisit = good.getClientVisit();
      	listVisit.add(visit);
      	good.setClientVisit(listVisit);
      	goodService.create(good);

      };
  }
}
