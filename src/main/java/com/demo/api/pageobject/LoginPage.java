package com.demo.api.pageobject;

import com.demo.api.dto.request.LoginRequest;
import com.demo.api.dto.response.regrister.ResgristerResponseData;
import com.demo.api.dto.response.regrister.ResgristerResponseObject;
import com.demo.api.services.LoginService;

public class LoginPage {
    LoginService loginService;

    public LoginPage() {
        loginService=new LoginService();
    }

    public String getTokenLogin(LoginRequest loginRequest){
        ResgristerResponseObject registerResponse= loginService.postLogin(loginRequest);
        ResgristerResponseData resgristerResponseData = registerResponse.getData();
        return resgristerResponseData.getToken();
    }
}
