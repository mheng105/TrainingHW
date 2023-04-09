package training.hw2.pages;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import training.hw2.base.Base;


public class GooglePage extends Base {
    public void openBrowser() {
        action.openBrowser("Chrome","https://www.google.com.vn/");
        action.delayInSeconds(3);
    }

    public void closeBrowser() {
        action.delayInSeconds(3);
        action.close("Chrome");
    }

    public void inputInfo(){
        action.sendKey("//*[@title='Tìm kiếm']","Page Object Model");
    }

    public void click(){
        action.sendKey("//*[@title='Tìm kiếm']", Keys.ENTER);
    }

    public void verify(){
        String title=action.findWebElement("//h3").getText();
        Assert.assertTrue(title.toLowerCase().contains("page object model"));
    }
}
