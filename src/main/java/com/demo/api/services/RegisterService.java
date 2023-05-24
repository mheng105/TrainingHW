package com.demo.api.services;

import com.demo.api.apipath.DemoPath;
import com.demo.api.core.BaseApi;
import com.demo.api.dto.request.LoginRequest;
import com.demo.api.dto.request.RegisterRequestObject;
import com.demo.api.dto.response.regrister.ResgristerResponseObject;
import com.demo.api.utils.ObjectMapperUtils;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RegisterService extends BaseApi {
    public ResgristerResponseObject postRegister (RegisterRequestObject resgristerRequestObject){
        RequestSpecification spec = getRequestBuilderWithoutToken(DemoPath.REGISTER_PATH)
                .body(ObjectMapperUtils.convertDTOClassToJSONStringGson(resgristerRequestObject));

        Response response = this.dispatchServiceRequest(spec, Method.POST);
        return ObjectMapperUtils.convertJSONStringToDTOClassByGson(response.body().asString(),ResgristerResponseObject.class);
    }

    public  ResgristerResponseObject postLogin(LoginRequest loginRequest){
        RequestSpecification spec = getRequestBuilderWithoutToken(DemoPath.LOGIN_PATH)
                .body(ObjectMapperUtils.convertDTOClassToJSONStringGson(loginRequest));

        Response response = this.dispatchServiceRequest(spec, Method.POST);
        return ObjectMapperUtils.convertJSONStringToDTOClassByGson(response.body().asString(),ResgristerResponseObject.class);
    }
}
