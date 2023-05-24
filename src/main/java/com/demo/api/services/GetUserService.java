package com.demo.api.services;

import com.demo.api.apipath.DemoPath;
import com.demo.api.core.BaseApi;
import com.demo.api.dto.response.GetUserResponse;
import com.demo.api.utils.ObjectMapperUtils;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetUserService extends BaseApi {
    public GetUserResponse getUser(String token) {
        RequestSpecification spec = getRequestBuilderWithToken(DemoPath.GET_USER_PATH, token);
        Response response = this.dispatchServiceRequest(spec, Method.GET);
        return ObjectMapperUtils.convertJSONStringToDTOClassByGson(response.body().asString(), GetUserResponse.class);
    }
}
