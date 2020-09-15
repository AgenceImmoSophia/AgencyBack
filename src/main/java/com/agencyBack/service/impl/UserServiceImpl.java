package com.agencyBack.service.impl;

import org.springframework.stereotype.Service;

import com.agencyBack.entity.User;
import com.agencyBack.repository.UserRepository;
import com.agencyBack.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {


	// CONSTRUCTORS  
    public UserServiceImpl(UserRepository userRepository) {
		super(userRepository, new User());
	}

	
}
