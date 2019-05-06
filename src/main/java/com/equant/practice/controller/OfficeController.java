package com.equant.practice.controller;

import com.equant.practice.ResponseView;
import com.equant.practice.dto.office.OfficeDTOForGet;
import com.equant.practice.dto.office.OfficeDTOForList;
import com.equant.practice.dto.office.OfficeDTORequestForAdd;
import com.equant.practice.dto.office.OfficeDTORequestForList;
import com.equant.practice.model.Office;
import com.equant.practice.service.office.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public OfficeDTOForGet getById(@PathVariable("id") long id) {
        OfficeDTOForGet office = officeService.findByID(id);
        if (office == null) {
            throw new RuntimeException("Not found office with this id" + id);
        }
        return office;
    }

    @RequestMapping(path = "/list", method = RequestMethod.POST)
    public List<OfficeDTOForList> getByOrgId(@RequestBody OfficeDTORequestForList officeDTORequestForList) {
        List<OfficeDTOForList> officeDTOForLists = officeService.findByOrgId(officeDTORequestForList);
        if (officeDTOForLists == null) {
            throw new RuntimeException("Not found office with this name");
        }
        return officeDTOForLists ;
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ResponseView update(@RequestBody OfficeDTOForGet office) {
        return officeService.update(office);
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public ResponseView add(@RequestBody OfficeDTORequestForAdd office) {
        return officeService.add(office);
    }
}



