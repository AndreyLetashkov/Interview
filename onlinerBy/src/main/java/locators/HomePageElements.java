package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Locators located on the home page.
 * */
public class HomePageElements {

    @FindBy(xpath = "(//*[@id='container']//span[contains(text(), 'Каталог')])[last()]")
    public static WebElement openCatalogLink;
}