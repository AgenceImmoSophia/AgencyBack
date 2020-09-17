package com.agencyBack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
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
	public void addDesiredCodeToListDesiredCode(Client client, String code) {
		List<String> listDesiredCode = client.getListCode();
		listDesiredCode.add(code);
		client.setListCode(listDesiredCode);
	}

	@Override
	public void deleteDesiredCodeFromListDesiredCode(Client client, String code) {
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
	public Iterable<Good> findAllDesiredGoods() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addDesiredGoodToListDesiredGood(Client client, Good good) throws NotFoundException {
		Good goodToAdd = this.goodService.getById(good.getId());

		List<Good> listDesiredGood = client.getListDesiredGood();
		listDesiredGood.add(goodToAdd);
		client.setListDesiredGood(listDesiredGood);
		 // TODO gérer ici un good already exist exception
	 }

	@Override
	public void deleteDesiredGoodFromListDesiredGood(Client client, Long goodid) throws NotFoundException {
		Good goodToDelete = this.goodService.getById(goodid);

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
