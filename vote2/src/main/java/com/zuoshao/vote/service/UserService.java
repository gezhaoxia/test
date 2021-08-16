package com.zuoshao.vote.service;

import com.zuoshao.vote.bean.User;

import java.util.List;

/**
 * @author zuoshao
 * @date 2019/6/15 - 15:53
 */
public interface UserService {

    public List<User> userall();
    //用户注册（用户表中插入一条数据）
    public Integer userregister(User user);
    //用户登录(传入用户名和密码查一个人)
    public User userlogin(User user);

}
