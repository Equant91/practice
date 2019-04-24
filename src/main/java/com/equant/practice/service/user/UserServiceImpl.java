package com.equant.practice.service.user;

import com.equant.practice.ResponseView;
import com.equant.practice.model.User;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@NoArgsConstructor
public class UserServiceImpl implements UserService {
    ResponseView responseView;

    private User getUserForTest() {
        User user = new User();
        user.setFirst_name("Андрей");
        user.setPosition("менеджер");
        user.setPhone("796412");
        return user;

    }

    @Transactional
    @Override
    public User findByID(long id) {
        return getUserForTest();
    }

    @Transactional
    @Override
    public User findByName(String name) {
        return getUserForTest();
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
