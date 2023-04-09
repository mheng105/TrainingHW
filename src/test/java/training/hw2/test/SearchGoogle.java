package training.hw2.test;

import org.testng.annotations.Test;
import training.hw2.base.BaseTest;

public class SearchGoogle extends BaseTest {

    @Test
    public void search(){
        gg.inputInfo();
        gg.click();
        gg.verify();
    }
}
