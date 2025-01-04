package app.bumblebee;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BumbleBee {

    private static Config config;
    private static WebDriver driver;

    public BumbleBee(String browserName) {
        loadConfig();
        setupWebDriver(browserName);
    }

    private static void loadConfig() {
        PropertyLoader loader = new PropertyLoader();
        config = new Config(loader.getProperties());
    }

    public void setupWebDriver(String browserName) {

        switch (browserName) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Please provide a valid browser.");
        }

        driver.manage().deleteAllCookies();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Config getConfig() {
        return config;
    }
}