package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Locators located on the catalog navigation page.
 * */
public class CatalogNavigationElements {

    @FindBy(xpath = "(//*[text()='Электроника'])[1]")
    public static WebElement electronicsLink;

    @FindBy(xpath = "((//div[@class='catalog-navigation-list__aside-item'])[1]/div)[1]")
    public static WebElement mobilePhonesMenuLink;

    @FindBy(xpath = "(//*[@class='catalog-navigation-list__dropdown']//*[contains(normalize-space(text()),'Мобильные телефоны')])[1]")
    public static WebElement mobilePhonesSubLink;

    @FindBy(xpath = "(//*[@class='b-main-navigation__text'])[3]")
    public static WebElement autoFleaMarketLink;

    @FindBy(xpath = "(//*[text()='Мото'])[2]")
    public static WebElement motorbikeMenuLink;
}