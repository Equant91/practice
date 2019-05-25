package com.equant.practice.service.user;

import com.equant.practice.ResponseView;
import com.equant.practice.dao.user.UserDao;
import com.equant.practice.dto.user.UserDTOLong;
import com.equant.practice.dto.user.UserDTORequestForList;
import com.equant.practice.dto.user.UserDTOResponseForList;

import com.equant.practice.mapper.MapperFacade;
import com.equant.practice.model.Country;
import com.equant.practice.model.Document;
import com.equant.practice.model.DocumentType;
import com.equant.practice.model.User;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@NoArgsConstructor
public class UserServiceImpl implements UserService {


    private UserDao userDao;
    private MapperFacade mapperFacade;

@Autowired
    public UserServiceImpl(UserDao userDao, MapperFacade mapperFacade) {
        this.userDao = userDao;
        this.mapperFacade = mapperFacade;
    }


    @Transactional
    @Override
    public UserDTOLong findByID(long id) {
        User user = userDao.findByID(id);
        UserDTOLong userDTOLong = new UserDTOLong();
        if (user!=null) {
            Document document = user.getDocument();
            mapperFacade.map(document, userDTOLong);
            mapperFacade.map(document.getDocumentType(), userDTOLong);
            mapperFacade.map(user.getCountry(), userDTOLong);
            /*выполняется послеждним чтобы правильно заполнилось поле ID*/
            mapperFacade.map(user, userDTOLong);
        }
        return userDTOLong;
    }

    @Transactional
    @Override
    public List<UserDTOResponseForList> findByOfficeId(UserDTORequestForList userDTORequestForList) {
        List<User> users = userDao.findByOfficeId(userDTORequestForList);
        return mapperFacade.mapAsList(users, UserDTOResponseForList.class);
    }

    @Transactional
    @Override
    public ResponseView update(UserDTOLong userDTOLong) {
        User user = mapperFacade.map(userDTOLong, User.class);
        Country country = mapperFacade.map(userDTOLong, Country.class);
        Document document = mapperFacade.map(userDTOLong, Document.class);
        DocumentType documentType = mapperFacade.map(userDTOLong, DocumentType.class);

        return  userDao.update(user, country, document, documentType);
    }

    @Transactional
    @Override
    public ResponseView add(UserDTOLong userDTOLong) {
        User user = mapperFacade.map(userDTOLong, User.class);
        Country country = mapperFacade.map(userDTOLong, Country.class);
        Document document = mapperFacade.map(userDTOLong, Document.class);
        DocumentType documentType = mapperFacade.map(userDTOLong, DocumentType.class);
Long officeId = userDTOLong.getOfficeId();
        return  userDao.add(user, country, document, documentType,officeId );
    }
}
