package com.execise.mapper;

import com.execise.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    //查询所有user
    List<User> queryUserList();

    //通过username查询
    User queryUserByName(String username);

    //注册user
    void addUser(User user);
}
