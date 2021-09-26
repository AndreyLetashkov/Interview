package pageObjects;

import enumeration.Data;
import locators.FilterMenuElements;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FilterMenuPageSteps extends BasePage<FilterMenuElements> {

    public FilterMenuPageSteps() {
        super(new FilterMenuElements());
    }

    /**
     * The method to filter by vendor.
     */
    public void filterByAppleVendor() {
        ui.appleCheckbox.isDisplayed();
        ui.appleCheckbox.click();
    }

    public void filterByKawasaki() {
        Assert.assertTrue(ui.maxPriceCheckbox.isDisplayed());
        new Select(ui.maxPriceCheckbox).selectByVisibleText(Data.COST.getDataString());
        Assert.assertTrue(ui.minYearCheckbox.isDisplayed());
        new Select(ui.minYearCheckbox).selectByVisibleText(Data.MIN_YEARE.getDataString());
        Assert.assertTrue(ui.brandCheckbox.isDisplayed());
        new Select(ui.brandCheckbox).selectByValue(Data.BRAND.getDataString());
    }
}
