package com.agencyBack.service;

import com.agencyBack.entity.Client;
import com.agencyBack.entity.Good;

import javassist.NotFoundException;


public interface ClientService extends UserService {
	
	
	public void addDesiredCodeToListDesired (Client client, String code);
	
	public void deleteDesiredCodeFromListDesired(Client client, String code);
	
	
	public Good findDesiredGoodsByName(Client client, String nameGood);
	
	public void addDesiredGoodToListDesired(Client client, Good good) throws NotFoundException;
	
	public void deleteDesiredGoodFromListDesired(Client client, Good good) throws NotFoundException;

}
