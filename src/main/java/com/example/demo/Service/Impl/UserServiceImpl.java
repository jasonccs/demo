package com.example.demo.Service.Impl;


import com.example.demo.Entity.User;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    public User Sel(int id) {
        return userMapper.Sel(id);
    }

    public User Del(int id) {
        return userMapper.Del(id);
    }

}
