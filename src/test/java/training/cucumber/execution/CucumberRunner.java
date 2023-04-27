package training.cucumber.execution;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = {"src/test/java/training/feature"}, glue = "stepdefinitions")
public class CucumberRunner extends AbstractTestNGCucumberTests {

}
