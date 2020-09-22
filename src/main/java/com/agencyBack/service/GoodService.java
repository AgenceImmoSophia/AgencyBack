package com.agencyBack.service;

import java.util.List;

import com.agencyBack.entity.Good;

public interface GoodService extends BaseService<Good>{

    public Good findGoodByName(String name);
    
    public List<Good> findAllByOrderByIdAsc();
    
    public void generateCode(Good good);
}
