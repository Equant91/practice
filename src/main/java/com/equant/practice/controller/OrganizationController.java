package com.equant.practice.controller;

import com.equant.practice.ResponseView;
import com.equant.practice.dto.organization.OrgRequest;
import com.equant.practice.dto.organization.OrganizationDTOForGetAndUpdate;
import com.equant.practice.dto.organization.OrganizationDTOForList;
import com.equant.practice.model.Organization;
import com.equant.practice.service.organization.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping(path = "/{id:[\\d]+}", method = RequestMethod.GET)
    public OrganizationDTOForGetAndUpdate getById(@PathVariable("id") long id ){
       OrganizationDTOForGetAndUpdate organization = organizationService.findByID(id);
        if(organization == null){
            throw  new RuntimeException("Not found organization with this id: " + id);
        }
        return organization;
    }

    @RequestMapping(path = "/list", method = RequestMethod.POST)
    public List<OrganizationDTOForList> getByName(@RequestBody OrgRequest orgRequest){
        List<OrganizationDTOForList> organizations = organizationService.findByName(orgRequest);
    if(organizations == null){
            throw  new RuntimeException("Not found organization with this name: " + orgRequest.getName());
        }
        return organizations;
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ResponseView update(@RequestBody OrganizationDTOForGetAndUpdate organization){
        return organizationService.update(organization);
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public ResponseView add(@RequestBody Organization organization){

        return organizationService.add(organization);
    }
    }

