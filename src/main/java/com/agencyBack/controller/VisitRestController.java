package com.agencyBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.agencyBack.entity.Visit;
import com.agencyBack.service.VisitService;

import javassist.NotFoundException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
