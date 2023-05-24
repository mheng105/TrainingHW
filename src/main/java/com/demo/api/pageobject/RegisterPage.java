package com.demo.api.pageobject;

import com.demo.api.dto.request.LoginRequest;
import com.demo.api.dto.request.RegisterRequestObject;
import com.demo.api.dto.response.regrister.RegisterResponseData;
import com.demo.api.dto.response.regrister.RegisterResponseObject;
import com.demo.api.services.RegisterService;


public class RegisterPage {
    RegisterService registerService;
    public RegisterPage(){
        registerService = new RegisterService();
    }

    public String getToken(RegisterRequestObject registerRequestObject){
        RegisterResponseObject registerResponse= registerService.postRegister(registerRequestObject);
        RegisterResponseData registerResponseData = registerResponse.getData();
        return registerResponseData.getToken();
    }

    public RegisterResponseData login(LoginRequest loginRequest){
        RegisterResponseObject registerResponse= registerService.postLogin(loginRequest);
        RegisterResponseData registerResponseData = registerResponse.getData();
        return registerResponseData;
    }

    public String getTokenLogin(RegisterResponseData registerResponseData){
        return registerResponseData.getToken();
    }

    public int getId(RegisterResponseData registerResponseData){
        return registerResponseData.getId();
    }

}
