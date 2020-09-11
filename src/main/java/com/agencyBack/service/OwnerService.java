package com.agencyBack.service;

import java.util.List;

import com.agencyBack.entity.Good;

public interface OwnerService extends UserService{
	
	public void findOwnedGoodsByName(String nameGood);
	
	public Iterable<Good> findAllOwnedGoods();
	
	public void createOwnedGoodInListOwnedGood(List<Good> listGood, Good good);
	
	public void editOwnedGoodFromListOwnedGood(List<Good> listGood, Good good);
	
	public void deleteOwnedGoodFromListOwnedGood(List<Good> listGood, Good good);

}
