package Selenium.hw1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class Utils {
    public static RemoteWebDriver driver;

    public RemoteWebDriver getDriver(String browser){
        if ("chrome".equals(browser)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if ("firefox".equals(browser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else {
            throw new Hw1Exception("Not valid driver name");
        }

        return driver;
    }

    public void setUpSuite(String url, Integer timeToWait, TimeUnit timeUnit){
        driver.navigate().to(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(timeToWait, timeUnit);
    }
}
