package com.example.controller;

import com.example.CustomException;
import com.example.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/register")
    public Object register(@RequestParam("username") String username,
                        @RequestParam("password") String password)throws CustomException {
        return userInfoService.register(username,password);
    }

    @PostMapping("/login")
    public Object login(@RequestParam("username") String username,
                        @RequestParam("password") String password) throws CustomException{
        return "success";
    }

    @PostMapping("/logout")
    public Object logout(@RequestParam("username") String username) throws CustomException{
        return "success";
    }
}
