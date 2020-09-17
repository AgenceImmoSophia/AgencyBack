package com.agencyBack.service;

import java.util.List;

import com.agencyBack.entity.Good;

public interface OwnerService extends UserService{

	public void findOwnedGoodsByName(String nameGood);

	public Iterable<Good> findAllOwnedGoods();

	public void createOwnedGoodInListOwnedGood(List<Good> listGood, Good good);

	public void addOwnedGoodToListOwnedGood(Owner owner, Good good) throws NotFoundException;

	public void deleteOwnedGoodFromListOwnedGood(Owner owner, Long id) throws NotFoundException;

}
