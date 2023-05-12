package training.cucumber.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import training.hw3.Context;
import training.hw3.pages.InventoryPage;
import training.hw3.pages.LoginPage;
import training.hw3.utils.TestContext;

import java.util.List;

public class MyStepdefs {
    public TestContext testContext;
    LoginPage loginPage=new LoginPage();
    InventoryPage inventoryPage=new InventoryPage();

    public MyStepdefs(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("user logins as {string}")
    public void userLoginsAs(String user) {
        loginPage.openBrowser();
        loginPage.loginSaucePage(user,"secret_sauce");
        loginPage.loginSuccessfully();
    }

    @And("add two products into the cart")
    public void addTwoProductsIntoTheCart() {
        inventoryPage.getName();
        testContext.scenarioContext.setContext(Context.PRODUCT_NAME, inventoryPage.random());
        inventoryPage.addCart();
        inventoryPage.addCartSuccessfully();
    }

    @When("user checks the cart")
    public void userChecksTheCart() {
        inventoryPage.clickCart();
    }

    @Then("numbers of cart shows")
    public void numbersOfCartShows() {
        List<String> productNames=(List<String>)testContext.scenarioContext.getContext(Context.PRODUCT_NAME);
        System.out.println(productNames);
        inventoryPage.clickCartSuccessfully();
    }
}
