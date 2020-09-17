package com.agencyBack.service;

import com.agencyBack.entity.Good;
import com.agencyBack.entity.Owner;

import javassist.NotFoundException;

public interface OwnerService extends UserService{
	
	public Good findOwnedGoodsByNameFromOwnedGoods(Owner owner,String nameGood);
	
	public void addOwnedGoodToListOwnedGood(Owner owner, Good good) throws NotFoundException;
	
	public void deleteOwnedGoodFromListOwnedGood(Owner owner, Long id) throws NotFoundException;

}
