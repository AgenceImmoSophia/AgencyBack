package com.agencyBack.service;

import java.util.List;

import com.agencyBack.entity.Good;

public interface ClientService extends UserService {
	
	public Iterable<String> findAllDesiredCode();
	
	public void addDesiredCodeToListDesired (List<String> listCode, String code);
	
	public void editDesiredListCode(List<String> listCode, String code);
	
	public void deleteDesiredCodeFromListDesired(List<String> listCode, String code);
	
	
	public void findDesiredGoodsByName(String nameGood);
	
	public Iterable<Good> findAllDesiredGoods();
	
	public void addDesiredGoodToListDesired(List<Good> listGood, Good good);
	
	public void deleteDesiredGoodFromListDesired(List<Good> listGood, Good good);

}
