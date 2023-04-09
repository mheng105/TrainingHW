package training.hw2.utils.driver;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager extends DriverManager {

	@Override
	public void createDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
}
