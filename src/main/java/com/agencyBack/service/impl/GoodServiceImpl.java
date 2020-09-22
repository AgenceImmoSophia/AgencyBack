package com.agencyBack.service.impl;

import com.agencyBack.entity.Good;
import com.agencyBack.entity.Status;
import com.agencyBack.repository.GoodRepository;
import com.agencyBack.service.GoodService;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GoodServiceImpl extends BaseServiceImpl<Good> implements GoodService {

    private GoodRepository goodRepository;

    public GoodServiceImpl(GoodRepository goodRepository) {
        super(goodRepository, new Good());
        this.goodRepository = goodRepository;
    }

    @Override
    public Good findGoodByName(String name) {
        Good foundGood= this.goodRepository.findGoodByNameOfGood(name);
        return foundGood;
    }
    
    @Override
    public List<Good> findAllByOrderByIdAsc() {
    	List<Good> listOfGoods = this.goodRepository.findAllByOrderByIdAsc();
    	return listOfGoods;
    }

    @Override
    public void generateCode(Good good){
        String code;
        int firstDigit = good.getTypeOfGood().getValue();
        int secondDigit = 0;
        int thirdDigit = good.getStatus().getValue();
        int fourthDigit;

        Float price = good.getPrice();
        if (good.getStatus().equals(Status.TOSELL)){
            if (price <=200000f){
                secondDigit=1;
            } else if (price >200000f && price <= 300000f){
                secondDigit=2;
            } else if (price >300000f && price <= 400000f){
                secondDigit=3;
            } else {
                secondDigit=4;
            }
        } else if (good.getStatus().equals(Status.TORENT)){
            if (price<=200) {
                secondDigit=1;
            } else if (price>200 && price<=300){
                secondDigit=2;
            } else if (price>300 && price<=400){
                secondDigit=3;
            } else if (price>400 && price<=500){
                secondDigit=4;
            } else if (price>500 && price<=600){
                secondDigit=5;
            } else if (price>600 && price<=700){
                secondDigit=6;
            } else if (price>700 && price<=800){
                secondDigit=7;
            } else if (price>800 && price<=900){
                secondDigit=8;
            } else {
                secondDigit = 9;
            }
        }

        Float area = good.getArea();
        if (area <= 10){
            fourthDigit=1;
        } else if (area>10 && area <=30){
            fourthDigit=2;
        } else if (area>30 && area <=50){
            fourthDigit=3;
        } else if (area>50 && area <=70){
            fourthDigit=4;
        } else if (area>70 && area <=90){
            fourthDigit=5;
        } else if (area>90 && area <=110){
            fourthDigit=6;
        } else {
            fourthDigit=7;
        }

        code = Integer.toString(firstDigit) +secondDigit+ thirdDigit + fourthDigit;

        good.setCode(code);
    }
}
