package com.example.demo.controller;

import com.example.demo.pojo.User1;
import com.example.demo.pojo.User2;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findUser")
    public List<User1> findUser() {
        return userService.findUser();
    }
    @RequestMapping("/insertUser")
    public boolean insertUser(String name,Integer age) {
        int result=userService.insertUser(name, age);
        if (result>0){
            System.out.println("增加成功!");
            return true;
        }else {
            return false;
        }
    }
}
