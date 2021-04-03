package com.example.demo.Controller;

import com.example.demo.Entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author jasonccs
 * @date 2021/04/03 10:45
 * @description:
 */
@RestController
public class TestController {
    @GetMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setId(1L);
        user.setAccount("12345678");
        user.setPassword("12345678");
        user.setEmail("123@qq.com");
        return user;
    }

    @PostMapping("/addUser")
    public User addUser(@Valid @RequestBody User user) {
        user.setId(user.getId());
        user.setAccount(user.getAccount());
        user.setPassword(user.getPassword());
        user.setEmail(user.getEmail());
        return user;
    }
}