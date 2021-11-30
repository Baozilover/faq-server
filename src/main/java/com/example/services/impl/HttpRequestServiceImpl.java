package com.example.services.impl;

import com.example.CustomException;
import com.example.entity.UserInfo;
import com.example.repository.UserInfoRepository;
import com.example.services.HttpRequestService;
import com.example.utils.ErrorCode;
import com.example.utils.LogUtil;
import org.apache.http.Header;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Baozilover
 */
public class HttpRequestServiceImpl implements HttpRequestService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    private final String url = "http://web.juhe.cn/constellation/getAll?consName=%type=today&key=%";
    private final String faqServer = "http://127.0.0.1:9999/anyq?question=%";

    private final RequestConfig requestConfig = RequestConfig.custom()
            .setConnectionRequestTimeout(5000)
            .setConnectTimeout(5000)
            .setSocketTimeout(5000)
            .build();

    private final Header[] defaultHeaders = {new BasicHeader("charset", "utf-8"),
            new BasicHeader("content-type", "application/json")};

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    @Override
    public Object post() throws CustomException {
        HttpGet get = new HttpGet(url);
        get.setHeaders(defaultHeaders);
        get.setConfig(requestConfig);
        try {
            CloseableHttpResponse response = httpClient.execute(get);

        } catch (Exception e) {
            LogUtil.exception(e);
        }
        return null;
    }

    @Override
    public Object sendFaqRequest(String username, String question) throws CustomException {
        UserInfo userInfo = userInfoRepository.getByUsername(username).orElseThrow(() -> new CustomException(ErrorCode.E00001));
        question = userInfo.getConstellation() + question;
        HttpGet get = new HttpGet(String.format(faqServer, question));
        try {
            CloseableHttpResponse response = httpClient.execute(get);
            return response;
        } catch (Exception e) {
            LogUtil.exception(e);
        }
        throw new CustomException(ErrorCode.E00001);
    }
}
