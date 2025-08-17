package app.bumblebee.tests;

import app.bumblebee.pages.LoginPage;
import app.bumblebee.pages.ProductsPage;
import app.bumblebee.pages.SearchResultsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Epic("Search Location")
@Feature("Filter By Location")
@Story("Filter By Location")
@Test
public class SearchLocationTest extends BaseTest{

    public ProductsPage productsPage;
    public LoginPage loginPage;
    public SearchResultsPage searchResultsPage;

    @BeforeMethod
    public void setup() {
        super.setup();
        loginPage = new LoginPage(driver);
        productsPage = loginPage.login(config.getUsername(), config.getPassword());
    }

    @Description("As a Web client, I should be able to filter hotels by location.")
    @Test(dataProvider = "citiesList")
    public void searchByLocationTest(String city) {
        productsPage.selectLocation(city);
        searchResultsPage = productsPage.clickSubmitButton();
        assertTrue(searchResultsPage.hasMatchingLocations(city));
    }
}