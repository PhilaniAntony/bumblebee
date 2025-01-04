package app.bumblebee.tests;

import app.bumblebee.pages.LoginPage;
import app.bumblebee.pages.ProductsPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Epic("User Management")
@Feature("User Login")
@Story("User Login Endpoint")
@Test
public class LoginTest extends BaseTest {

    protected ProductsPage productsPage;
    protected LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        super.setup();
        loginPage = new LoginPage(driver);
    }

    @Description("As a Web client, I should be able to login.")
    public void loginTest() {
        productsPage = loginPage.login(config.getUsername(), config.getPassword());
        assertTrue(productsPage.arePlaceholdersDisplayed());
    }

    @Description("As a Web client, I should not be able to login using invalid credentials.")
    @Test(dataProvider = "invalidCredentials")
    public void invalidLoginTest(String username, String password) {
        loginPage.invalidLogin(username, password);
        assertTrue(loginPage.hasLoginErrorDisplayed());
    }
}