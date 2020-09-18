package com.agencyBack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agencyBack.entity.Good;
import com.agencyBack.entity.Owner;
import com.agencyBack.exception.GoodAlreadyInListException;
import com.agencyBack.exception.GoodNotInListException;
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
	public Iterable<Good> findAllOwnedGoods(Owner owner) {
		return owner.getListOwnedGood();
	}
	
	@Override
	public Good findOwnedGoodsByNameFromOwnedGoods(Owner owner, String nameGood) throws GoodNotInListException, NotFoundException {
		try {
			Good goodToFind = this.goodService.findGoodByName(nameGood);
			if (goodToFind!=null) {
				try {
					if (owner.getListOwnedGood().contains(goodToFind)) {
						return goodToFind;
					} else {
						throw new GoodNotInListException();
					}
				} catch (GoodNotInListException gnile) {
				gnile.printStackTrace();
				}
			} else {
				throw new NotFoundException("This good does not exist");
			}
		} catch (NotFoundException nfe) {
			nfe.printStackTrace();
			nfe.getMessage();
		}
		return null;
	}

	@Override
	public void addOwnedGoodToListOwnedGood(Owner owner, Good good) throws GoodAlreadyInListException {
		try {
			List<Good> listOwnedGood = owner.getListOwnedGood();
			if (listOwnedGood.contains(good)) {
				throw new GoodAlreadyInListException();
			} else {
				listOwnedGood.add(good);
				owner.setListOwnedGood(listOwnedGood);
			}
		} catch (GoodAlreadyInListException gaile) {
			gaile.printStackTrace();
		}
	}

	@Override
	public void deleteOwnedGoodFromListOwnedGood(Owner owner, Long goodid) throws GoodNotInListException, NotFoundException {
		try {
			Good goodToDelete = this.goodService.getById(goodid);
			if (goodToDelete != null) {
				try {
					List<Good> listOwnedGood = owner.getListOwnedGood();
					if (listOwnedGood.contains(goodToDelete)) {
						listOwnedGood.remove(goodToDelete);
						owner.setListOwnedGood(listOwnedGood);
					} else {
						throw new GoodNotInListException();
					}
				} catch (GoodNotInListException gnile) {
					gnile.printStackTrace();
				}
			}
			else {
			 throw new NotFoundException("This good does not exist");
			}	
		} catch (NotFoundException nfe) {
			nfe.printStackTrace();
			nfe.getMessage();
		}
	}
}
