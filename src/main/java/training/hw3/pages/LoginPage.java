package training.hw3.pages;

import io.qameta.allure.Step;
import training.hw3.base.Base;

public class LoginPage extends Base {

    private final String TXT_USERNAME="//input[@id='user-name']";
    private final String TXT_PASSWORD="//input[@id='password']";
    private final String BTN_LOGIN="//input[@id='login-button']";

    @Step("Open browser")
    public void openBrowser() {
        action.openBrowser("Chrome",url);
        action.delayInSeconds(3);
    }

    @Step("Navigate to home page successfully")
    public void navigateToPageSuccessfully(){
        action.verify(action.getTitle(),"Swag Labs");
    }

    @Step("Login successfully")
    public void loginSuccessfully(){
        action.verify(action.getCurrentUrl(),url+"inventory.html");
    }

    @Step("Login to Sauce Page")
    public void loginSaucePage(String username, String password){
        action.clear(TXT_USERNAME);
        action.sendKey(TXT_USERNAME,username);
        action.clear(TXT_PASSWORD);
        action.sendKey(TXT_PASSWORD,password);
        action.click(BTN_LOGIN);
        action.delayInSeconds(3);
    }

    @Step("Close browser")
    public void closeBrowser() {
        action.delayInSeconds(5);
        action.close("Chrome");
    }
}
