package com.equant.practice.controller;

import com.equant.practice.model.Country;
import com.equant.practice.model.Document;
import com.equant.practice.model.Office;
import com.equant.practice.service.handbook.HandBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    public  List<Document> getAllDocument(){
        List<Document> documents = handBookService.getAllDocument();
        return documents;
}
    @RequestMapping(path = "/countries", method = RequestMethod.GET)
    public  List<Country> getAllCounties(){
        List<Country> countries = handBookService.getAllCountry();
        return countries;
    }
}
