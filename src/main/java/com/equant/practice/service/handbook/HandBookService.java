package com.equant.practice.service.handbook;

import com.equant.practice.model.Country;
import com.equant.practice.model.Document;

import java.util.List;

public interface HandBookService {
    List<Document> getAllDocument();
    List<Country> getAllCountry();
}
