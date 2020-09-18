package com.agencyBack.service;

import com.agencyBack.entity.Client;
import com.agencyBack.entity.Good;
import com.agencyBack.exception.CodeAlreadyInListException;
import com.agencyBack.exception.CodeNotInListException;
import com.agencyBack.exception.GoodAlreadyInListException;
import com.agencyBack.exception.GoodNotInListException;

import javassist.NotFoundException;

public interface ClientService extends UserService {

	public Iterable<String> findAllDesiredCode(Client client);

	public void addDesiredCodeToListDesiredCode(Client client, String code) throws CodeAlreadyInListException;

	public void deleteDesiredCodeFromListDesiredCode(Client client, String code) throws CodeNotInListException;

	public Good findDesiredGoodsByName(Client client, String nameGood) throws GoodNotInListException, NotFoundException;

	public Iterable<Good> findAllDesiredGoods(Client client);

	public void addDesiredGoodToListDesiredGood(Client client, Good good) throws GoodAlreadyInListException;

	public void deleteDesiredGoodFromListDesiredGood(Client client, Long id) throws GoodNotInListException, NotFoundException;

}
