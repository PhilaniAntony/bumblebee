package app.bumblebee.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage{

    @FindBy(className = "welcome_menu")
    public WebElement welcomeMessage;
    @FindBy(xpath = "//*[contains(@id, 'location_')]")
    public List<WebElement> locations;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasMatchingLocations(String location) {
        List<String> locationNames = new ArrayList<>();

        for (int i = 0; i < locations.size(); i++){
            locationNames.add(locations.get(i).getAttribute("value"));
        }

        for(int i = 0; i < locationNames.size(); i++) {
            location.equalsIgnoreCase(locationNames.get(i));
            return true;
        }
        return false;
    }
}
