package app.bumblebee.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage{

    @FindBy(id = "username_show")
    public WebElement username;
    @FindBy(id = "location")
    public WebElement location;
    @FindBy(id = "Submit")
    public WebElement submitButton;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean arePlaceholdersDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(username)).isDisplayed();
    }

    public void selectLocation(String locationOption) {
        wait.until(ExpectedConditions.elementToBeClickable(location)).click();
        driver.findElement(By.xpath("//option[contains(text(), '" + locationOption + "')]")).click();
    }

    public SearchResultsPage clickSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).submit();
        return new SearchResultsPage(driver);
    }
}
