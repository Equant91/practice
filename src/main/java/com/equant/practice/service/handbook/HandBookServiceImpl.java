package com.equant.practice.service.handbook;

import com.equant.practice.model.Country;
import com.equant.practice.model.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HandBookServiceImpl implements HandBookService {
    @Override
    public List<Document> getAllDocument() {
        List<Document> documents = new ArrayList<>();
        Document document1 = new Document();
        document1.setDoc_code(3);
        document1.setDoc_name("Свидетельство о рождение");
        documents.add(document1);
        return documents;
    }

    @Override
    public List<Country> getAllCountry() {
        List<Country> countries = new ArrayList<>();
        Country country1 = new Country();
        country1.setCitizenship_code(643);
        country1.setCitizenship_name("Российская Федерация");
        countries.add(country1);
        return countries;
    }


}
