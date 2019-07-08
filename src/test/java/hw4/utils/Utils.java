package hw4.utils;

import com.codeborne.selenide.Configuration;
import hw1.Hw1Exception;
import hw4.Hw4Exception;
import hw4.enums.ElementTypes;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class Utils {

    @Step("Runs ${0} browser")
    public void setUpSuite(String browser,
                           String url,
                           Integer timeToWait,
                           Integer pollingInterval){
        if (!("firefox".equals(browser) || "chrome".equals(browser))){
            throw new Hw1Exception("Not valid driver name");
        }
        Configuration.browser = browser;
        Configuration.timeout = timeToWait;
        Configuration.pollingInterval = pollingInterval;
        Configuration.browserSize = "1920x1080";
        open(url);
    }

    public String getLogRow(ElementTypes type, Boolean selected, String name){
        if (type.equals(ElementTypes.CHECKBOX)){
            return name + ": condition changed to " + selected.toString();
        }
        if (type.equals(ElementTypes.RADIO)){
            return "metal: value changed to " + name;
        }
        if (type.equals(ElementTypes.DROPDOWN)){
            return "Colors: value changed to " + name;
        }
        else {
            throw new Hw4Exception("Invalid element type");
        }
    }
}
