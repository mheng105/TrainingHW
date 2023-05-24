package com.demo.api.core;

import com.demo.api.dto.request.LoginRequest;
import com.demo.api.dto.request.RegisterRequestObject;
import com.demo.api.pageobject.ResgristerPage;
import com.demo.api.utils.DataUtils;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeSuite;

import static com.demo.api.utils.LoadConfig.LOAD_CONFIG;

public class BaseTest {
    public static String token;
    public BaseTest(){

    }

    @BeforeSuite
    public void setUp(){
        RestAssured.baseURI = LOAD_CONFIG.getProperty("domain");

        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        RegisterRequestObject resgristerRequest = new RegisterRequestObject();
        resgristerRequest.setName(DataUtils.getData().getFirstName());

        String email = DataUtils.getData().getEmail();
        int password = DataUtils.getData().getPassword();
        resgristerRequest.setEmail(email);
        resgristerRequest.setPassword(password);
        new ResgristerPage().getToken(resgristerRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(email);
        loginRequest.setPassword(password);
        token =  new ResgristerPage().getTokenLogin(loginRequest);

        System.out.println("token = " + token);
    }

}
