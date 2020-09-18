package com.agencyBack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencyBack.entity.Client;
import com.agencyBack.entity.Good;
import com.agencyBack.exception.CodeAlreadyInListException;
import com.agencyBack.exception.CodeNotInListException;
import com.agencyBack.exception.GoodAlreadyInListException;
import com.agencyBack.exception.GoodNotInListException;
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
	public Iterable<String> findAllDesiredCode(Client client) {
		return client.getListCode();
	}

	@Override
	public void addDesiredCodeToListDesiredCode(Client client, String code) throws CodeAlreadyInListException {
		try {
			List<String> listDesiredCode = client.getListCode();
			if (listDesiredCode.contains(code)) {
				throw new CodeAlreadyInListException();
			} else { 
				listDesiredCode.add(code);
				client.setListCode(listDesiredCode);
			}
		} catch (CodeAlreadyInListException caile) {
			caile.printStackTrace();
			caile.getMessage();
		}
	}

	@Override
	public void deleteDesiredCodeFromListDesiredCode(Client client, String code) throws CodeNotInListException {
		try {
			List<String> listDesiredCode = client.getListCode();
			if (listDesiredCode.contains(code)) {
				listDesiredCode.remove(code);
				client.setListCode(listDesiredCode);
			} else {
				throw new CodeNotInListException();
			}
		} catch (CodeNotInListException cnile) {
			cnile.printStackTrace();
			cnile.getMessage();
		}
	}

	@Override
	public Good findDesiredGoodsByName(Client client, String nameGood) throws GoodNotInListException, NotFoundException{
		try {
			Good goodToFind = this.goodService.findGoodByName(nameGood);
			if (goodToFind!=null) {
				try {
					if (client.getListDesiredGood().contains(goodToFind)) {
						return goodToFind;
					} else {
						throw new GoodNotInListException();
					}
				} catch (GoodNotInListException gnile) {
					gnile.printStackTrace();
					gnile.getMessage();
				}
			} else {
				throw new NotFoundException("This good does not exist");
			}
		} catch (NotFoundException nfe) {
			nfe.printStackTrace();
			nfe.getMessage();
		}
		return null;
	}
		
	
	
	@Override
	public Iterable<Good> findAllDesiredGoods(Client client) {
		return client.getListDesiredGood();
	}


	@Override
	public void addDesiredGoodToListDesiredGood(Client client, Good good) throws GoodAlreadyInListException {
		try {
			List<Good> listDesiredGood = client.getListDesiredGood();
			if (listDesiredGood.contains(good)) {
				throw new GoodAlreadyInListException();
			} else {
				listDesiredGood.add(good);
				client.setListDesiredGood(listDesiredGood);
			}
		} catch (GoodAlreadyInListException gaile) {
			gaile.printStackTrace();
			gaile.getMessage();
		}
	}
	
	@Override
	public void deleteDesiredGoodFromListDesiredGood(Client client, Long goodid) throws GoodNotInListException, NotFoundException  {	
		try {
			Good goodToDelete = this.goodService.getById(goodid);
			if (goodToDelete != null) {
				try {
					List<Good> listDesiredGood = client.getListDesiredGood();
					if (listDesiredGood.contains(goodToDelete)) {
						listDesiredGood.remove(goodToDelete);
						client.setListDesiredGood(listDesiredGood);
					} else {
						throw new GoodNotInListException();
					}
				} catch (GoodNotInListException gnile) {
					gnile.printStackTrace();
					gnile.getMessage();
				}
			}
			else {
			 throw new NotFoundException("This good does not exist");
			}	
		} catch (NotFoundException nfe) {
				nfe.printStackTrace();
				nfe.getMessage();
		}
	}
}
