package training.hw3.utils;

import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;
import org.testng.annotations.BeforeSuite;

public class AllureManager {

    public AllureManager() {

    }

    @BeforeSuite
    public static void setAllureEnvironment(String url, String browser, String env){
        AllureEnvironmentWriter.allureEnvironmentWriter(
                ImmutableMap.<String,String> builder()
                        .put("url",url)
                        .put("browser",browser)
                        .put("env",env)
                        .build(), System.getProperty("user.dir")+"/allure-results/");
    }
}
