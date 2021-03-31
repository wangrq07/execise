package com.execise.controller;

import com.execise.mapper.UserMapper;
import com.execise.pojo.User;
import com.execise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    //跳转到add页面
    @GetMapping("/user")
    public String toAddPage(){
        return "add";
    }

    //添加user
    @PostMapping("/user")
    public String addUser(User user, Model model){
        if((user.getId()==null) || (user.getUsername().isEmpty()) || (user.getPassword().isEmpty()) || (user.getPhoneNumber().isEmpty())){
            //需输入所有属性
            model.addAttribute("msg","Please type in all the information!");
            return "/add";
        }else if((userService.queryUserById(user.getId()))!=null){
            //id不能重复
            model.addAttribute("msg","ID already exists, please re-enter!");
            return "/add";
        }else{
            userService.addUser(user);
            return "redirect:/users";
        }
    }

    //查询所有user
    @GetMapping("/users")
    public String queryUserList(Model model){
        List<User> users = userService.queryUserList();
        model.addAttribute("users",users);
        return "index";
    }

    //按username查询
    @PostMapping("/queryname")
    public String queryUserByName(String username, Model model){
        //System.out.println(username);
        List<User> users = userService.queryUserByName(username);
        model.addAttribute("users",users);
        return "index";
    }

    //首页
    @GetMapping({"/index","/"})
    public String index(){
        return "index";
    }
}
