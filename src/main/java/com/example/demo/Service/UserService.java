package com.example.demo.Service;


import com.example.demo.Entity.User;
import com.example.demo.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface UserService{


     User Sel(int id);


}
