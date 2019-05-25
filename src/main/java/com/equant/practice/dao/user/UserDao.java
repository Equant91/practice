package com.equant.practice.dao.user;

import com.equant.practice.ResponseView;
import com.equant.practice.dto.user.UserDTORequestForList;

import com.equant.practice.model.Country;
import com.equant.practice.model.Document;
import com.equant.practice.model.DocumentType;
import com.equant.practice.model.User;

import java.util.List;

public interface UserDao {
    User findByID(long id);

    List<User> findByOfficeId(UserDTORequestForList user);

    ResponseView update(User user, Country country, Document document, DocumentType documentType);

    ResponseView add(User user, Country country,Document document,DocumentType documentType, Long officeId);
}
