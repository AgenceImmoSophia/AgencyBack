package com.agencyBack.service.impl;

import com.agencyBack.entity.User;
import com.agencyBack.repository.UserRepository;
import com.agencyBack.service.UserService;


public class UserServiceImpl extends BaseServiceImpl<User>implements UserService{


	// CONSTRUCTORS  
    public UserServiceImpl(UserRepository userRepository) {
		super(userRepository, new User());
	}

	
}
