package com.agencyBack.controller;

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
import com.agencyBack.service.impl.AddressServiceImpl;
import com.agencyBack.service.impl.ClientServiceImpl;
import com.agencyBack.service.impl.EstateAgentServiceImpl;
import com.agencyBack.service.impl.OwnerServiceImpl;
import com.agencyBack.service.impl.UserServiceImpl;

import javassist.NotFoundException;


@RestController
@RequestMapping("/users")
public class UserRestController {
	
	@Autowired
	private  UserServiceImpl userServiceImpl;
	@Autowired
	private OwnerServiceImpl ownerServiceImpl;
	@Autowired
	private ClientServiceImpl clientServiceImpl;
	@Autowired
	private EstateAgentServiceImpl estateAgentServiceImpl;
	@Autowired
	private AddressServiceImpl addressServiceImpl;
	
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
			Address address = user.getAddress();
			this.addressServiceImpl.create(address);
			
			this.userServiceImpl.create(user);
		
			return new ResponseEntity<>(user, HttpStatus.CREATED);
			
//        } catch (UserAlreadyExistException e) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).build();
//        }
    }
	
	


	@PostMapping(value = "/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void editUserById(@RequestBody Users user, @PathVariable("id") Long id) throws NotFoundException {
//        try {
		user.setId(id);
		this.userServiceImpl.edit(user);
		
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
	
//	@GetMapping("/myGood/{namegood}")
//	public Good findGoodByNameFromList (@RequestBody @Valid User user, @PathVariable("namegood") String nameGood) {
//		if (user.getClass() == Owner.class) {
//			Owner owner = (Owner) user;
//			Good goodToFind = this.ownerServiceImpl.findOwnedGoodsByNameFromOwnedGoods(owner, nameGood);
//	        return goodToFind ;
//		}
//		else if (user.getClass() == Client.class) {
//			Client client = (Client) user;
//			Good goodToFind = this.clientServiceImpl.findDesiredGoodsByName(client, nameGood);
//	        return goodToFind ;
//		}
//		return null; // Gérer exception si ni owner et client 
//		
//	}
//	
//	@PostMapping(value = "/addGoodList", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public void addGoodInList(@RequestBody @Valid User user, @RequestBody Good good) throws NotFoundException {
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
//    public void deleteGoodList(@RequestBody @Valid User user, @RequestBody Good good) throws NotFoundException {
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
//	public void addCodeInList(@RequestBody @Valid Client client, String code) {
//		this.clientServiceImpl.addDesiredCodeToListDesired(client, code);     
//		// Gérer exception 
//	}
//	
//	@DeleteMapping("/deleteCodeList")
//    public void deleteCodeList(@RequestBody @Valid Client client, String code) {
//		this.clientServiceImpl.deleteDesiredCodeFromListDesired(client, code);
//		// Gérer exception 
//	}
}
