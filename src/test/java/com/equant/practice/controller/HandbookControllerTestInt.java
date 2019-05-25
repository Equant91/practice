package com.equant.practice.controller;

import com.equant.practice.PracticeApplication;
import com.equant.practice.model.Country;
import com.equant.practice.model.DocumentType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = PracticeApplication.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class HandbookControllerTestInt {
    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void getAllDocument() {
        WrapperForDocument wrapperReq = restTemplate.getForObject("http://localhost:8888/api/docs", WrapperForDocument.class);
        Assert.assertEquals(wrapperReq, getAllDocuments());
    }

    @Test
    public void getAllCounties() {
        WrapperForCountry wrapperReq = restTemplate.getForObject("http://localhost:8888/api/countries", WrapperForCountry.class);
        Assert.assertEquals(wrapperReq, getAllCountry());
    }


    private WrapperForDocument getAllDocuments() {
        List<DocumentType> documentTypes = new ArrayList<>();

        DocumentType documentType1 = new DocumentType();
        documentType1.setDocCode(3L);
        documentType1.setDocName("Свидетельство о рождение");
        documentTypes.add(documentType1);
        DocumentType documentType2 = new DocumentType();
        documentType2.setDocCode(7L);
        documentType2.setDocName("Военный билет");
        documentTypes.add(documentType2);
        return new WrapperForDocument(documentTypes);
    }

    private WrapperForCountry getAllCountry() {
        List<Country> countries = new ArrayList<>();
        Country country1 = new Country();
        country1.setCitizenshipCode("643");
        country1.setCitizenshipName("Российская Федерация");
        countries.add(country1);
        Country country2 = new Country();
        country2.setCitizenshipCode("32");
        country2.setCitizenshipName("Аргентина");
        countries.add(country2);
        return new WrapperForCountry(countries);
    }


    @lombok.Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class WrapperForCountry {
        List<Country> data;
    }

    @lombok.Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class WrapperForDocument {
        List<DocumentType> data;
    }
}