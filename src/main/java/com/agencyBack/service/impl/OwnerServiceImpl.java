package com.agencyBack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencyBack.entity.Good;
import com.agencyBack.repository.OwnerRepository;
import com.agencyBack.service.GoodService;
import com.agencyBack.service.OwnerService;


import javassist.NotFoundException;

@Service
public class OwnerServiceImpl extends UserServiceImpl implements OwnerService {

	//ATTRIBUTES
	@Autowired
	private GoodService goodService;

	//CONSTRUCTORS
	public OwnerServiceImpl(OwnerRepository ownerRepository) {
		super(ownerRepository);
	}


	//METHODS
	@Override
	@Override
	public Iterable<Good> findAllOwnedGoods() {
		// TODO Auto-generated method stub
		return null;
	}

	public Good findOwnedGoodsByNameFromOwnedGoods(Owner owner, String nameGood) {
		Good goodToFind = this.goodService.findGoodByName(nameGood);
		if (owner.getListOwnedGood().contains(goodToFind)) {
			return goodToFind;
		}
		// TODO Exception if null ou if no contains in listOwner
		return goodToFind;
	}

	@Override
	public void addOwnedGoodToListOwnedGood(Owner owner, Good good) throws NotFoundException {
		Good goodToAdd = this.goodService.getById(good.getId());
		List<Good> listOwnedGood = owner.getListOwnedGood();
		listOwnedGood.add(goodToAdd);
		owner.setListOwnedGood(listOwnedGood);
		 // TODO gérer ici un good already exist exception
	}

	@Override
	public void deleteOwnedGoodFromListOwnedGood(Owner owner, Long goodid) throws NotFoundException {
		Good goodToDelete = this.goodService.getById(goodid);
		if (goodToDelete != null) {
			List<Good> listOwnedGood = owner.getListOwnedGood();
			listOwnedGood.remove(goodToDelete);
			owner.setListOwnedGood(listOwnedGood);
		}
		else {
		 // TODO gérer ici un good no exists exception
		}	
	}

	@Override
	public void editOwnedGoodFromListOwnedGood(List<Good> listGood, Good good) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOwnedGoodFromListOwnedGood(List<Good> listGood, Good good) {
		// TODO Auto-generated method stub

	}
}
