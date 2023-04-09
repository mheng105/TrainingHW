package training.hw2.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import training.hw2.pages.GooglePage;

public class BaseTest {
    protected GooglePage gg=new GooglePage();
    @BeforeTest
    public void open(){
        gg.openBrowser();
    }

    @AfterTest
    public void close(){
        gg.closeBrowser();
    }
}
