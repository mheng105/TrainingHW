package training.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/feature"}
//        glue = "classpath:src/test/java/training/cucumber/stepdefinitions"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}
