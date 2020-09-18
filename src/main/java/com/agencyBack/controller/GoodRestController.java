package com.agencyBack.controller;

import com.agencyBack.entity.Address;
import com.agencyBack.entity.Good;
import com.agencyBack.service.AddressService;
import com.agencyBack.service.GoodService;
import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GoodRestController {
	
    private final GoodService goodService;
    
    @Autowired
	private AddressService addressService;

    public GoodRestController (GoodService goodService){
        this.goodService = goodService;
    }

    @GetMapping(value = "/good/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Good findGoodById(@PathVariable("id") Long id) throws NotFoundException {
        return this.goodService.getById(id);
    }

    @GetMapping(value = "/goods", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Good> findAllGoods(){
        return this.goodService.getAll();
    }

    @PostMapping(value = "good", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Good> createGood(@RequestBody Good good){
    	
    	Address addressGood = good.getAddress();
		
		List<Address> listExistingAddress = this.addressService.getAll();
		
		Address addressExisting = new Address();
		int counterAddress = 0;
		for ( int a = 0; a < listExistingAddress.size(); a++) {
			addressExisting.setCountry(listExistingAddress.get(a).getCountry());
			addressExisting.setCity(listExistingAddress.get(a).getCity());
			addressExisting.setStreet(listExistingAddress.get(a).getStreet());
			addressExisting.setStreetNber(listExistingAddress.get(a).getStreetNber());
			addressExisting.setZipcode(listExistingAddress.get(a).getZipcode());

			if ( addressGood.equals(addressExisting) ) {
				good.setAddress(listExistingAddress.get(a));
				this.goodService.generateCode(good);
				this.goodService.create(good);
		        return new ResponseEntity<>(good, HttpStatus.CREATED);
			}
			
			counterAddress = a+1;
		}
		
		if ( counterAddress >= listExistingAddress.size()) {
			addressGood.setId(null);
			good.setAddress(addressGood);
			this.addressService.create(addressGood);
			this.goodService.generateCode(good);
			this.goodService.create(good);
	        return new ResponseEntity<>(good, HttpStatus.CREATED);
		}
        return new ResponseEntity<>(good, HttpStatus.CREATED);
    }

    @DeleteMapping (value = "/good/{id}") // Can't delete if linked with owner, listDesiredGood, Visit or Client
    public ResponseEntity<Object> deleteGood(@PathVariable("id") Long id) throws NotFoundException {
        this.goodService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
