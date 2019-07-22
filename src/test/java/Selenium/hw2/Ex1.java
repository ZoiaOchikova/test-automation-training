package Selenium.hw2;

import Selenium.hw1.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Ex1 {
    private Utils utils;
    private RemoteWebDriver driver;
    private SoftAssert softAssert;

    @BeforeSuite
    public void setUpSuite(){
        utils = new Utils();
    }

    @BeforeMethod
    public void setUp() {
        driver = utils.getDriver("chrome");
        softAssert = new SoftAssert();
        utils.setUpSuite("https://epam.github.io/JDI/index.html", 1000, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void teardown(){
        driver.close();
        softAssert.assertAll();
    }

    @DataProvider(parallel = true)
    public Object[][] textsData() {
        return new Object[][]{
                {"To include good practices", "To include good practices\nand ideas from successful\nEPAM project"},
                {"To be flexible and", "To be flexible and\ncustomizable"},
                {"To be multiplatform", "To be multiplatform"},
                {"Already have good base", "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}
        };
    }

    @Test(dataProvider = "textsData")
    public void checkTexts(String textToFind, String text){
        WebElement element = driver.findElement(By.xpath(String.format("//span[contains(text(),'%s')]", textToFind)));
        softAssert.assertEquals(element.getText(), text);
    }
}
