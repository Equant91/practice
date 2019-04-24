package com.equant.practice.controller;

import com.equant.practice.ResponseView;
import com.equant.practice.model.Organization;
import com.equant.practice.service.organization.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping(path = "/{id:[\\d]+}", method = RequestMethod.GET)
    public Organization getById(@PathVariable("id") long id ){
       Organization organization = organizationService.findByID(id);
        if(organization == null){
            throw  new RuntimeException("Not found organization with this id");
        }
        return organization;
    }

    @RequestMapping(path = "/list", method = RequestMethod.POST)
    public Organization getByName(@RequestBody Organization orgRequest){
     Organization organization = organizationService.findByName(orgRequest.getName());
    if(organization == null){
            throw  new RuntimeException("Not found organization with this id");
        }
        return organization;
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ResponseView update(@RequestBody Organization organization){
        return organizationService.update(organization);
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public ResponseView add(@RequestBody Organization organization){
        return organizationService.add(organization);
    }
    }

