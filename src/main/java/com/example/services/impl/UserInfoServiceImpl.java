package com.example.services.impl;

import com.example.CustomException;
import com.example.entity.UserInfo;
import com.example.repository.UserInfoRepository;
import com.example.services.UserInfoService;
import com.example.utils.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public String register(String username,String password) throws CustomException{
        Optional<UserInfo> userInfo = userInfoRepository.getByUsername(username);
        if(!userInfo.isEmpty()){
            throw new CustomException(ErrorCode.E00001);
        }

        UserInfo newUser = new UserInfo();
        newUser.setUsername(username);
        return "success";
    }
}
