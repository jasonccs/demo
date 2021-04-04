package com.example.demo.Mapper;


import com.example.demo.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper//指定这是一个操作数据库的mapper
public interface UserMapper {

    User Sel(int id);

    User Del(int id);
}