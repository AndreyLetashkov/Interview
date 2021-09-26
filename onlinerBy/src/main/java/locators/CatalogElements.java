package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Locators located on the catalog page.
 * */
public class CatalogElements {

    public static final String productNameLink = "(//*[@id='schema-products']//*[contains(text(), 'Apple')])[1]";
    public static final String allProductByMotoNameLink = "//*[@class='motoRow ']//*[contains(text(),'Kawasaki')]";

    @FindBy(xpath = "//strong[@class='count']")
    public static WebElement countAds;
    @FindBy(xpath = "((//*[@id='schema-products']//*[contains(text(), 'Apple')])[1]//..//..//..//..//span)[1]")
    public static WebElement firstPhoneCostLink;
}