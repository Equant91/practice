package com.equant.practice.controller;

import com.equant.practice.ResponseView;
import com.equant.practice.model.Office;
import com.equant.practice.service.office.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/office")
public class OfficeController {


        @Autowired
        private OfficeService officeService;

        @RequestMapping(path = "/{id:[\\d]+}", method = RequestMethod.GET)
        public Office getById(@PathVariable("id") long id ){
            Office office = officeService.findByID(id);
            if(office == null){
                throw  new RuntimeException("Not found office with this id");
            }
            return office;
        }

        @RequestMapping(path = "/list", method = RequestMethod.POST)
        public Office getByName(@RequestBody Office officeRequest){
            Office office = officeService.findByName(officeRequest.getName());
            if(office == null){
                throw  new RuntimeException("Not found office with this id");
            }
            return office;
        }

        @RequestMapping(path = "/update", method = RequestMethod.POST)
        public ResponseView update(@RequestBody Office office){
            return officeService.update(office);
        }

        @RequestMapping(path = "/save", method = RequestMethod.POST)
        public ResponseView add(@RequestBody Office office){
            return officeService.add(office);
        }
    }



