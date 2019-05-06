package com.equant.practice.dao.user;

import com.equant.practice.ResponseView;
import com.equant.practice.dto.user.UserDTORequestForList;
import com.equant.practice.dto.user.UserDTOResponseForList;
import com.equant.practice.dto.user.WrapperForUserDTO;
import com.equant.practice.model.User;

import java.util.List;

public interface UserDao {
    WrapperForUserDTO findByID(long id);

    List<User> findByOfficeId(UserDTORequestForList user);

    ResponseView update(User user);

    ResponseView add(User user);
}
