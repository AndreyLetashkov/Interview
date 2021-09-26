package pageObjects;

import constants.Urls;
import locators.HomePageElements;

public class HomePageSteps extends BasePage<HomePageElements>{

    public HomePageSteps() {
        super(new HomePageElements());
    }

    /**
     * Navigation to the Mobile Catalog.
     */
    public void openHomePage() {
        driver.get(Urls.homePage);
        driver.manage().window().maximize();
        ui.openCatalogLink.isDisplayed();
        ui.openCatalogLink.click();
    }
}