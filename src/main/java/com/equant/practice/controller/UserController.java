package com.equant.practice.controller;

import com.equant.practice.ResponseView;
import com.equant.practice.dto.user.UserDTOLong;
import com.equant.practice.dto.user.UserDTORequestForList;
import com.equant.practice.dto.user.UserDTOResponseForList;
import com.equant.practice.model.User;
import com.equant.practice.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/{id:[\\d]+}", method = RequestMethod.GET)
    public UserDTOLong getById(@PathVariable("id")  long id ){
        UserDTOLong user = userService.findByID(id);
        if(user.getId() == null){
            throw new RuntimeException("Not found user with this id = " + id);
        }
        return user;
    }

    @RequestMapping(path = "/list", method = RequestMethod.POST)
    public List<UserDTOResponseForList> getByOfficeId(@Valid @RequestBody UserDTORequestForList userRequest){
        List<UserDTOResponseForList> users = userService.findByOfficeId(userRequest);
        if(users == null){
            throw  new RuntimeException("Not found user with this Office id");
        }
        return users;
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ResponseView update(@Validated(UserDTOLong.MyValidateForUpdate.class) @RequestBody UserDTOLong userDTOLong){
        ResponseView responseView = userService.update(userDTOLong);
        System.out.println(responseView.toString());
        return responseView;
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public ResponseView add(@Validated(UserDTOLong.MyValidateForAdd.class)@RequestBody UserDTOLong userDTOLong){
        return userService.add(userDTOLong);
    }
}
