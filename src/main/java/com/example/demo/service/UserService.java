package com.example.demo.service;

import com.example.demo.dao.UserMapper;
import com.example.demo.pojo.User1;
import com.example.demo.pojo.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User1> findUser() {
        return userMapper.findUser();
    }

    public int insertUser(String name,Integer age) {
        return userMapper.insertUser(name,age);
    }
}
