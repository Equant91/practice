package com.equant.practice.service.user;

import com.equant.practice.ResponseView;
import com.equant.practice.dto.user.UserDTOForGet;
import com.equant.practice.dto.user.UserDTORequestForList;
import com.equant.practice.dto.user.UserDTOResponseForList;
import com.equant.practice.model.User;

import java.util.List;

public interface UserService {
    UserDTOForGet findByID(long id);

    List<UserDTOResponseForList> findByOfficeId(UserDTORequestForList userDTORequestForList);

    ResponseView update(User user);

    ResponseView add(User user);
}
