package com.equant.practice.controller;
import com.equant.practice.PracticeApplication;
import com.equant.practice.model.Organization;
import com.equant.practice.service.OrganizationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.Request;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import org.springframework.web.client.RestTemplate;




@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PracticeApplication.class)
public class OrganizationControllerTestINT {
    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private OrganizationService organizationService;

    @Test
    public void getById() throws Exception {
        ResponseEntity responseEntity = restTemplate.exchange("http://localhost:8888/organization/5", HttpMethod.GET,
                null, new ParameterizedTypeReference<Organization>() {
                });
        Organization organization = (Organization) responseEntity.getBody();

        Assert.assertEquals(organization, organizationService.findByID(2));
    }

    @Test
    public void getByName() throws Exception {

        ResponseEntity responseEntity = restTemplate.exchange("http://localhost:8888/organization/5", HttpMethod.POST,
                null, new ParameterizedTypeReference<Organization>() {
                });
        Organization organization = (Organization) responseEntity.getBody();

        Assert.assertEquals(organization, organizationService.findByID(2));
    }
}
