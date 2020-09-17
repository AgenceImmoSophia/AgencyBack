package com.agencyBack.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;

import com.agencyBack.entity.Client;
import com.agencyBack.entity.Good;
import com.agencyBack.repository.ClientRepository;
import com.agencyBack.service.ClientService;
import com.agencyBack.service.GoodService;

import javassist.NotFoundException;

@Service
public class ClientServiceImpl extends UserServiceImpl implements ClientService {

	//ATTRIBUTES 
	private GoodService goodService;
		
	//CONSTRUCTORS
	public ClientServiceImpl(ClientRepository clientRepository) {
		super(clientRepository);
	}

	
	//METHODS
	@Override
	public void addDesiredCodeToListDesired(Client client, String code) {
		List<String> listDesiredCode = client.getListCode();
		listDesiredCode.add(code);
		client.setListCode(listDesiredCode);
	}


	@Override
	public void deleteDesiredCodeFromListDesired(Client client, String code) {
		List<String> listDesiredCode = client.getListCode();
		listDesiredCode.remove(code);
		client.setListCode(listDesiredCode);		
	}

	@Override
	public Good findDesiredGoodsByName(Client client, String nameGood) {
		Good goodToFind = this.goodService.findGoodByName(nameGood);
		if (client.getListDesiredGood().contains(goodToFind)) { 
			return goodToFind;
		}
		// TODO Exception if null ou if no contains in listOwner
		return goodToFind;
	}

	@Override
	public void addDesiredGoodToListDesired(Client client, Good good) throws NotFoundException {
		Good goodToAdd = this.goodService.getById(good.getId());
		if (goodToAdd == null) {
			List<Good> listDesiredGood = client.getListDesiredGood();
			listDesiredGood.add(goodToAdd);
			client.setListDesiredGood(listDesiredGood);
		}
		else {
		 // TODO gérer ici un good already exist exception
		}
		
	}

	@Override
	public void deleteDesiredGoodFromListDesired(Client client, Good good) throws NotFoundException {
		Good goodToDelete = this.goodService.getById(good.getId());
		if (goodToDelete != null) {
			List<Good> listDesiredGood = client.getListDesiredGood();
			listDesiredGood.remove(goodToDelete);
			client.setListDesiredGood(listDesiredGood);
		}
		else {
		 // TODO gérer ici un good no exists exception
		}
		
	}


	
	
	
		

}
