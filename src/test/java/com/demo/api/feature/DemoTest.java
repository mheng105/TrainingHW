package com.demo.api.feature;

import com.demo.api.core.BaseTest;
import com.demo.api.dto.response.GetUserResponse;
import com.demo.api.dto.response.UserData;
import com.demo.api.services.ResgristerService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class DemoTest extends BaseTest {

    ResgristerService resgristerService;

    @BeforeMethod
    public void setup(){
        resgristerService = new ResgristerService();
    }
    @Test
    public void demo(){
        GetUserResponse userResponse =resgristerService.getAllUser(token);

        List<UserData>  userDataList = userResponse.getData();

        List<UserData> filter =userDataList.stream()
                        .filter(u -> u.getId() >= 11143)
                                .collect(Collectors.toList());

        System.out.println(filter);
    }
}
