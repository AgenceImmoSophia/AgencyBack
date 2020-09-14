package com.agencyBack.controller;

import com.agencyBack.entity.Good;
import com.agencyBack.service.GoodService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoodRestController {
    private final GoodService goodService;

    public GoodRestController (GoodService goodService){
        this.goodService = goodService;
    }

    @GetMapping(value = "/good/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Good findGoodById(@PathVariable("id") Long id) throws NotFoundException {
        return this.goodService.getById(id);
    }

    @GetMapping(value = "/goods", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Good> findAllGoods(){
        return this.goodService.getAll();
    }

    @PostMapping(value = "good", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Good> createGood(@RequestBody Good good){
        this.goodService.create(good);
        this.goodService.generateCode(good);
        return new ResponseEntity<>(good, HttpStatus.CREATED);
    }

    @DeleteMapping (value = "/good/{id}")
    public ResponseEntity<Object> deleteGood(@PathVariable("id") Long id) throws NotFoundException {
        this.goodService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
