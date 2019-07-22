package Selenium.hw6.hooks;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;

public class TestContext {

    private static RemoteWebDriver driver;
    private static SoftAssert softAssert;

    public static RemoteWebDriver getDriver() {
        return driver;
    }

    public static SoftAssert getSoftAssert() {
        return softAssert;
    }

    static void setDriver(RemoteWebDriver driver) {
        TestContext.driver = driver;
    }

    static void setSoftAssert(SoftAssert softAssert) {
        TestContext.softAssert = softAssert;
    }
}
