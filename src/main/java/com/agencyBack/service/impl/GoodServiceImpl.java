package com.agencyBack.service.impl;

import com.agencyBack.entity.Good;
import com.agencyBack.repository.GoodRepository;
import com.agencyBack.service.GoodService;
import org.springframework.stereotype.Service;

@Service
public class GoodServiceImpl extends BaseServiceImpl<Good> implements GoodService {
    private GoodRepository goodRepository;

    public GoodServiceImpl(GoodRepository goodRepository) {
        super(goodRepository, new Good());
    }

    @Override
    public Good findGoodByName(String name) {
        Good foundGood= this.goodRepository.findGoodByName(name);
        return foundGood;
    }
}
