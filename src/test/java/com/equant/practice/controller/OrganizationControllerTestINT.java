package com.equant.practice.controller;

import com.equant.practice.PracticeApplication;
import com.equant.practice.model.Organization;


import org.junit.Assert;
import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import org.springframework.web.client.RestTemplate;

import java.net.URI;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PracticeApplication.class)
public class OrganizationControllerTestINT {
    RestTemplate restTemplate = new RestTemplate();



    @Test
    public void getById()  {

        ResponseEntity responseEntity = restTemplate.exchange("http://localhost:8888/organization/5", HttpMethod.GET,
                null, new ParameterizedTypeReference<Organization>() {
                });
        Organization organization = (Organization) responseEntity.getBody();

        Assert.assertEquals(organization, getOrganizationForTest());
    }




    private Organization getOrganizationForTest(){
        Organization organization = new Organization();
        organization.setAddress("ул.Цюрупы");
        organization.setFull_name("Центр социального обслудивания Гармония");
        organization.setName("Гармония");
        organization.setInn("3903243212");
        return organization;
    }
}
