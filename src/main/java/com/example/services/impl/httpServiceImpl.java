package com.example.services.impl;

import com.example.CustomException;
import com.example.services.httpService;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class httpServiceImpl implements httpService {

    private final String url = "http://web.juhe.cn/constellation/getAll?consName=type=today&key=";


    @Override
    public Object post() throws CustomException{
        HttpClientBuilder httpClientBuilder =HttpClientBuilder.create();
        HttpGet get = new HttpGet(url);

        return null;
    }
}
