package utils;

import locators.CatalogElements;
import locators.CatalogNavigationElements;
import locators.FilterMenuElements;
import locators.HomePageElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * WebDriver initialization.
 */
public class DriverProvider {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public static WebDriver startDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "D:\\QA12\\Project\\OnlinerBy\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, 10);
            org.openqa.selenium.support.PageFactory.initElements(driver, HomePageElements.class);
            org.openqa.selenium.support.PageFactory.initElements(driver, CatalogNavigationElements.class);
            org.openqa.selenium.support.PageFactory.initElements(driver, FilterMenuElements.class);
            org.openqa.selenium.support.PageFactory.initElements(driver, CatalogElements.class);
        }
        return driver;
    }

    public static void quit() {
        driver.quit();
    }
}