package com.equant.practice.controller;

import com.equant.practice.PracticeApplication;
import com.equant.practice.ResponseView;
import com.equant.practice.dto.organization.OrgRequest;
import com.equant.practice.dto.organization.OrganizationDTOForGetAndUpdate;
import com.equant.practice.dto.organization.OrganizationDTOForList;
import com.equant.practice.model.Organization;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
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


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PracticeApplication.class)
public class OrganizationControllerTestInt {

    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void getById() {
        Wrapper wrapperRes = restTemplate.getForObject("http://localhost:8888/api/organization/1", Wrapper.class);
        Assert.assertEquals(wrapperRes, getWrapperOrganizationForGet());
    }

    @Test
    public void getByName() {
        WrapperOrgDTO wrapperReq = restTemplate. postForObject("http://localhost:8888/api/organization/list", getOrgRequest() , WrapperOrgDTO.class);
        Assert.assertEquals(wrapperReq, getWrapperOrganizationForGetByName());
    }


    @Test
    public void update() {
        ResponseView responseView = restTemplate.postForObject("http://localhost:8888/api/organization/update", getOrganizationForTestUpdate(), ResponseView.class);
        Assert.assertEquals(responseView.getSuccess(), true);
    }

    @Test
    public void add() {
        ResponseView responseView = restTemplate.postForObject("http://localhost:8888/api/organization/save", getOrganizationForTestAdd(), ResponseView.class);
        Assert.assertEquals(responseView.getSuccess(), true);
    }




    private OrgRequest getOrgRequest(){
        OrgRequest orgRequest = new OrgRequest();
        orgRequest.setName("Гармония"); //обязательный параметр
        orgRequest.setInn("3903243212");
        orgRequest.setIsActive(Boolean.TRUE);

        return orgRequest;
    }
    private Wrapper getWrapperOrganizationForGet() {
        OrganizationDTOForGetAndUpdate organization = new OrganizationDTOForGetAndUpdate();
        organization.setAddress("ул.Цюрупы");
        organization.setFullName("Центр социального обслуживания Гармония");
        organization.setName("Гармония");
        organization.setInn("3903243212");
        organization.setIsActive(true);
        organization.setPhone("408090");
        organization.setId(1);
        organization.setKpp("321456123");
        return new Wrapper(organization);
    }
    private OrganizationDTOForGetAndUpdate getOrganizationForTestUpdate() {
        OrganizationDTOForGetAndUpdate organization = new OrganizationDTOForGetAndUpdate();
        organization.setAddress("ул.Главная");
        organization.setFullName("Центр Отдыха Пентингтон");
        organization.setName("Пентингтон");
        organization.setInn("390323453");
        organization.setIsActive(true);
        organization.setPhone("408890");
        organization.setId(1);
        organization.setKpp("452356123");
        return organization;
    }
    private Organization getOrganizationForTestAdd() {
        Organization organization = new Organization();
        organization.setAddress("ул.Главная");
        organization.setFullName("Центр Отдыха Пентингтон");
        organization.setName("Пентингтон");
        organization.setInn("390323453");
        organization.setIsActive(true);
        organization.setPhone("408890");
        organization.setKpp("452356123");
        return organization;
    }
    private WrapperOrgDTO getWrapperOrganizationForGetByName (){
        OrganizationDTOForList organizationDTO = new OrganizationDTOForList();
        organizationDTO.setId(1);
        organizationDTO.setName("Гармония");
        organizationDTO.setIsActive(true);
        List<OrganizationDTOForList>  organizationDTOs= new ArrayList<>();
        organizationDTOs.add(organizationDTO);
        return new WrapperOrgDTO(organizationDTOs);
    }


    @lombok.Data
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    private static class Wrapper {
        OrganizationDTOForGetAndUpdate data;

    }

    @lombok.Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class WrapperOrgDTO {
        List<OrganizationDTOForList> data;

    }

}
