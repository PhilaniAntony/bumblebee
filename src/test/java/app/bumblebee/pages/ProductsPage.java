package app.bumblebee.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage{

    @FindBy(className = "product_label")
    public WebElement pageHeader;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean arePlaceholdersDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(pageHeader)).isDisplayed();
    }
}
