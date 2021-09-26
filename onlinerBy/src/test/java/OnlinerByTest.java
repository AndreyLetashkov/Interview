import enumeration.Data;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OnlinerByTest extends  BaseTest {

    @Link("https://catalog.onliner.by/mobile?mfr%5B0%5D=apple")
    @Step("Checking the cost phone")
    @Test(description = "Is cost of first apple phone more than 100 in catalog test?")
    public void verifyCostOfFirstApplePhoneIsMoreThen100InCatalogTest() {
        home.openHomePage();
        navigation.navigateToMobileCatalog();
        log.info("Open Home Page and navigate to the Mobile Catalog.");
        filter.filterByAppleVendor();
        log.info("In the Mobile Catalog filter by Apple vendor.");
        int firstPhoneCost = catalog.getCostPhoneStep();
        log.info("The cost of the first phone from the Catalog list equals to " + firstPhoneCost + " BYN.");
        Assert.assertTrue(firstPhoneCost > Data.PRICE.getDataInt(),
                "The phone cost is less then " + Data.PRICE.getDataInt());
    }

    @Link("https://mb.onliner.by/#max-price=8000&min-year=2012&currency=USD&sort[]=last_time_up&page=1&moto[0][24]=")
    @Step("Numbers check")
    @Test(description = "Is number kawasaki motorbikes equals 20 in catalog test?")
    public void verifyNumberKawasakiMotorbikesInCatalogTest() {
        home.openHomePage();
        navigation.navigateToAutoAndMotoCatalog();
        log.info("Open Home Page and navigate to the Auto Flea Market.");
        filter.filterByKawasaki();
        log.info("In the Motorbikes Catalog filter by Kawasaki younger than 2012 costing up to 8000$.");
        int motorbikes = catalog.getNumberOfMotorbikesStep();
        log.info("The number of kawasaki motorbikes from the Catalog list is " + motorbikes);
        Assert.assertTrue(motorbikes == Data.NUMBER_MOTORBIKES.getDataInt(),
                "The Number of kawasaki motorbikes isn't " + Data.NUMBER_MOTORBIKES.getDataInt());
    }
}