package com.agencyBack.service;

import java.util.List;

import com.agencyBack.entity.Good;
import com.agencyBack.entity.Owner;

public interface GoodService extends BaseService<Good>{

    public Good findGoodByName(String name);
    
    public List<Good> findGoodByOwner(Owner owner);
    
    public List<Good> findAllByOrderByIdAsc();
    
    public void generateCode(Good good);
}
