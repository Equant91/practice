package com.equant.practice.controller;

import com.equant.practice.PracticeApplication;
import com.equant.practice.model.Country;
import com.equant.practice.model.Document;
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

import static org.junit.Assert.*;

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
        List<Document> documents = new ArrayList<>();
        Document document1 = new Document();
        document1.setDocCode(3L);
        document1.setDocName("Свидетельство о рождение");
        documents.add(document1);
        return new WrapperForDocument(documents);
    }

    private WrapperForCountry getAllCountry() {
        List<Country> countries = new ArrayList<>();
        Country country1 = new Country();
        country1.setCitizenshipCode(643);
        country1.setCitizenshipName("Российская Федерация");
        countries.add(country1);
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
        List<Document> data;
    }
}