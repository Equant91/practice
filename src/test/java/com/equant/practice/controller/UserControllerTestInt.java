package com.equant.practice.controller;

import com.equant.practice.PracticeApplication;
import com.equant.practice.ResponseView;
import com.equant.practice.dto.user.UserDTOLong;
import com.equant.practice.dto.user.UserDTORequestForList;
import com.equant.practice.dto.user.UserDTOResponseForList;

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
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

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
        ResponseView responseView = restTemplate.postForObject("http://localhost:8888/api/user/update", getWrapperUserDTOForUpdate() , ResponseView.class);
        Assert.assertEquals(responseView.getSuccess(), true);
    }

    @Test
    public void test4Add() {
        ResponseView responseView = restTemplate.postForObject("http://localhost:8888/api/user/save", getWrapperUserDTOFordd(), ResponseView.class);
        Assert.assertEquals(responseView.getSuccess(), true);
    }

    private Wrapper getWrapperUserDTOForGet(){
        UserDTOLong userDTOLong = new UserDTOLong();
        userDTOLong.setCitizenshipCode("643");
        userDTOLong.setCitizenshipName("Российская Федерация");
        userDTOLong.setDocCode(3L);
        userDTOLong.setDocName("Свидетельство о рождение");
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Moscow)"));
        userDTOLong.setDocDate(new GregorianCalendar(2003, 2,30).getTime());
        userDTOLong.setDocNumber(123212L);
        userDTOLong.setFirstName("Андрей");
        userDTOLong.setPhone("796412");
        userDTOLong.setPosition("менеджер");
        userDTOLong.setId(1L);
        return new Wrapper(userDTOLong);
}
    private UserDTOLong getWrapperUserDTOForUpdate(){
        UserDTOLong userDTOLong = new UserDTOLong();
        userDTOLong.setCitizenshipCode("032");
        userDTOLong.setDocCode(7L);
        userDTOLong.setDocName("Военный билет");
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Moscow)"));
        userDTOLong.setDocDate(new GregorianCalendar(2003, 1,20).getTime());
        userDTOLong.setDocNumber(1234L);
        userDTOLong.setFirstName("Максим");
        userDTOLong.setPhone("231242");
        userDTOLong.setPosition("Стажер");
        userDTOLong.setId(1L);
        return userDTOLong;
    }
    private UserDTOLong getWrapperUserDTOFordd(){
        UserDTOLong userDTOLong = new UserDTOLong();
        userDTOLong.setCitizenshipCode("032");
        userDTOLong.setDocCode(3L);
        userDTOLong.setDocName("Свидетельство о рождение");
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Moscow)"));
        userDTOLong.setDocDate(new GregorianCalendar(2003, 1,20).getTime());
        userDTOLong.setDocNumber(1234L);
        userDTOLong.setFirstName("Максим");
        userDTOLong.setPhone("231242");
        userDTOLong.setPosition("Стажер");
        userDTOLong.setOfficeId(1L);
        return userDTOLong;
    }

    private UserDTORequestForList getUserDTORequestForList(){
        UserDTORequestForList userDTORequestForList = new UserDTORequestForList();
        userDTORequestForList.setOfficeId(1L); //обязательный параметр
        userDTORequestForList.setFirstName("Андрей");
        userDTORequestForList.setPosition("менеджер");
      userDTORequestForList.setDocCode(3L);
       userDTORequestForList.setCitizenshipCode("643");
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
        UserDTOLong data;

    }
    @lombok.Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class WrapperUserDTOForList {
        List<UserDTOResponseForList> data;

    }
}