package com.agencyBack.service.impl;

import java.util.List;

import com.agencyBack.entity.Good;
import com.agencyBack.repository.ClientRepository;
import com.agencyBack.service.ClientService;
import com.agencyBack.service.GoodService;

public class ClientServiceImpl extends UserServiceImpl implements ClientService {

	//ATTRIBUTES 
	private GoodService goodService;
		
	//CONSTRUCTORS
	public ClientServiceImpl(ClientRepository clientRepository) {
		super(clientRepository);
	}
	
	//METHODS
	@Override
	public Iterable<String> findAllDesiredCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDesiredCodeToListDesired(List<String> listCode, String code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editDesiredListCode(List<String> listCode, String code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDesiredCodeFromListDesired(List<String> listCode, String code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findDesiredGoodsByName(String nameGood) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Good> findAllDesiredGoods() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDesiredGoodToListDesired(List<Good> listGood, Good good) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDesiredGoodFromListDesired(List<Good> listGood, Good good) {
		// TODO Auto-generated method stub
		
	}	

}
