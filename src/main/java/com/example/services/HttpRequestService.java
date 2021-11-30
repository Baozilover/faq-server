package com.example.services;

import com.example.CustomException;

/**
 * @author baozilover
 */
public interface HttpRequestService {

    Object getAnswerFromApi(String consName, String typr) throws CustomException;

    Object sendFaqRequest(String username, String question) throws CustomException;
}
