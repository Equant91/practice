package com.equant.practice.service.user;

import com.equant.practice.ResponseView;
import com.equant.practice.dao.user.UserDao;
import com.equant.practice.dto.user.UserDTOForGet;
import com.equant.practice.dto.user.UserDTORequestForList;
import com.equant.practice.dto.user.UserDTOResponseForList;
import com.equant.practice.dto.user.WrapperForUserDTO;
import com.equant.practice.mapper.MapperFacade;
import com.equant.practice.model.User;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@NoArgsConstructor
public class UserServiceImpl implements UserService {

    private ResponseView responseView;
    private UserDao userDao;
    private MapperFacade mapperFacade;

@Autowired
    public UserServiceImpl(UserDao userDao, MapperFacade mapperFacade) {
        this.userDao = userDao;
        this.mapperFacade = mapperFacade;
    }


    @Transactional
    @Override
    public UserDTOForGet findByID(long id) {
        WrapperForUserDTO wrapperForUserDTO = userDao.findByID(id);

        return mapperFacade.mapWrapper(wrapperForUserDTO);
    }

    @Transactional
    @Override
    public List<UserDTOResponseForList> findByOfficeId(UserDTORequestForList userDTORequestForList) {
       List<User> users=  userDao.findByOfficeId(userDTORequestForList);
    return mapperFacade.mapAsList(users,UserDTOResponseForList.class);
    }

    @Transactional
    @Override
    public ResponseView update(User user) {
        return responseView = new ResponseView(true);
    }

    @Transactional
    @Override
    public ResponseView add(User user) {
        return responseView = new ResponseView(true);
    }
}
