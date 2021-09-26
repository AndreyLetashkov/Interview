import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.qameta.allure.*;
import pageObjects.CatalogNavigationPageSteps;
import pageObjects.CatalogPageSteps;;
import pageObjects.FilterMenuPageSteps;
import pageObjects.HomePageSteps;
import utils.DriverProvider;

public class BaseTest {

    public static final Logger log = LogManager.getLogger(BaseTest.class);

    public HomePageSteps home = new HomePageSteps();
    public CatalogNavigationPageSteps navigation = new CatalogNavigationPageSteps();
    public FilterMenuPageSteps filter = new FilterMenuPageSteps();
    public CatalogPageSteps catalog = new CatalogPageSteps();

    @BeforeTest
    public void beforeTest() { WebDriver driver = DriverProvider.startDriver();
    }

    @AfterTest

    public void afterTest() {
        takeScreenshot();
        DriverProvider.quit();
    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        WebDriver driver = DriverProvider.startDriver();
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

}