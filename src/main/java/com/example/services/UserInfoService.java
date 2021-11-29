package com.example.services;

import com.example.CustomException;

public interface UserInfoService {

    String register(String username,String password) throws CustomException;
}
