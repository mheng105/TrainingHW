package com.demo.api.services;

import com.demo.api.apipath.DemoPath;
import com.demo.api.core.BaseApi;
import com.demo.api.dto.request.LoginRequest;
import com.demo.api.dto.request.RegisterRequestObject;
import com.demo.api.dto.response.regrister.RegisterResponseObject;
import com.demo.api.utils.ObjectMapperUtils;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RegisterService extends BaseApi {
    public RegisterResponseObject postRegister (RegisterRequestObject registerRequestObject){
        RequestSpecification spec = getRequestBuilderWithoutToken(DemoPath.REGISTER_PATH)
                .body(ObjectMapperUtils.convertDTOClassToJSONStringGson(registerRequestObject));

        Response response = this.dispatchServiceRequest(spec, Method.POST);
        return ObjectMapperUtils.convertJSONStringToDTOClassByGson(response.body().asString(), RegisterResponseObject.class);
    }

    public RegisterResponseObject postLogin(LoginRequest loginRequest){
        RequestSpecification spec = getRequestBuilderWithoutToken(DemoPath.LOGIN_PATH)
                .body(ObjectMapperUtils.convertDTOClassToJSONStringGson(loginRequest));

        Response response = this.dispatchServiceRequest(spec, Method.POST);
        return ObjectMapperUtils.convertJSONStringToDTOClassByGson(response.body().asString(), RegisterResponseObject.class);
    }
}
