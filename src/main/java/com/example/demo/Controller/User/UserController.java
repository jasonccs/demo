package com.example.demo.Controller.User;

import com.example.demo.Entity.User;
import com.example.demo.Result.Result;
import com.example.demo.Result.ResultCode;
import com.example.demo.Service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {


    @Autowired
    private UserServiceImpl userServiceImp;

    @RequestMapping("getUser/{id}")
    public User GetUser(@PathVariable int id){
        return userServiceImp.Sel(id);
    }

}
