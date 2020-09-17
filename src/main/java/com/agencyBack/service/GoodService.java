package com.agencyBack.service;

import com.agencyBack.entity.Good;

public interface GoodService extends BaseService<Good>{
	
    public Good findGoodByName(String name);
}
