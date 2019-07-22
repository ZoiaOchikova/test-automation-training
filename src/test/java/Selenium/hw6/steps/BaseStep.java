package Selenium.hw6.steps;

import Selenium.hw6.Helpers.LoginPageHelper;
import Selenium.hw6.Helpers.UserTablePageHelper;
import Selenium.hw6.hooks.TestContext;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;

public class BaseStep {

    public LoginPageHelper pageLoginPageHelper;
    public UserTablePageHelper userTablePageHelper;
    private RemoteWebDriver driver;
    private SoftAssert softAssert;

    public BaseStep(){
        softAssert = TestContext.getSoftAssert();
        driver = TestContext.getDriver();
        pageLoginPageHelper = LoginPageHelper.getInstance(driver, softAssert);
        userTablePageHelper = UserTablePageHelper.getInstance(driver, softAssert);
    }
}
