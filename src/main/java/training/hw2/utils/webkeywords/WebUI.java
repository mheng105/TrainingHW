package training.hw2.utils.webkeywords;

import java.text.MessageFormat;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;

import com.google.common.base.Function;
import training.hw2.log.LogHelper;
import training.hw2.utils.driver.DriverManager;
import training.hw2.utils.driver.DriverManagerFactory;
import training.hw2.utils.driver.DriverType;

public class WebUI {
	private static Logger logger = LogHelper.getLogger();
	private static DriverManager driverManager;

	public WebUI() {

	}

	// web element command
	public void click(String locator) {
		try {

			WebElement we = findWebElement(locator);
			logger.info(MessageFormat.format("Clicking web element located by ''{0}'' ", locator));
			if (we.isEnabled()) {
				we.click();
				logger.info(MessageFormat.format("Clicked web element located by ''{0}'' successfully", locator));
			} else {
				logger.error(MessageFormat.format(
						"Cannot click web element located by ''{0}''. Root cause: Web element is not enable", locator));
			}

		} catch (Exception e) {
			logger.error(MessageFormat.format("Cannot click web element located by ''{0}''. Root cause: {1}", locator,
					e.getMessage()));
		}

	}

	public void click(WebElement we) {
		try {
			logger.info(MessageFormat.format("Clicking web element located by ''{0}'' ", we));
			if (we.isEnabled()) {
				we.click();
				logger.info(MessageFormat.format("Clicked web element located by ''{0}'' successfully", we));
			} else {
				logger.error(MessageFormat.format(
						"Cannot click web element located by ''{0}''. Root cause: Web element is not enable", we));
			}

		} catch (Exception e) {
			logger.error(MessageFormat.format("Cannot click web element located by ''{0}''. Root cause: {1}", we,
					e.getMessage()));
		}
	}

	public void close(String browser) {
		logger.info(MessageFormat.format("Closing {0} browser ", browser.toUpperCase()));
		try {
			WebDriver driver = driverManager.getDriver();
			driver.close();
			logger.info(MessageFormat.format("Closed {0} browser successfully", browser.toUpperCase()));
		} catch (Exception e) {
			logger.error(MessageFormat.format("Cannot close browser {0}. Root cause: {1}", browser, e.getMessage()));
		}
	}

