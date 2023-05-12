package training.hw3.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import training.hw3.pages.LoginPage;

public class BaseTest {
    protected LoginPage login=new LoginPage();
    @BeforeTest
    public void open(){
        login.openBrowser();
    }

    @AfterTest
    public void close(){
        login.closeBrowser();
    }
}
