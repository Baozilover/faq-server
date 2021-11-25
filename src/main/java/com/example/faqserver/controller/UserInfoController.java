package com.example.faqserver.controller;

import com.example.faqserver.CustomException;
import com.example.faqserver.entity.UserInfo;
import com.example.faqserver.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    public UserInfo res(@RequestParam("username") String username,
                        @RequestParam("password") String password)throws CustomException {
        return userInfoService.register(username,password);
    }
}
