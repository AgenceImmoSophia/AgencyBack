package com.agencyBack.service;

import com.agencyBack.entity.Client;
import com.agencyBack.entity.Good;

import javassist.NotFoundException;

public interface ClientService extends UserService {

	public Iterable<String> findAllDesiredCode();

	public void addDesiredCodeToListDesiredCode(Client client, String code);

	public void deleteDesiredCodeFromListDesiredCode(Client client, String code);

	public Good findDesiredGoodsByName(Client client, String nameGood);

	public Iterable<Good> findAllDesiredGoods();

	public void addDesiredGoodToListDesiredGood(Client client, Good good) throws NotFoundException;

	public void deleteDesiredGoodFromListDesiredGood(Client client, Long id) throws NotFoundException;

}