	public void delayInSeconds(int seconds) {
		logger.info(MessageFormat.format("Delaying ''{0}'' seconds", seconds));
		try {
			Thread.sleep(seconds * 1000);
			logger.info(MessageFormat.format("Delayed ''{0}'' seconds successfully", seconds));
		} catch (Exception e) {
			logger.error(MessageFormat.format("Cannot delay ''{0}'' seconds. Root cause: {0} ", e.getMessage()));
		}
	}
	public WebElement findWebElement(String locator) {
		WebDriver driver = driverManager.getDriver();
		logger.info(MessageFormat.format("Finding web element located by ''{0}''", locator));
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
			WebElement we = wait.until(new Function<WebDriver, WebElement>() {
				@Override
				public WebElement apply(WebDriver t) {
					// TODO Auto-generated method stub
					return driver.findElement(By.xpath(locator));
				}
			});
			if (we != null) {
				logger.info(MessageFormat.format("Found {0} web element located by ''{1}''", 1, locator));
				return we;
			} else {
				logger.error(MessageFormat.format("Cannot find web element located by ''{0}''", locator));
			}
		} catch (TimeoutException e) {
			logger.error(MessageFormat.format("Cannot find web element located by ''{0}''. Root cause: {1}", locator,
					e.getMessage()));
		}
		return null;
	}

	public List<WebElement> findElements(String locator) {
		WebDriver driver = driverManager.getDriver();
		logger.info(MessageFormat.format("Finding the web elements located by {0}", locator));
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
			List<WebElement> we = wait.until(new Function<WebDriver, List<WebElement>>() {
				@Override
				public List<WebElement> apply(WebDriver input) {
					return driver.findElements(By.xpath(locator));
				}
			});
			if (we != null) {
				logger.info(MessageFormat.format("Found ''{0}'' web element located by ''{1}''", we.size(), locator));
				return we;
			} else {
				logger.error(MessageFormat.format("Cannot find web element located by ''{0}''", locator));
			}
		} catch (TimeoutException e) {
			logger.error(MessageFormat.format("Cannot find web element located by ''{0}''. Root cause: {1}", locator,
					e.getMessage()));
		}
		return null;
	}

	public String getAttribute(String locator, String name) {
		WebDriver driver = driverManager.getDriver();
		logger.info(MessageFormat.format("Getting attribute ''{0}'' of the element located by {1}", name, locator));
		WebElement we = driver.findElement(By.xpath(locator));
		String value = null;
		try {
			value = we.getAttribute(name);
			logger.info(
					MessageFormat.format("Got attribute ''{0}'' of the element located by ''{1}'' is {2} successfully",
							name, locator, value));
			return value;
		} catch (Exception e) {
			logger.error(MessageFormat.format("Cannot get attribute. Root cause: {0}", e.getMessage()));
			return value;
		}

	}

	// -----------------------WEBDRIVER BROWSER COMMAND------------------------

	public static String getCurrentUrl() {
		WebDriver driver = driverManager.getDriver();
		logger.info("Preparing to get current url");
		String currentUrl = null;
		try {
			currentUrl = driver.getCurrentUrl();
			logger.info(MessageFormat.format("Got current url {0} successfully", currentUrl));
			return currentUrl;
		} catch (Exception e) {
			logger.error(
					MessageFormat.format("Cannot get current url {0}. Root cause: {1}", currentUrl, e.getMessage()));
			return currentUrl;
		}
	}

	public String getTitle() {
		WebDriver driver = driverManager.getDriver();
		logger.info("Preparing to get title ");
		String pageTitle = null;
		try {
			pageTitle = driver.getTitle();
			logger.info(MessageFormat.format("Got the title: {0} successfully", pageTitle));
			return pageTitle;
		} catch (Exception e) {
			logger.error(MessageFormat.format("Cannot get title. Root cause: {0}", e.getMessage()));
			return pageTitle;
		}
	}

	public String getPageSource() {
		WebDriver driver = driverManager.getDriver();
		logger.info("Preparing to get the page source");
		String pageSource = null;
		try {
			pageSource = driver.getPageSource();
			logger.info(MessageFormat.format("The page source is: {0}", pageSource));
			return pageSource;
		} catch (Exception e) {
			logger.error(MessageFormat.format("Cannot find the page source. Root cause: {0}", e.getMessage()));
			return pageSource;
		}
	}

	public String getCssValue(String locator, String property) {
		WebDriver driver = driverManager.getDriver();
		WebElement we = driver.findElement(By.xpath(locator));
		logger.info(
				MessageFormat.format("Getting the css value ''{0}'' of the element located by {1}", property, locator));
		String value = null;
		try {
			value = we.getCssValue(property);
			logger.info(
					MessageFormat.format("Got property ''{0}'' of the element located by ''{1}'' is {2} successfully",
							property, locator, value));
			return value;
		} catch (Exception e) {
			logger.error(MessageFormat.format("Cannot get property. Root cause: {0}", e.getMessage()));
			return value;
		}

	}

	public WebElement getFirstOpt(String locator) {
		WebElement we = findWebElement(locator);
		WebElement firstOpt = null;
		try {
			Select se = new Select(we);
			logger.info(
					MessageFormat.format("Getting the first selected option of the element located by {0}", locator));
			firstOpt = se.getFirstSelectedOption();
			logger.info(MessageFormat.format("Got the first selected option of the element located by {0} successfully",
					locator));
			String opt = se.getFirstSelectedOption().getText();
			logger.info(MessageFormat.format("The first selected option is {0}", opt));
			return firstOpt;
		} catch (Exception e) {
			logger.error(MessageFormat.format("Cannot get first selected option. Root cause: {0}", e.getMessage()));
			return firstOpt;
		}
	}

	public int getIndex(String value, String locator) {
		List<WebElement> elements = findElements(locator);
		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).getText().equals(value)) {
				return i;
			}
		}
		return -1;
	}

	public Point getLocation(String locator) {
		WebDriver driver = driverManager.getDriver();
		logger.info(MessageFormat.format("Getting the point of the element located by ''{0}'' ", locator));
		WebElement we = driver.findElement(By.xpath(locator));
		Point point = null;
		try {
			point = we.getLocation();
			logger.info(MessageFormat.format(
					"Got the x cordinate ''{0}'' and y cordinate ''{1}'' of the element located by ''{2}''", point.x,
					point.y, locator));
			return point;
		} catch (Exception e) {
			logger.error(
					MessageFormat.format("Cannot get the location of the element. Root cause: {0}", e.getMessage()));
			return point;
		}
	}

	public void getTagName(String locator) {
		WebDriver driver = driverManager.getDriver();
		WebElement we = driver.findElement(By.xpath(locator));
		logger.info("Getting the tagname");
		try {
			we.getTagName();
			logger.info(MessageFormat.format("Got tag name ''{0}'' of the element located by {1} successfully",
					we.getTagName(), locator));
		} catch (Exception e) {
			logger.error(MessageFormat.format("Cannot get tag name. Root cause: {0}", e.getMessage()));
		}

	}

	public String getText(String locator) {
		WebDriver driver = driverManager.getDriver();
		WebElement we = driver.findElement(By.xpath(locator));
		logger.info("Getting text");
		try {
			String actualText = we.getText();
			logger.info(MessageFormat.format("Got text ''{0}'' of the element located by {1} successfully", actualText,
					locator));
			return actualText;
		} catch (Exception e) {
			logger.error(MessageFormat.format("Cannot get text. Root cause: {0}", e.getMessage()));
		}
		return null;
	}

	public void getUrl(String url) {
		WebDriver driver = driverManager.getDriver();
		logger.info(MessageFormat.format("Navigating to ''{0}''", url));
		try {
			driver.get(url);
			logger.info(MessageFormat.format("Navigated to ''{0}'' successfully", url));
		} catch (Exception e) {
			logger.error(MessageFormat.format("Cannot navigate to {0}. Root cause: {1}", url, e.getMessage()));
		}
	}

	public List<WebElement> getOpt(String locator) {
		WebElement we = findWebElement(locator);
		List<WebElement> elements = null;
		try {
			Select se = new Select(we);
			logger.info(MessageFormat.format("Getting options of the element located by {0}", locator));
			elements = se.getOptions();
			logger.info(MessageFormat.format("Got options of the element located by {0} successfully. The options: ",
					locator));
			String value = null;
			for (int i = 0; i < elements.size(); i++) {
				value = elements.get(i).getText();
				logger.info(value);
			}
			return elements;
		} catch (Exception e) {
			logger.error(MessageFormat.format("Cannot get options. Root cause: {0}", e.getMessage()));
			return elements;
		}
	}

	public Dimension getSize(String locator) {
		WebDriver driver = driverManager.getDriver();
		logger.info(MessageFormat.format("Getting the size of the element located by {0} ", locator));
		WebElement we = driver.findElement(By.xpath(locator));
		Dimension dimension = null;
		try {
			dimension = we.getSize();
			logger.info(MessageFormat.format("Got the size of the element located by {0} is {1}", locator, dimension));
			return dimension;
		} catch (Exception e) {
			logger.error(MessageFormat.format("Cannot get the size of the element. Root cause: {0}", e.getMessage()));
			return dimension;
		}

	}

	public void maximizeWindow() {
		logger.info("Maximizing the window");
		try {
			WebDriver driver = driverManager.getDriver();
			driver.manage().window().maximize();
			logger.info("Maximized the window successfully");
		} catch (Exception e) {
			logger.error(MessageFormat.format("Cannot maximize the window. Root cause: {0}", e.getMessage()));
		}

	}

	/// ----------------------------------------------------------------------/////
	/// ------------------NAVIGATION COMMAND----------------------------------/////

	public void navigateToUrl(String url) {
		WebDriver driver = driverManager.getDriver();
		logger.info(MessageFormat.format("Navigating to {0}", url));
		try {
			driver.navigate().to(url);
			logger.info(MessageFormat.format("Navigated to {0} successfully", url));
		} catch (Exception e) {
			logger.error(MessageFormat.format("Cannot navigate to {0}. Root cause: {1}", url, e.getMessage()));
		}

	}
	
	public void open(String browser, String... url) {

		driverManager = DriverManagerFactory.getManager(DriverType.valueOf(browser.toUpperCase()));
		logger.info(MessageFormat.format("Launching ''{0}'' browser", browser));
		try {
			driverManager.getDriver();
			logger.info(MessageFormat.format("Launched ''{0}'' browser successfully", browser));
		} catch (Exception e) {
			logger.error(MessageFormat.format("Cannot launch {0} browser. Root cause: {1} ", browser, e.getMessage()));
		}
		
		String rawUrl=url.length >0 ? url[0]:"";
		
		try {
			if(rawUrl !=null && !rawUrl.isEmpty()) {
				WebDriver driver = driverManager.getDriver();
				logger.info(MessageFormat.format("Navigating to ''{0}''", rawUrl));
				driver.get(rawUrl);
			}
			logger.info(MessageFormat.format("Navigated to ''{0}'' successfully", rawUrl));
		} catch (Exception e) {
			logger.error(MessageFormat.format("Cannot navigate to {0}. Root cause: {1}", rawUrl, e.getMessage()));
		}
	}

	public void openBrowser(String browser, String url) {

		driverManager = DriverManagerFactory.getManager(DriverType.valueOf(browser.toUpperCase()));
		logger.info(MessageFormat.format("Launching ''{0}'' browser", browser));
		try {
			driverManager.getDriver();
			logger.info(MessageFormat.format("Launched ''{0}'' browser successfully", browser));
		} catch (Exception e) {
			logger.error(MessageFormat.format("Cannot launch {0} browser. Root cause: {1} ", browser, e.getMessage()));
		}
		logger.info(MessageFormat.format("Navigating to ''{0}''", url));
		try {
			WebDriver driver = driverManager.getDriver();
			driver.get(url);
			logger.info(MessageFormat.format("Navigated to ''{0}'' successfully", url));
		} catch (Exception e) {
			logger.error(MessageFormat.format("Cannot navigate to {0}. Root cause: {1}", url, e.getMessage()));
		}
	}

	public void sendKey(String locator, String value) {
		try {
			WebElement we = findWebElement(locator);
			logger.info(MessageFormat.format("Sending keys to the web element located by {0}", locator));
			we.sendKeys(value);
			logger.info(MessageFormat.format("Sent keys to the web element located by {0} successfully", locator));
		} catch (Exception e) {
			logger.error(MessageFormat.format("Cannot send key to the web element located by {0}. Root cause: {1}",
					locator, e.getMessage()));
		}
	}

	public void sendKey(String locator, Keys value) {
		try {
			WebElement we = findWebElement(locator);
			logger.info(MessageFormat.format("Sending keys to the web element located by {0}", locator));
			we.sendKeys(value);
			logger.info(MessageFormat.format("Sent keys to the web element located by {0} successfully", locator));
		} catch (Exception e) {
			logger.error(MessageFormat.format("Cannot send key to the web element located by {0}. Root cause: {1}",
					locator, e.getMessage()));
		}
	}
}
