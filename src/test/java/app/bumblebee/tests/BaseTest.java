package app.bumblebee.tests;

import app.bumblebee.BumbleBee;
import app.bumblebee.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class BaseTest {

    public Config config;
    public WebDriverWait wait;
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        BumbleBee bee = new BumbleBee("chrome");
        config = bee.getConfig();
        driver = bee.getDriver();
        navigateToUrl();
    }

    public void navigateToUrl() {
        driver.manage().window().maximize();
        driver.get(config.getUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidLoginCredentials() {
        return new Object[][]{
                {"username", "password"},
                {"username", ""},
                {"", "password"},
                {"", ""}
        };
    }
}