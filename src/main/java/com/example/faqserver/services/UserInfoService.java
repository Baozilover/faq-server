package com.example.faqserver.services;

import com.example.faqserver.CustomException;
import com.example.faqserver.entity.UserInfo;
import com.example.faqserver.repository.UserInfoRepository;
import com.example.faqserver.utils.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    public UserInfo register(String username,String password) throws CustomException{
        Optional<UserInfo> userInfo = userInfoRepository.getByUsername(username);
        if(!userInfo.isEmpty()){
            throw new CustomException(ErrorCode.E00001);
        }

        UserInfo newUser = new UserInfo();
        newUser.setUsername(username);
        newUser.setPassword(password);
        return userInfoRepository.saveAndFlush(newUser);
    }
}
