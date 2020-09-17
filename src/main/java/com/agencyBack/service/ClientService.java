package com.agencyBack.service;

import java.util.List;

import com.agencyBack.entity.Good;

public interface ClientService extends UserService {

	public Iterable<String> findAllDesiredCode();

	public void addDesiredCodeToListDesired (List<String> listCode, String code);

	public void editDesiredListCode(List<String> listCode, String code);

	public void addDesiredCodeToListDesiredCode(Client client, String code);

	public void deleteDesiredCodeFromListDesiredCode(Client client, String code);

	public void findDesiredGoodsByName(String nameGood);

	public Iterable<Good> findAllDesiredGoods();

	public void addDesiredGoodToListDesiredGood(Client client, Good good) throws NotFoundException;

	public void deleteDesiredGoodFromListDesiredGood(Client client, Long id) throws NotFoundException;

}
