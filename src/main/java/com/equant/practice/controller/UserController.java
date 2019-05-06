package com.equant.practice.controller;

import com.equant.practice.ResponseView;
import com.equant.practice.dto.user.UserDTOForGet;
import com.equant.practice.dto.user.UserDTORequestForList;
import com.equant.practice.dto.user.UserDTOResponseForList;
import com.equant.practice.model.User;
import com.equant.practice.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/{id:[\\d]+}", method = RequestMethod.GET)
    public UserDTOForGet getById(@PathVariable("id") long id ){
        UserDTOForGet user = userService.findByID(id);
        if(user == null){
            throw new RuntimeException("Not found user with this id" + id);
        }
        return user;
    }

    @RequestMapping(path = "/list", method = RequestMethod.POST)
    public List<UserDTOResponseForList> getByOfficeId(@RequestBody UserDTORequestForList userRequest){
        List<UserDTOResponseForList> users = userService.findByOfficeId(userRequest);
        if(users == null){
            throw  new RuntimeException("Not found user with this Office id");
        }
        return users;
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ResponseView update(@RequestBody User user){
        return userService.update(user);
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public ResponseView add(@RequestBody User user){
        return userService.add(user);
    }
}
