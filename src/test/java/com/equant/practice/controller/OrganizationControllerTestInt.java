package com.equant.practice.controller;

import com.equant.practice.PracticeApplication;
import com.equant.practice.ResponseView;
import com.equant.practice.dto.organization.OrgDTORequestForList;
import com.equant.practice.dto.organization.OrganizationDTOForAdd;
import com.equant.practice.dto.organization.OrganizationDTOForGetAndUpdate;
import com.equant.practice.dto.organization.OrganizationDTOResponseForList;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;

import org.junit.runner.RunWith;

import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PracticeApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrganizationControllerTestInt {


    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void test1GetById() {
        Wrapper wrapperRes = restTemplate.getForObject("http://localhost:8888/api/organization/1", Wrapper.class);
        Assert.assertEquals(wrapperRes, getWrapperOrganizationForGet());
    }

    @Test
    public void test2GetByName() {
        WrapperOrgDTO wrapperReq = restTemplate. postForObject("http://localhost:8888/api/organization/list", getOrgRequest() , WrapperOrgDTO.class);
        Assert.assertEquals(wrapperReq, getWrapperOrganizationForGetByName());
    }


    @Test
    public void test3Update() {
        ResponseView responseView = restTemplate.postForObject("http://localhost:8888/api/organization/update", getOrganizationForTestUpdate(), ResponseView.class);
        Assert.assertEquals(responseView.getSuccess(), true);
    }

    @Test
    public void test4Add() {
        ResponseView responseView = restTemplate.postForObject("http://localhost:8888/api/organization/save", getOrganizationForTestAdd(), ResponseView.class);
        Assert.assertEquals(responseView.getSuccess(), true);
    }




    private OrgDTORequestForList getOrgRequest(){
        OrgDTORequestForList orgDTORequestForList = new OrgDTORequestForList();
        orgDTORequestForList.setName("Гармония"); //обязательный параметр
        orgDTORequestForList.setInn("3903243212");
        orgDTORequestForList.setIsActive(Boolean.TRUE);

        return orgDTORequestForList;
    }
    private Wrapper getWrapperOrganizationForGet() {
        OrganizationDTOForGetAndUpdate organization = new OrganizationDTOForGetAndUpdate();
        organization.setAddress("ул.Цюрупы");
        organization.setFullName("Центр социального обслуживания Гармония");
        organization.setName("Гармония");
        organization.setInn("3903243212");
        organization.setIsActive(true);
        organization.setPhone("408090");
        organization.setId(1L);
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
        organization.setId(1L);
        organization.setKpp("452356123");
        return organization;
    }
    private OrganizationDTOForAdd getOrganizationForTestAdd() {
        OrganizationDTOForAdd organization = new OrganizationDTOForAdd();
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
        OrganizationDTOResponseForList organizationDTO = new OrganizationDTOResponseForList();
        organizationDTO.setId(1L);
        organizationDTO.setName("Гармония");
        organizationDTO.setIsActive(true);
        List<OrganizationDTOResponseForList>  organizationDTOs= new ArrayList<>();
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
        List<OrganizationDTOResponseForList> data;

    }

}
