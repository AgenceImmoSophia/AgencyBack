package com.agencyBack;

import com.agencyBack.entity.Good;
import com.agencyBack.entity.Owner;
import com.agencyBack.entity.Visit;
import com.agencyBack.repository.OwnerRepository;
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
    public CommandLineRunner demo(GoodService goodService, OwnerRepository ownerRepository, VisitService visitService){
        return args -> {
        	Good good= new Good();
        	Owner owner = new Owner();
        	Visit visit = new Visit();
        	owner.setName("Ismail");
        	good.setPrice(151351f);
        	good.setOwner(owner);
        	owner.setId(1l);
        	visit.setId(1l);
        	visit.setGood(good);
        	ownerRepository.save(owner);
        	goodService.create(good);
        	visitService.create(visit);
        	
        };
    }
}
