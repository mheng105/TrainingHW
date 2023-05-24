package com.demo.api.core;

import com.demo.api.dto.request.LoginRequest;
import com.demo.api.dto.request.RegisterRequestObject;
import com.demo.api.dto.response.regrister.RegisterResponseData;
import com.demo.api.pageobject.RegisterPage;
import com.demo.api.utils.DataUtils;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeSuite;

import static com.demo.api.utils.LoadConfig.LOAD_CONFIG;

public class BaseTest {
    public static String token;
    public static int id;
    public BaseTest(){

    }

    @BeforeSuite
    public void setUp(){
        RestAssured.baseURI = LOAD_CONFIG.getProperty("domain");

        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        RegisterRequestObject registerRequest = new RegisterRequestObject();
        registerRequest.setName(DataUtils.getData().getFirstName());

        String email = DataUtils.getData().getEmail();
        int password = DataUtils.getData().getPassword();

        registerRequest.setEmail(email);
        registerRequest.setPassword(password);
        new RegisterPage().getToken(registerRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(email);
        loginRequest.setPassword(password);

        RegisterResponseData res=new RegisterPage().login(loginRequest);
        token =  new RegisterPage().getTokenLogin(res);
        id=new RegisterPage().getId(res);


        System.out.println("token = " + token);
        System.out.println("id= "+id);
    }

}
