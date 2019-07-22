package Selenium.hw6.Helpers;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class BaseHelper {

    public RemoteWebDriver driver;
    public SoftAssert softAssert;
    public static Integer timeout = 5000;

    public void setDriverTimeout(Integer timeout){
        this.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.MILLISECONDS);
    }

    public void setInitialDriverTimeout(){
        this.driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.MILLISECONDS);
    }
}
