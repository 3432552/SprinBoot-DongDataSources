package com.example.demo.dao;

import com.example.demo.pojo.User1;
import com.example.demo.pojo.User2;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
public interface UserMapper {
    @Select("SELECT * FROM  user1 ")
    public List<User1> findUser();

    @Insert("insert into user2 (name,age) values (#{name},#{age})")
    public int insertUser(@Param("name") String name,@Param("age") Integer age);
}
