package com.agencyBack;

import com.agencyBack.entity.*;
import com.agencyBack.repository.OwnerRepository;
import com.agencyBack.service.ContractService;
import com.agencyBack.service.GoodService;
import com.agencyBack.service.VisitService;
import com.agencyBack.service.impl.GoodServiceImpl;
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
    @Bean
    public CommandLineRunner demo(GoodService goodService, OwnerRepository ownerRepository, VisitService visitService, ContractService contractService){
        return args -> {
        	Good good= new Good();
        	Owner owner = new Owner();
        	Visit visit = new Visit();
					Contract contract = new Contract();
        	owner.setName("Ismail");
        	good.setArea(55f);
        	good.setPrice(151351f);
        	good.setStatus(Status.TOSELL);
        	good.setTypeOfGood(TypeOfGood.APARTMENT);
        	good.setOwner(owner);
        	goodService.generateCode(good);
        	owner.setId(1l);
        	visit.setId(1l);
        	visit.setGood(good);
        	ownerRepository.save(owner);
        	goodService.create(good);
			contract.setGood(good);
			contract.setId(1l);
			contractService.create(contract);
			visitService.create(visit);

        };
    }
}
