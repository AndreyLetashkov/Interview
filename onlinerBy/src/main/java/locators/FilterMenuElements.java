package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Locators located in the Filter menu.
 */
public class FilterMenuElements {

    @FindBy(xpath = "(//input[@value='apple']//..//*[@class='i-checkbox__faux'])[1]")
    public static WebElement appleCheckbox;

    @FindBy(css = "[name='models_manufactures_id[]']")
    public static WebElement brandCheckbox;

    @FindBy(css = "[name='max-price']")
    public static WebElement maxPriceCheckbox;

    @FindBy(css = "[name='min-year']")
    public static WebElement minYearCheckbox;
}