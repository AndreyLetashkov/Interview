package pageObjects;

import locators.CatalogNavigationElements;
import org.testng.Assert;

public class CatalogNavigationPageSteps extends BasePage<CatalogNavigationElements>{

    public CatalogNavigationPageSteps() {
        super(new CatalogNavigationElements());
    }

    /**
     * Navigation to the Mobile Catalog.
     */
    public void navigateToMobileCatalog() {
        ui.electronicsLink.isDisplayed();
        ui.electronicsLink.click();
        ui.mobilePhonesMenuLink.isDisplayed();
        ui.mobilePhonesMenuLink.click();
        ui.mobilePhonesSubLink.isDisplayed();
        ui.mobilePhonesSubLink.click();
    }

    /**
     * Navigation to the Mobile Catalog.
     */
    public void navigateToAutoAndMotoCatalog() {
        Assert.assertTrue(ui.autoFleaMarketLink.isDisplayed());
        ui.autoFleaMarketLink.click();
        Assert.assertTrue(ui.motorbikeMenuLink.isDisplayed());
        ui.motorbikeMenuLink.click();
    }
}