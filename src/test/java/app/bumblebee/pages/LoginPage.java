package app.bumblebee.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    @FindBy(id = "username")
    public WebElement usernameField;
    @FindBy(id = "password")
    public WebElement passwordField;
    @FindBy(id = "login")
    public WebElement loginButton;
    @FindBy(className = "auth_error")
    public WebElement authError;
    @FindBy(id = "username_span")
    public WebElement usernameSpan;
    @FindBy(id = "password_span")
    public WebElement passwordSpan;

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
        return wait.until(ExpectedConditions.visibilityOf(authError)).isDisplayed();
    }

    public String getLoginError(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }
}
