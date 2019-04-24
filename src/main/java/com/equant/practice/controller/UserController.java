package com.equant.practice.controller;

import com.equant.practice.ResponseView;
import com.equant.practice.model.User;
import com.equant.practice.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(path = "/{id:[\\d]+}", method = RequestMethod.GET)
    public User getById(@PathVariable("id") long id ){
        User user = userService.findByID(id);
        if(user == null){
            throw  new RuntimeException("Not found user with this id");
        }
        return user;
    }

    @RequestMapping(path = "/list", method = RequestMethod.POST)
    public User getByName(@RequestBody User userRequest){
        User user = userService.findByName(userRequest.getFirst_name());
        if(user == null){
            throw  new RuntimeException("Not found user with this id");
        }
        return user;
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
