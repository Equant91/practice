package com.equant.practice.controller;

import com.equant.practice.ResponseView;
import com.equant.practice.dto.office.OfficeDTOForGetAndUpdate;
import com.equant.practice.dto.office.OfficeDTOResponseForList;
import com.equant.practice.dto.office.OfficeDTORequestForAdd;
import com.equant.practice.dto.office.OfficeDTORequestForList;
import com.equant.practice.service.office.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/office")
public class OfficeController {


    private OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @RequestMapping(path = "/{id:[\\d]+}", method = RequestMethod.GET)
    public OfficeDTOForGetAndUpdate getById(@PathVariable("id") long id) {
        OfficeDTOForGetAndUpdate office = officeService.findByID(id);
        if (office == null) {
            throw new RuntimeException("Not found office with this id" + id);
        }
        return office;
    }

    @RequestMapping(path = "/list", method = RequestMethod.POST)
    public List<OfficeDTOResponseForList> getByOrgId(@Valid @RequestBody OfficeDTORequestForList officeDTORequestForList) {
        List<OfficeDTOResponseForList> officeDTOResponseForLists = officeService.findByOrgId(officeDTORequestForList);
        if (officeDTOResponseForLists == null) {
            throw new RuntimeException("Not found office with this name");
        }
        return officeDTOResponseForLists;
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ResponseView update(@Valid @RequestBody OfficeDTOForGetAndUpdate office) {
        return officeService.update(office);
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public ResponseView add(@Valid @RequestBody OfficeDTORequestForAdd office) {
        return officeService.add(office);
    }
}



