package com.equant.practice.controller;

import com.equant.practice.dto.country.CountryDTO;
import com.equant.practice.dto.document.DocumentDTO;
import com.equant.practice.service.handbook.HandBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class HandbookController {

    @Autowired
    HandBookService handBookService;


    @RequestMapping(path = "/docs", method = RequestMethod.GET)
    public  List<DocumentDTO> getAllDocument(){
        List<DocumentDTO> documents = handBookService.getAllDocument();
        return documents;
}
    @RequestMapping(path = "/countries", method = RequestMethod.GET)
    public  List<CountryDTO> getAllCounties(){
        List<CountryDTO> countries = handBookService.getAllCountry();
        return countries;
    }
}
