package com.equant.practice.dao.handbook;

import com.equant.practice.model.Country;
import com.equant.practice.model.Document;

import java.util.List;

public interface HandBookDao {
    /*Dao для работы с Country и Document*/


    /*Получить Document по id*/
    Document loadDocById(long id);


    /*Получить все объекты Document*/
    List<Document> allDocument();

    /*Получить Document по id*/
    Country loadCountryById(long id);


    /*Получить все объекты Document*/
    List<Country> allCountry();


}
