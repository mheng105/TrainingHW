package training.hw3.utils.driver;


public class DriverManagerFactory {
	public static DriverManager getManager(DriverType type) {

        DriverManager driverManager;
        
        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            default:
                driverManager = new FirefoxDriverManager();
                break;
        }
        return driverManager;

    }
}
