package com.example.demo.Entity;

import com.example.demo.Result.Result;
import com.example.demo.Result.ResultCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Arr {


    @RequestMapping(value = "/api/v1/create_info", method = RequestMethod.GET)
    public Result<Object> handlePostRequest(@RequestParam("sysname") String sysname){

        System.out.println(sysname);

        return  new Result<>(ResultCode.SUCCESS, sysname);

    }

}
