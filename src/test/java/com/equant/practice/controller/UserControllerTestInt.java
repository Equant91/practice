package com.equant.practice.controller;

import com.equant.practice.PracticeApplication;
import com.equant.practice.ResponseView;
import com.equant.practice.model.User;
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
public class UserControllerTestInt {
    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void getById() {
        Wrapper wrapperReq = restTemplate.getForObject("http://localhost:8888/api/user/5", Wrapper.class);
        Assert.assertEquals(wrapperReq, getWrapeprForTest());
    }

    @Test
    public void getByName() {
        Wrapper wrapperReq = restTemplate.postForObject("http://localhost:8888/api/user/list", getUserForTest(), Wrapper.class);
        Assert.assertEquals(wrapperReq, getWrapeprForTest());
    }

    @Test
    public void update() {
        ResponseView responseView = restTemplate.postForObject("http://localhost:8888/api/user/update", getUserForTest(), ResponseView.class);
        Assert.assertEquals(responseView.isSuccess(), true);
    }

    @Test
    public void add() {
        ResponseView responseView = restTemplate.postForObject("http://localhost:8888/api/user/save", getUserForTest(), ResponseView.class);
        Assert.assertEquals(responseView.isSuccess(), true);
    }

    private Wrapper getWrapeprForTest() {
        return new Wrapper(getUserForTest());
    }

    private User getUserForTest() {
        User user = new User();
        user.setFirst_name("Андрей");
        user.setPosition("менеджер");
        user.setPhone("796412");
        return user;
    }

    @lombok.Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Wrapper {
        User data;

    }
}