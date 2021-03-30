package com.execise.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //id
    private Integer id;
    //姓名
    private String username;
    //密码
    private String password;
    //手机号
    private String phoneNumber;

}
