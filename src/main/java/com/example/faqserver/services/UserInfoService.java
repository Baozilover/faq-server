package com.example.faqserver.services;

import com.example.faqserver.CustomException;
import com.example.faqserver.entity.UserInfo;
import org.springframework.stereotype.Service;

@Service
public interface UserInfoService {

    UserInfo register(String username,String password) throws CustomException;
}
