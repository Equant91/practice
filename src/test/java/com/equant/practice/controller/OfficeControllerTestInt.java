package com.equant.practice.controller;

import com.equant.practice.PracticeApplication;
import com.equant.practice.ResponseView;
import com.equant.practice.model.Office;
import com.equant.practice.model.Organization;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PracticeApplication.class)
public class OfficeControllerTestInt {
    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void getById() {
        Wrapper wrapperReq = restTemplate.getForObject("http://localhost:8888/api/office/5", Wrapper.class);
        Assert.assertEquals(wrapperReq, getWrapeprForTest());
    }

    @Test
    public void getByName() {
        Wrapper wrapperReq = restTemplate.postForObject("http://localhost:8888/api/office/list", getOfficeForTest(), Wrapper.class);
        System.out.println(wrapperReq);
        System.out.println(getWrapeprForTest());
        Assert.assertEquals(wrapperReq, getWrapeprForTest());
    }

    @Test
    public void update() {
        ResponseView responseView = restTemplate.postForObject("http://localhost:8888/api/office/update", getOfficeForTest(), ResponseView.class);
        Assert.assertEquals(responseView.isSuccess(), true);
    }

    @Test
    public void add() {
        ResponseView responseView = restTemplate.postForObject("http://localhost:8888/api/office/save", getOfficeForTest(), ResponseView.class);
        Assert.assertEquals(responseView.isSuccess(), true);
    }


    private Wrapper getWrapeprForTest() {
        return new Wrapper(getOfficeForTest());
    }

    private Office getOfficeForTest() {
        Office office = new Office();
        office.setName("Центральный");
        office.setAddress("ул.Цюрупы");
        office.setPhone("899889");
        return office;
    }

    @lombok.Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Wrapper {
        Office data;

    }

}