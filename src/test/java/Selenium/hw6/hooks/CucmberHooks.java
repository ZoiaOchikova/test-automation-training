package Selenium.hw6.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class CucmberHooks{

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        SoftAssert softAssert= new SoftAssert();
        TestContext.setDriver(driver);
        TestContext.setSoftAssert(softAssert);
    }

    @After
    public void closeDriver() {
        TestContext.getDriver().close();
        TestContext.getSoftAssert().assertAll();
    }
}
