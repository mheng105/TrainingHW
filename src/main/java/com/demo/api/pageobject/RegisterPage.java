package com.demo.api.pageobject;

import com.demo.api.dto.request.RegisterRequestObject;
import com.demo.api.dto.response.regrister.ResgristerResponseData;
import com.demo.api.dto.response.regrister.ResgristerResponseObject;
import com.demo.api.services.RegisterService;


public class RegisterPage {
    RegisterService registerService;
    public RegisterPage(){
        registerService = new RegisterService();
    }

    public String getToken(RegisterRequestObject registerRequestObject){
        ResgristerResponseObject registerResponse= registerService.postRegister(registerRequestObject);
        ResgristerResponseData resgristerResponseData = registerResponse.getData();
        return resgristerResponseData.getToken();
    }

    public int getId(RegisterRequestObject registerRequestObject){
        ResgristerResponseObject registerResponse= registerService.postRegister(registerRequestObject);
        ResgristerResponseData resgristerResponseData = registerResponse.getData();
        return resgristerResponseData.getId();
    }

}
