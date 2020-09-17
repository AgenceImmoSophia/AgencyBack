package com.agencyBack.service;

import org.springframework.stereotype.Service;

import com.agencyBack.entity.Good;


public interface GoodService extends BaseService<Good>{
    Good findGoodByName(String name);
}
