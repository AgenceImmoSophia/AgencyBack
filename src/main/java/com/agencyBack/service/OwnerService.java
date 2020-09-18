package com.agencyBack.service;

import com.agencyBack.entity.Good;
import com.agencyBack.entity.Owner;
import com.agencyBack.exception.GoodAlreadyInListException;
import com.agencyBack.exception.GoodNotInListException;

import javassist.NotFoundException;

public interface OwnerService extends UserService{

	public Good findOwnedGoodsByNameFromOwnedGoods(Owner owner, String nameGood) throws GoodNotInListException, NotFoundException;

	public Iterable<Good> findAllOwnedGoods(Owner owner);

	public void addOwnedGoodToListOwnedGood(Owner owner, Good good) throws GoodAlreadyInListException;

	public void deleteOwnedGoodFromListOwnedGood(Owner owner, Long id) throws GoodNotInListException, NotFoundException;

}
