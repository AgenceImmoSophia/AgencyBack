package com.agencyBack.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.agencyBack.entity.Good;
import com.agencyBack.entity.Owner;
import com.agencyBack.repository.OwnerRepository;
import com.agencyBack.service.GoodService;
import com.agencyBack.service.OwnerService;


import javassist.NotFoundException;

@Service
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
		System.out.println(nameGood);
		
		Good goodToFind = this.goodService.findGoodByName(nameGood);
		System.out.println("affiche qq chose");
		if (owner.getListOwnedGood().contains(goodToFind)) { 
			return goodToFind;
		}
		// TODO Exception if null ou if no contains in listOwner
		return null;
	}

	@Override
	public void addOwnedGoodInListOwnedGood(Owner owner, Good good) throws NotFoundException {
		Good goodToAdd = this.goodService.getById(good.getId());
		if (goodToAdd == null) {
			List<Good> listOwnedGood = owner.getListOwnedGood();
			listOwnedGood.add(goodToAdd);
			owner.setListOwnedGood(listOwnedGood);
		}
		else {
		 // TODO gérer ici un good already exist exception
		}
	}

	@Override
	public void deleteOwnedGoodFromListOwnedGood(Owner owner, Good good) throws NotFoundException {
		Good goodToDelete = this.goodService.getById(good.getId());
		if (goodToDelete != null) {
			List<Good> listOwnedGood = owner.getListOwnedGood();
			listOwnedGood.remove(goodToDelete);
			owner.setListOwnedGood(listOwnedGood);
		}
		else {
		 // TODO gérer ici un good no exists exception
		}
		
	}

	
		
}


