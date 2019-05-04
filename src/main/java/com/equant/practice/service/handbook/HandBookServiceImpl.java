package com.equant.practice.service.handbook;

import com.equant.practice.dao.handbook.HandBookDao;
import com.equant.practice.dto.country.CountryDTO;
import com.equant.practice.dto.document.DocumentDTO;
import com.equant.practice.mapper.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HandBookServiceImpl implements HandBookService {


    HandBookDao dao;

    MapperFacade mapperFacade;

    @Autowired
    public HandBookServiceImpl(HandBookDao dao, MapperFacade mapperFacade) {
        this.dao = dao;
        this.mapperFacade = mapperFacade;
    }


    @Override
    public List<DocumentDTO> getAllDocument() {

        return mapperFacade.mapAsList(dao.allDocument(), DocumentDTO.class);
    }

    @Override
    public List<CountryDTO> getAllCountry() {

        return mapperFacade.mapAsList(dao.allCountry(), CountryDTO.class);
    }


}
