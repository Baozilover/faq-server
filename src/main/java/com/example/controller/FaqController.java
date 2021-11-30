package com.example.controller;

import com.example.CustomException;
import com.example.services.HttpRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baozilover
 */
@RequestMapping("/question")
@RestController
public class FaqController {

    @Autowired
    private HttpRequestService httpRequestService;

    @GetMapping("/sample")
    public Object getQuestion(@RequestParam("username") String username,
                              @RequestParam("question") String question) throws CustomException {
        return httpRequestService.sendFaqRequest(username, question);
    }

    @GetMapping("/api")
    public Object getAnswer(@RequestParam("cons_name") String consName,
                            @RequestParam("type") String type) throws CustomException {
        return httpRequestService.getAnswerFromApi(consName, type);
    }
}
