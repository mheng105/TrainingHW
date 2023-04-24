package training.hw3.pages;

import training.hw3.base.Base;

public class LoginPage extends Base {

    private final String TXT_USERNAME="//input[@id='user-name']";
    private final String TXT_PASSWORD="//input[@id='password']";
    private final String BTN_LOGIN="//input[@id='login-button']";

    public void openBrowser() {
        action.openBrowser("Chrome",url);
        action.delayInSeconds(3);
    }

    public void navigateToPageSuccessfully(){
        action.verify(action.getTitle(),"Swag Labs");
    }

    public void loginSuccessfully(){
        action.verify(action.getCurrentUrl(),url+"inventory.html");
    }

    public void loginSaucePage(String username, String password){
        action.clear(TXT_USERNAME);
        action.sendKey(TXT_USERNAME,username);
        action.clear(TXT_PASSWORD);
        action.sendKey(TXT_PASSWORD,password);
        action.click(BTN_LOGIN);
        action.delayInSeconds(3);
    }
    public void closeBrowser() {
        action.delayInSeconds(5);
        action.close("Chrome");
    }
}
