package com.zuoshao.vote.service.serviceImpl;

import com.zuoshao.vote.bean.User;
import com.zuoshao.vote.mapper.Usermapper;
import com.zuoshao.vote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zuoshao
 * @date 2019/6/15 - 15:54
 */
@Service
public class UserserviceImpl implements UserService {

    @Autowired
    Usermapper usermapper;

    @Override
    public List<User> userall() {
        List<User> users = usermapper.selectAll();
        return users;
    }

    @Override
    public Integer userregister(User user) {
        int insert = usermapper.insert(user);
        return insert;
    }

    @Override
    public User userlogin(User user) {
        User user1 = usermapper.selectOne(user);
        return user1;
    }
}
