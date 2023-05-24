package com.demo.api.feature;

import com.demo.api.core.BaseTest;
import com.demo.api.services.GetUserService;
import org.testng.annotations.*;


public class TestDemo extends BaseTest {
    GetUserService getUserService;

    @BeforeMethod
    public void setup(){
        getUserService=new GetUserService();
    }

    @Test
    public void demo(){
        getUserService.getUser(token);
    }
}
