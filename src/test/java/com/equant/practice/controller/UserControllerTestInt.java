package com.equant.practice.controller;

import com.equant.practice.PracticeApplication;
import com.equant.practice.ResponseView;
import com.equant.practice.dto.office.OfficeDTOForList;
import com.equant.practice.dto.user.UserDTOForGet;
import com.equant.practice.dto.user.UserDTORequestForList;
import com.equant.practice.dto.user.UserDTOResponseForList;
import com.equant.practice.dto.user.WrapperForUserDTO;
import com.equant.practice.model.User;
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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import static org.junit.Assert.*;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PracticeApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserControllerTestInt {
    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void test1GetById() {
        Wrapper wrapperReq = restTemplate.getForObject("http://localhost:8888/api/user/1", Wrapper.class);
        Assert.assertEquals(wrapperReq, getWrapperUserDTOForGet());
    }

    @Test
    public void test2GetByOfficeId() {
        WrapperUserDTOForList wrapperReq = restTemplate.postForObject("http://localhost:8888/api/user/list", getUserDTORequestForList(), WrapperUserDTOForList.class);
         Assert.assertEquals(wrapperReq, getWrapperUserResponseForGetByName());
    }

    @Test
    public void test3Update() {
        ResponseView responseView = restTemplate.postForObject("http://localhost:8888/api/user/update", null, ResponseView.class);
        Assert.assertEquals(responseView.getSuccess(), true);
    }

    @Test
    public void test4Add() {
        ResponseView responseView = restTemplate.postForObject("http://localhost:8888/api/user/save", null, ResponseView.class);
        Assert.assertEquals(responseView.getSuccess(), true);
    }

    private Wrapper getWrapperUserDTOForGet(){
        UserDTOForGet userDTOForGet = new UserDTOForGet();
        userDTOForGet.setCitizenshipCode(643);
        userDTOForGet.setCitizenshipName("Российская Федерация");
        userDTOForGet.setDocCode(3L);
        userDTOForGet.setDocName("Свидетельство о рождение");
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Moscow)"));
        userDTOForGet.setDocDate(new GregorianCalendar(2003, 2,30).getTime());
        userDTOForGet.setDocNumber(123212L);
        userDTOForGet.setFirstName("Андрей");
        userDTOForGet.setPhone("796412");
        userDTOForGet.setPosition("менеджер");
        userDTOForGet.setId(1L);
        return new Wrapper(userDTOForGet);
}


    private UserDTORequestForList getUserDTORequestForList(){
        UserDTORequestForList userDTORequestForList = new UserDTORequestForList();
        userDTORequestForList.setOfficeId(1L); //обязательный параметр
        userDTORequestForList.setFirstName("Андрей");
        userDTORequestForList.setPosition("менеджер");
      userDTORequestForList.setDocCode(3L);
       userDTORequestForList.setCitizenshipCode(643);
        return userDTORequestForList;
    }
    private WrapperUserDTOForList getWrapperUserResponseForGetByName (){
        UserDTOResponseForList userDTOResponseForList = new UserDTOResponseForList();
        userDTOResponseForList.setId(1L);
        userDTOResponseForList.setFirstName("Андрей");
        userDTOResponseForList.setPosition("менеджер");
        List<UserDTOResponseForList>  userDTOResponseForLists= new ArrayList<>();
        userDTOResponseForLists.add(userDTOResponseForList);
        return new WrapperUserDTOForList(userDTOResponseForLists);
    }

    @lombok.Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Wrapper {
        UserDTOForGet data;

    }
    @lombok.Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class WrapperUserDTOForList {
        List<UserDTOResponseForList> data;

    }
}