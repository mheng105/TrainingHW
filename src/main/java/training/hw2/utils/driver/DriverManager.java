package training.hw2.utils.driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	protected WebDriver driver;
	
	protected abstract void createDriver();
	
	public WebDriver getDriver() {
		if(driver==null) {
			createDriver();
		}
		return driver;
	}
}


