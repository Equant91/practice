package com.equant.practice.dao.handbook;

import com.equant.practice.model.Country;
import com.equant.practice.model.DocumentType;

import java.util.List;

public interface HandBookDao {
    /*Dao для работы с Country и DocumentType*/


    /*Получить DocumentType по id*/
    DocumentType loadDocById(long id);


    /*Получить все объекты DocumentType*/
    List<DocumentType> allDocument();

    /*Получить DocumentType по id*/
    Country loadCountryById(long id);


    /*Получить все объекты DocumentType*/
    List<Country> allCountry();


}
