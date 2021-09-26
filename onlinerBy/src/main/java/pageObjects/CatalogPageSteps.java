package pageObjects;

import locators.CatalogElements;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CatalogPageSteps extends BasePage<CatalogElements> {

    public CatalogPageSteps() {
        super(new CatalogElements());
    }

    /**
     * The method returns the cost of the mobile phone.
     * return int.
     */
    public int getCostPhoneStep() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ui.productNameLink)));
        return Integer.parseInt(ui.firstPhoneCostLink.getText().substring(0, ui.firstPhoneCostLink.getText().indexOf(',')));
    }

    /**
     * The method returns number of motorbikes.
     * return int.
     */
    public int getNumberOfMotorbikesStep() {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath(ui.allProductByMotoNameLink))));
        return Integer.parseInt(ui.countAds.getText());
    }
}