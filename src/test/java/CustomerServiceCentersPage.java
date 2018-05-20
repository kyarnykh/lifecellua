import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import static java.lang.Thread.sleep;


public class CustomerServiceCentersPage {

    WebDriver webDriver;

    public CustomerServiceCentersPage() {
    }

    @BeforeMethod
    public void before() {
        webDriver = new FirefoxDriver();
    }

    @AfterMethod
    public void after() {
        webDriver.close();
    }


    @DataProvider
    public Object[][] RegionCityUkr() {
        return new Object[][]{
                {1, 1, "ВІННИЦЬКА ОБЛ, ВІННИЦЯ"},
                {1, 2, "ВІННИЦЬКА ОБЛ, ГАЙСИН"},
                {1, 3, "ВІННИЦЬКА ОБЛ, КОЗЯТИН"},
        };
    }

    @DataProvider
    public Object[][] RegionCityRus() {
        return new Object[][]{
                {1, 1, "ВИННИЦКАЯ ОБЛ, ВИННИЦА"},
                {1, 2, "ВИННИЦКАЯ ОБЛ, ГАЙСИН"},
                {1, 3, "ВИННИЦКАЯ ОБЛ, КОЗЯТИН"},
        };
    }

    @DataProvider
    public Object[][] RegionCityEng() {
        return new Object[][]{
                {1, 1, "CHERKASY REGION, CHERKASSY"},
                {1, 2, "CHERKASY REGION, KANIV"},
                {1, 3, "CHERKASY REGION, KORSUN"},
        };
    }


    @Test (dataProvider = "RegionCityUkr")
    public void verifyRegionAndCityUkr(int Region, int City, String RegionCity) throws InterruptedException {

        webDriver.get("https://www.lifecell.ua/");
        LifecellHomeObjectPage lifecellHomePage = new LifecellHomeObjectPage(webDriver);
        lifecellHomePage.clickCustomerServiceButton();

        CustomerServiceCentersObjectPage customerServiceCentersObjectPage = new CustomerServiceCentersObjectPage(webDriver);
        Assert.assertEquals(customerServiceCentersObjectPage.getCurrentTittle(), "Магазини lifecell",
                "Current page is wrong");

        sleep (1000);

        Select dropdownRegion = new Select(webDriver.findElement(By.xpath("//*[@id='id_region']")));
        dropdownRegion.selectByIndex(Region);

        sleep (1000);

        Select dropdownCity = new Select(webDriver.findElement(By.xpath("//*[@id='id_town']")));
        dropdownCity.selectByIndex(City);

        Assert.assertEquals(customerServiceCentersObjectPage.getCurrentRegionCity(), RegionCity,
                "Current region and city are wrong");
    }


    @Test (dataProvider = "RegionCityRus")
    public void verifyRegionAndCityRus(int Region, int City, String RegionCity) throws InterruptedException {
        webDriver.get("https://www.lifecell.ua/ru");

        LifecellHomeObjectPage lifecellHomePage = new LifecellHomeObjectPage(webDriver);
        lifecellHomePage.clickCustomerServiceButton();

        CustomerServiceCentersObjectPage customerServiceCentersObjectPage = new CustomerServiceCentersObjectPage(webDriver);
        Assert.assertEquals(customerServiceCentersObjectPage.getCurrentTittle(), "Магазины lifecell",
                "Current page is wrong");

        sleep (1000);

        Select dropdownRegion = new Select(webDriver.findElement(By.xpath("//*[@id='id_region']")));
        dropdownRegion.selectByIndex(Region);

        sleep (1000);

        Select dropdownCity = new Select(webDriver.findElement(By.xpath("//*[@id='id_town']")));
        dropdownCity.selectByIndex(City);

        Assert.assertEquals(customerServiceCentersObjectPage.getCurrentRegionCity(), RegionCity,
                "Current region and city are wrong");
    }


    @Test (dataProvider = "RegionCityEng")
    public void verifyRegionAndCityEng(int Region, int City, String RegionCity) throws InterruptedException {
        webDriver.get("https://www.lifecell.ua/en/");

        LifecellHomeObjectPage lifecellHomePage = new LifecellHomeObjectPage(webDriver);
        lifecellHomePage.clickCustomerServiceButton();

        CustomerServiceCentersObjectPage customerServiceCentersObjectPage = new CustomerServiceCentersObjectPage(webDriver);
        Assert.assertEquals(customerServiceCentersObjectPage.getCurrentTittle(), "Customer service centers",
                "Current page is wrong");

        sleep (1000);

        Select dropdownRegion = new Select(webDriver.findElement(By.xpath("//*[@id='id_region']")));
        dropdownRegion.selectByIndex(Region);

        sleep (1000);

        Select dropdownCity = new Select(webDriver.findElement(By.xpath("//*[@id='id_town']")));
        dropdownCity.selectByIndex(City);

        Assert.assertEquals(customerServiceCentersObjectPage.getCurrentRegionCity(), RegionCity,
                "Current region and city are wrong");
    }

}
