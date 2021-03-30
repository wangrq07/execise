package com.execise.service;


import com.execise.pojo.User;

import java.util.List;

public interface UserService {
    //查询所有user
    List<User> queryUserList();

    //通过username查询user
    User queryUserByName(String username);

    //注册user
    void addUser(User user);
}
