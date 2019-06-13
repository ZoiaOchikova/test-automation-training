package hw1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class Utils {
    public static RemoteWebDriver driver;

    public RemoteWebDriver getDriver(String browser){
        if ("chrome".equals(browser)) {
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setBrowserName(browser);
            driver = new ChromeDriver(cap);
        }
        else if ("firefox".equals(browser)) {
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setBrowserName(browser);
            driver = new FirefoxDriver(cap);
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
