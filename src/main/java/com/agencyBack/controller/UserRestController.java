package com.agencyBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.agencyBack.service.AddressService;
import com.agencyBack.service.ClientService;
import com.agencyBack.service.EstateAgentService;
import com.agencyBack.service.OwnerService;
import com.agencyBack.service.UserService;
import com.agencyBack.service.impl.UserServiceImpl;

import javassist.NotFoundException;


@RestController
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

    
    @GetMapping("/allUsers")
    public Iterable<Users> findAllUsers() {
        return this.userServiceImpl.getAll();
    }
	
	
	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
//        try {
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
				
			return new ResponseEntity<>(user, HttpStatus.CREATED);
//        } catch (UserAlreadyExistException e) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).build();
//        }
    }
	
	


	@PostMapping(value = "/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void editUserById(@RequestBody Users user, @PathVariable("id") Long id) throws NotFoundException {
//        try {
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
//        } catch (UserNotFoundException e) {
//            e.printStackTrace();
//        }
    }
	
	
	// Cannot delete any user tagged in a contract, good, or visit, or with a list of goods as it creates foreign key conflicts
	@DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable("id") Long id) throws NotFoundException {
//        try {
            this.userServiceImpl.deleteById(id);
//        } catch (ProductNotFoundException e) {
//            e.printStackTrace();
//        }
    }
	
	@GetMapping("{userid}/myGood/{namegood}")
	public Good findGoodByNameFromList ( @PathVariable("userid") Long id, @PathVariable("namegood") String nameGood) throws NotFoundException {
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
//	
//	@PostMapping(value = "/addGoodList", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public void addGoodInList(@RequestBody User user, @RequestBody Good good) throws NotFoundException {
//		if (user.getClass() == Owner.class) {
//			Owner owner = (Owner) user;
//			this.ownerServiceImpl.addOwnedGoodInListOwnedGood(owner, good);
//	        
//		}
//		else if (user.getClass() == Client.class) {
//			Client client = (Client) user;
//			this.clientServiceImpl.addDesiredGoodToListDesired(client, good);
//		}
//		// Gérer exception si ni owner et client 
//	}
//	
//	@DeleteMapping("/deleteGoodList")
//    public void deleteGoodList(@RequestBody User user, @RequestBody Good good) throws NotFoundException {
//		if (user.getClass() == Owner.class) {
//			Owner owner = (Owner) user;
//			this.ownerServiceImpl.deleteOwnedGoodFromListOwnedGood(owner, good); 
//		}
//		else if (user.getClass() == Client.class) {
//			Client client = (Client) user;
//			this.clientServiceImpl.deleteDesiredGoodFromListDesired(client, good);
//		}
//		// Gérer exception si ni owner et client 
//	}
//	
//
//	@PostMapping(value = "/addCodeList", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public void addCodeInList(@RequestBody Client client, String code) {
//		this.clientServiceImpl.addDesiredCodeToListDesired(client, code);     
//		// Gérer exception 
//	}
//	
//	@DeleteMapping("/deleteCodeList")
//    public void deleteCodeList(@RequestBody Client client, String code) {
//		this.clientServiceImpl.deleteDesiredCodeFromListDesired(client, code);
//		// Gérer exception 
//	}
}
