package com.agencyBack.service.impl;

import java.util.List;

import com.agencyBack.entity.Good;
import com.agencyBack.repository.OwnerRepository;
import com.agencyBack.service.GoodService;
import com.agencyBack.service.OwnerService;

public class OwnerServiceImpl extends UserServiceImpl implements OwnerService {

	//ATTRIBUTES 
	private GoodService goodService;
	
	//CONSTRUCTORS
	public OwnerServiceImpl(OwnerRepository ownerRepository) {
		super(ownerRepository);
	}

	
	//METHODS
	@Override
	public void findOwnedGoodsByName(String nameGood) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Good> findAllOwnedGoods() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createOwnedGoodInListOwnedGood(List<Good> listGood, Good good) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editOwnedGoodFromListOwnedGood(List<Good> listGood, Good good) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOwnedGoodFromListOwnedGood(List<Good> listGood, Good good) {
		// TODO Auto-generated method stub
		
	}

	
	

}
