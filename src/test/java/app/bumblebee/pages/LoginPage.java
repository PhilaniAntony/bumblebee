package app.bumblebee.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    @FindBy(id = "user-name")
    public WebElement usernameField;
    @FindBy(id = "password")
    public WebElement passwordField;
    @FindBy(id = "login-button")
    public WebElement loginButton;
    @FindBy(css = "[data-test='error']")
    public WebElement loginError;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage login(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(usernameField)).sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        return new ProductsPage(driver);
    }

    public void invalidLogin(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(usernameField)).sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public boolean hasLoginErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(loginError)).isDisplayed();
    }
}
