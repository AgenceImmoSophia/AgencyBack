package com.agencyBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agencyBack.entity.Address;
import com.agencyBack.entity.Client;
import com.agencyBack.entity.EstateAgent;
import com.agencyBack.entity.Good;
import com.agencyBack.entity.Owner;
import com.agencyBack.entity.Users;
import com.agencyBack.exception.CodeAlreadyInListException;
import com.agencyBack.exception.CodeNotInListException;
import com.agencyBack.exception.GoodAlreadyInListException;
import com.agencyBack.exception.GoodNotInListException;
import com.agencyBack.exception.UserAlreadyExistException;
import com.agencyBack.service.AddressService;
import com.agencyBack.service.ClientService;
import com.agencyBack.service.EstateAgentService;
import com.agencyBack.service.OwnerService;
import com.agencyBack.service.impl.UserServiceImpl;

import javassist.NotFoundException;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UserRestController {
	
	@Autowired
	private  UserServiceImpl userServiceImpl;
	@Autowired
	private OwnerService ownerService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private EstateAgentService estateAgentService;
	@Autowired
	private AddressService addressService;
	
	public UserRestController(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	

	
	@GetMapping("/{id}")
    public Users findUserById(@PathVariable("id") Long id) throws NotFoundException {
        Users UserToFind = this.userServiceImpl.getById(id);
        return UserToFind;
    }
	
	@PostMapping(value = "/estateagent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Users findEstateAgentByUsername(@RequestBody String username) throws NotFoundException {
        EstateAgent estateAgentToFind = this.estateAgentService.findEstateAgentByUsername(username);
        return estateAgentToFind;
    }
    
    @GetMapping("/allUsers")
    public Iterable<Users> findAllUsers() {
        return this.userServiceImpl.getAll();
    }
	
	
	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> createUser(@RequestBody Users user) throws UserAlreadyExistException {
        try {
        	List<Users> allUsers = this.userServiceImpl.getAll();
        	
        	if ( !allUsers.contains(user)) {
        		Address addressUser = user.getAddress();
    			
    			List<Address> listExistingAddress = this.addressService.getAll();
    			
    			Address addressExisting = new Address();
    			int counterAddress = 0;
    			for ( int a = 0; a < listExistingAddress.size(); a++) {
    				addressExisting.setCountry(listExistingAddress.get(a).getCountry());
    				addressExisting.setCity(listExistingAddress.get(a).getCity());
    				addressExisting.setStreet(listExistingAddress.get(a).getStreet());
    				addressExisting.setStreetNber(listExistingAddress.get(a).getStreetNber());
    				addressExisting.setZipcode(listExistingAddress.get(a).getZipcode());

    				if ( addressUser.equals(addressExisting) ) {
    					user.setAddress(listExistingAddress.get(a));
    					this.userServiceImpl.create(user);
    					return new ResponseEntity<>(user, HttpStatus.CREATED);
    				}
    				
    				counterAddress = a+1;
    			}
    			
    			if ( counterAddress >= listExistingAddress.size()) {
    				addressUser.setId(null);
    				user.setAddress(addressUser);
    				this.addressService.create(addressUser);
    				this.userServiceImpl.create(user);
    				return new ResponseEntity<>(user, HttpStatus.CREATED);
    			}
        	}
        	else {
        		throw new UserAlreadyExistException("This user already exists");
        	}
        } catch (UserAlreadyExistException uaee) {
        	uaee.printStackTrace();
        	uaee.getMessage();
        }
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
	
	


	@PostMapping(value = "/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void editUserById(@RequestBody Users user, @PathVariable("id") Long id) throws NotFoundException {
		user.setId(id);
		
		Address addressUser = user.getAddress();
		
		List<Address> listExistingAddress = this.addressService.getAll();
		
		Address addressExisting = new Address();
		int counterAddress = 0;
		for ( int a = 0; a < listExistingAddress.size(); a++) {
			addressExisting.setCountry(listExistingAddress.get(a).getCountry());
			addressExisting.setCity(listExistingAddress.get(a).getCity());
			addressExisting.setStreet(listExistingAddress.get(a).getStreet());
			addressExisting.setStreetNber(listExistingAddress.get(a).getStreetNber());
			addressExisting.setZipcode(listExistingAddress.get(a).getZipcode());

			if ( addressUser.equals(addressExisting) ) {
				user.setAddress(listExistingAddress.get(a));
				this.userServiceImpl.edit(user);
				return;
			}
			counterAddress = a+1;
		}
		
		if ( counterAddress >= listExistingAddress.size()) {
			addressUser.setId(null);
			user.setAddress(addressUser);
			this.addressService.create(addressUser);
			this.userServiceImpl.edit(user);
			return;
		}		
    }
	
	
	// Cannot delete any user tagged in a contract, good, or visit, or with a list of goods as it creates foreign key conflicts
	@DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable("id") Long id) throws NotFoundException {
            this.userServiceImpl.deleteById(id);
    }
	
	@GetMapping("{userid}/myGood/{namegood}")
	public Good findGoodByNameFromList ( @PathVariable("userid") Long id, @PathVariable("namegood") String nameGood) throws NotFoundException, GoodNotInListException {
		Users user = this.userServiceImpl.getById(id);
		
		if (user.getClass() == Owner.class) {
			Owner owner = (Owner) user;
			Good goodToFind = this.ownerService.findOwnedGoodsByNameFromOwnedGoods(owner, nameGood);
	        return goodToFind ;
		}
		else if (user.getClass() == Client.class) {
			Client client = (Client) user;
			Good goodToFind = this.clientService.findDesiredGoodsByName(client, nameGood);
	        return goodToFind ;
		} else {
			return null; // If user is neither client nor owner, no list of Goods attribute 	
		}
	}
	
	@PostMapping(value = "{userid}/addGoodToList", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addGoodToList(@PathVariable("userid") Long id, @RequestBody Good good) throws GoodAlreadyInListException, NotFoundException {
		Users user = this.userServiceImpl.getById(id);
		
		if (user.getClass() == Owner.class) {
			Owner owner = (Owner) user;
			this.ownerService.addOwnedGoodToListOwnedGood(owner, good);
			this.ownerService.edit(owner);
		}
		else if (user.getClass() == Client.class) {
			Client client = (Client) user;
			this.clientService.addDesiredGoodToListDesiredGood(client, good);
			this.clientService.edit(client);
		}
		// Gérer exception si ni owner et client 
	}
	
	@DeleteMapping("{userid}/deleteGoodFromList/{goodid}")
    public void deleteGoodFromList(@PathVariable("userid") Long userid, @PathVariable("goodid") Long goodid) throws GoodNotInListException, NotFoundException {
		Users user = this.userServiceImpl.getById(userid);
		if (user.getClass() == Owner.class) {
			Owner owner = (Owner) user;
			this.ownerService.deleteOwnedGoodFromListOwnedGood(owner, goodid); 
			this.ownerService.edit(owner);
		}
		else if (user.getClass() == Client.class) {
			Client client = (Client) user;
			this.clientService.deleteDesiredGoodFromListDesiredGood(client, goodid);
			this.clientService.edit(client);
		}
		// Gérer exception si ni owner et client 
	}
	

	@PostMapping(value = "{clientid}/addCodeToList", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addCodeToList(@PathVariable("clientid") Long clientid, @RequestBody String code) throws NotFoundException, CodeAlreadyInListException {
		Users user = this.userServiceImpl.getById(clientid);
		if (user.getClass() == Client.class) {
			Client client = (Client) user;
			this.clientService.addDesiredCodeToListDesiredCode(client, code);   
			this.clientService.edit(client);
		 }
		// Gérer exception 
	}
	
	@PostMapping(value = "{clientid}/deleteCodeFromList", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCodeFromList(@PathVariable("clientid") Long clientid, @RequestBody String code) throws NotFoundException, CodeNotInListException {
		Users user = this.userServiceImpl.getById(clientid);
		if (user.getClass() == Client.class) {
			Client client = (Client) user;
			this.clientService.deleteDesiredCodeFromListDesiredCode(client, code);
			this.clientService.edit(client);
		}
		// Gérer exception 
	}
}
