package com.equant.practice.controller;

import com.equant.practice.PracticeApplication;
import com.equant.practice.ResponseView;
import com.equant.practice.dto.office.OfficeDTOForGet;
import com.equant.practice.dto.office.OfficeDTORequestForAdd;
import com.equant.practice.dto.office.OfficeDTOForList;
import com.equant.practice.dto.office.OfficeDTORequestForList;
import com.equant.practice.model.Office;
import lombok.AllArgsConstructor;
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
public class OfficeControllerTestInt {
    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void test1GetById() {
        Wrapper wrapperReq = restTemplate.getForObject("http://localhost:8888/api/office/1", Wrapper.class);
        Assert.assertEquals(wrapperReq, getWrapperOfficeDTOForGet());
    }

    @Test
    public void test2GetByName() {
        WrapperOfficeDTO wrapperReq = restTemplate.postForObject("http://localhost:8888/api/office/list", getOfficeRequest(), WrapperOfficeDTO.class);
               Assert.assertEquals(wrapperReq, getWrapperOfficeDTOForGetByOrgId());
    }

    @Test
    public void test3Update() {
        ResponseView responseView = restTemplate.postForObject("http://localhost:8888/api/office/update", getOfficeForTestUpdate(), ResponseView.class);
        Assert.assertEquals(responseView.getSuccess(), true);
    }

    @Test
    public void Test4Add() {
        ResponseView responseView = restTemplate.postForObject("http://localhost:8888/api/office/save", getOfficeForTestAdd(), ResponseView.class);
        Assert.assertEquals(responseView.getSuccess(), true);
    }





    private Wrapper getWrapperOfficeDTOForGet() {
        OfficeDTOForGet office = new OfficeDTOForGet();
        office.setId(1L);
        office.setName("Центральный");
        office.setAddress("ул.Цюрупы");
        office.setPhone("567645");
        office.setIsActive(true);
        return new Wrapper(office);
    }
    private OfficeDTOForGet getOfficeForTestUpdate() {
        OfficeDTOForGet office = new OfficeDTOForGet();
        office.setId(1L);
        office.setName("Второй");
        office.setAddress("ул.Лацмана");
        office.setPhone("567645");
        office.setIsActive(true);
        return office;
    }
    private OfficeDTORequestForAdd getOfficeForTestAdd() {
        OfficeDTORequestForAdd office = new OfficeDTORequestForAdd();
        office.setOrgId(1L);
        office.setName("Второй");
        office.setAddress("ул.Лацмана");
        office.setPhone("567645");
        office.setIsActive(true);
        return office;
    }
    private OfficeDTORequestForList getOfficeRequest() {
        OfficeDTORequestForList officeDTORequestForList = new OfficeDTORequestForList();
        officeDTORequestForList.setOrgId(Long.valueOf(1));//обязательный параметр
        officeDTORequestForList.setName("Центральный");
        officeDTORequestForList.setPhone("567645");
        officeDTORequestForList.setIsActive(Boolean.TRUE);
        return officeDTORequestForList;
    }
    private WrapperOfficeDTO getWrapperOfficeDTOForGetByOrgId(){
        OfficeDTOForList officeDTOForList = new OfficeDTOForList();
        officeDTOForList.setId(1L);
        officeDTOForList.setName("Центральный");
        officeDTOForList.setIsActive(true);
        List<OfficeDTOForList>  officesDTOForList= new ArrayList<>();
        officesDTOForList.add(officeDTOForList);
        return new WrapperOfficeDTO(officesDTOForList);
    }
        @lombok.Data
        @NoArgsConstructor
        @AllArgsConstructor
        private static class Wrapper {
            OfficeDTOForGet data;

        }

        @lombok.Data
        @NoArgsConstructor
        @AllArgsConstructor
        private static class WrapperOfficeDTO {
            List<OfficeDTOForList> data;

        }

    }
