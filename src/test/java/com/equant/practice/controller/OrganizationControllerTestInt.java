package com.equant.practice.controller;

import com.equant.practice.PracticeApplication;
import com.equant.practice.ResponseView;
import com.equant.practice.model.Organization;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PracticeApplication.class)
public class OrganizationControllerTestInt {

    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void getById() {
        Wrapper wrapperReq = restTemplate.getForObject("http://localhost:8888/api/organization/5", Wrapper.class);
        Assert.assertEquals(wrapperReq, getWrapeprForTest());
    }

    @Test
    public void getByName() {
        Wrapper wrapperReq = restTemplate.postForObject("http://localhost:8888/api/organization/list", getOrganizationForTest(), Wrapper.class);
        Assert.assertEquals(wrapperReq, getWrapeprForTest());
    }


    @Test
    public void update() {
        ResponseView responseView = restTemplate.postForObject("http://localhost:8888/api/organization/update", getOrganizationForTest(), ResponseView.class);
        Assert.assertEquals(responseView.isSuccess(), true);
    }

    @Test
    public void add() {
        ResponseView responseView = restTemplate.postForObject("http://localhost:8888/api/organization/save", getOrganizationForTest(), ResponseView.class);
        Assert.assertEquals(responseView.isSuccess(), true);
    }


    private Wrapper getWrapeprForTest() {
        return new Wrapper(getOrganizationForTest());
    }

    private Organization getOrganizationForTest() {
        Organization organization = new Organization();
        organization.setAddress("ул.Цюрупы");
        organization.setFull_name("Центр социального обслудивания Гармония");
        organization.setName("Гармония");
        organization.setInn("3903243212");
        return organization;
    }

    @lombok.Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Wrapper {
        Organization data;

    }

}
