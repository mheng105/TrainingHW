package training.hw3.utils.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import training.hw3.utils.AllureManager;

public class ChromeDriverManager extends DriverManager {

	@Override
	public void createDriver() {
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		AllureManager.setAllureEnvironment("https://www.saucedemo.com/","Chrome","prod");
	}
}
