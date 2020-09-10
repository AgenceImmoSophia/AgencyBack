package com.agencyBack.service.impl;

import com.agencyBack.entity.Address;
import com.agencyBack.repository.AddressRepository;
import com.agencyBack.service.AddressService;

public class AddressServiceImpl extends BaseServiceImpl<Address> implements AddressService {
	
	public AddressServiceImpl(AddressRepository addressRepository) {
		super(addressRepository, new Address());
	}

}
