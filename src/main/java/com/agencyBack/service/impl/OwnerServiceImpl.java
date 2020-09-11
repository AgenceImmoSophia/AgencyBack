package com.agencyBack.service.impl;

import java.util.List;

import com.agencyBack.entity.Good;
import com.agencyBack.entity.Owner;
import com.agencyBack.repository.OwnerRepository;
import com.agencyBack.service.GoodService;
import com.agencyBack.service.OwnerService;


import javassist.NotFoundException;


public class OwnerServiceImpl extends UserServiceImpl implements OwnerService {

	//ATTRIBUTES 
	private GoodService goodService;
	
	//CONSTRUCTORS
	public OwnerServiceImpl(OwnerRepository ownerRepository) {
		super(ownerRepository);
	}

	//METHODS
	@Override
	public Good findOwnedGoodsByNameFromOwnedGoods(Owner owner, String nameGood) {
		Good goodToFind = this.goodService.findGoodByName(nameGood);
		if (owner.getListGood().contains(goodToFind)) { 
			return goodToFind;
		}
		// TODO Exception if null ou if no contains in listOwner
		return goodToFind;
	}

	@Override
	public void addOwnedGoodInListOwnedGood(Owner owner, Good good) throws NotFoundException {
		Good goodToAdd = this.goodService.getById(good.getId());
		if (goodToAdd == null) {
			List<Good> listOwnedGood = owner.getListGood();
			listOwnedGood.add(goodToAdd);
			owner.setListGood(listOwnedGood);
		}
		else {
		 // TODO gérer ici un good already exist exception
		}
	}

	@Override
	public void deleteOwnedGoodFromListOwnedGood(Owner owner, Good good) throws NotFoundException {
		Good goodToDelete = this.goodService.getById(good.getId());
		if (goodToDelete != null) {
			List<Good> listOwnedGood = owner.getListGood();
			listOwnedGood.remove(goodToDelete);
			owner.setListGood(listOwnedGood);
		}
		else {
		 // TODO gérer ici un good no exists exception
		}
		
	}

	
		
}


