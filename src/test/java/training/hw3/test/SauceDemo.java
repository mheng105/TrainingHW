package training.hw3.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import training.hw3.base.BaseTest;
import training.hw3.pages.CartPage;
import training.hw3.pages.CheckoutPage;
import training.hw3.pages.InventoryPage;
import training.hw3.utils.ExcelConfig;

import java.io.File;


public class SauceDemo extends BaseTest {
    ExcelConfig excelConfig = new ExcelConfig(System.getProperty("user.dir") + File.separator + "LoginSaucePage.xlsx");
    InventoryPage in=new InventoryPage();
    CartPage cart=new CartPage();

    CheckoutPage checkout=new CheckoutPage();
    @DataProvider
    public Object[][] dataTest() {
        return excelConfig.data();
    }

    @Test(dataProvider = "dataTest",priority = 1)
    public void login(String username, String password){
        login.navigateToPageSuccessfully();
        excelConfig.data();
        login.loginSaucePage(username, password);
        login.loginSuccessfully();
    }

    @Test(priority = 2)
    public void buy(){
        in.getName();
        in.random();
        in.addCart();
        in.addCartSuccessfully();
        in.clickCart();
        in.clickCartSuccessfully();
    }

    @Test(priority = 3)
    public void checkout(){
        cart.clickCheckout();

        checkout.fill();
        checkout.clickContinue();
        checkout.clickFinish();
        checkout.clickBack();
    }

}
