package com.demo.api.feature;

import com.demo.api.dto.response.GetUserResponse;
import com.demo.api.dto.response.UserData;
import com.demo.api.services.GetUserService;
import org.testng.annotations.*;

import java.util.List;
import java.util.stream.Collectors;



public class Test extends BaseTest {
    GetUserService getUserService;

    @BeforeMethod
    public void setup(){
        getUserService=new GetUserService();
    }

    @Test
    public void demo(){
        GetUserResponse userResponse =getUserService.getUser(token);

        List<UserData> userDataList = userResponse.getData();

        List<UserData> filter =userDataList.stream()
                .filter(u -> u.getId() >= id)
                .collect(Collectors.toList());

        System.out.println(filter);
    }
}
