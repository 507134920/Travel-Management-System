package com.lj.trshop.service;

import com.lj.trshop.entity.User;

public interface UserService {

    User login(String username, String password);

    //注册
    boolean regist(User user);
    //激活
    boolean active(String code);
}
