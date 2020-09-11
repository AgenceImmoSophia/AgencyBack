package com.agencyBack;

import com.agencyBack.entity.Good;
import com.agencyBack.entity.Owner;
import com.agencyBack.repository.OwnerRepository;
import com.agencyBack.service.GoodService;
import com.agencyBack.service.OwnerService;
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
    public CommandLineRunner demo(GoodService goodService, OwnerService ownerService, OwnerRepository ownerRepository){
        return args -> {
        	Good good= new Good();
        	Owner owner = new Owner();
        	owner.setName("Ismail");
        	good.setPrice(151351f);
        	good.setOwner(owner);
        	owner.setId(1l);
        	ownerRepository.save(owner);
        	goodService.create(good);
        };
    }
}
