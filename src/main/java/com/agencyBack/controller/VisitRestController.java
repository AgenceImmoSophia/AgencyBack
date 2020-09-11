package com.agencyBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agencyBack.entity.Visit;
import com.agencyBack.service.VisitService;

import javassist.NotFoundException;

@RestController
public class VisitRestController {

	@Autowired
	private VisitService visitService;
	
	@RequestMapping(value = "/addvisit", method = RequestMethod.POST)
	public Visit addVisit(@RequestBody Visit visit) {
		return visitService.create(visit);
	}
	
	@RequestMapping("/deletevisit/{id}")
	public void deleteVisit(@PathVariable("id")Long id) throws NotFoundException {
		visitService.deleteById(id);
	}
	
	@RequestMapping("/visit/{id}")
	public Visit findVisitById(@PathVariable("id")Long id) throws NotFoundException {
		return visitService.getById(id);
	}
	
	@RequestMapping("/allvisits")
	public List<Visit> findAllVisits() {
		return visitService.getAll();
	}

}
