package Selenium.hw6.Helpers;

import Selenium.hw6.PageObjects.UserTablePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class UserTablePageHelper extends BaseHelper{

    public static UserTablePageHelper userTablePageHelper;
    public UserTablePage userTablePage;
    private List<WebElement> options = null;

    public UserTablePageHelper(RemoteWebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        userTablePage = new UserTablePage(driver);
    }

    public static UserTablePageHelper getInstance(RemoteWebDriver driver, SoftAssert softAssert){
        if (userTablePageHelper == null){
            userTablePageHelper = new UserTablePageHelper(driver, softAssert);
        }
        return userTablePageHelper;
    }

    public void checkDropdowns(Integer numDropdowns){
        softAssert.assertTrue(userTablePage.selects.size() == numDropdowns,
                String.format("Number of selects is incorrect. Should be %s, got %s.",
                        numDropdowns, userTablePage.selects.size()));
        for (WebElement element: userTablePage.selects){
            softAssert.assertTrue(element.isDisplayed(), "Not all selects are displayed");
        }
    }

    public void checkNames(Integer numNames){
        softAssert.assertTrue(userTablePage.names.size() == numNames,
                String.format("Number of names is incorrect. Should be %s, got %s.",
                        numNames, userTablePage.names.size()));
        for (WebElement element: userTablePage.names){
            softAssert.assertTrue(element.isDisplayed(), "Not all names are displayed");
        }
    }

    public void checkImages(Integer numImages){
        softAssert.assertTrue(userTablePage.images.size() == numImages,
                String.format("Number of images is incorrect. Should be %s, got %s.",
                        numImages, userTablePage.images.size()));
        for (WebElement element: userTablePage.images){
            softAssert.assertTrue(element.isDisplayed(), "Not all images are displayed");
        }
    }

    public void checkTexts(Integer numTexts){
        softAssert.assertTrue(userTablePage.texts.size() == numTexts,
                String.format("Number of texts is incorrect. Should be %s, got %s.",
                        numTexts, userTablePage.texts.size()));
        for (WebElement element: userTablePage.texts){
            softAssert.assertTrue(element.isDisplayed(), "Not all texts are displayed");
        }
    }

    public void checkCheckboxes(Integer numCheckboxes){
        softAssert.assertTrue(userTablePage.checkboxes.size() == numCheckboxes,
                String.format("Number of checkboxes is incorrect. Should be %s, got %s.",
                        numCheckboxes, userTablePage.checkboxes.size()));
        for (WebElement element: userTablePage.checkboxes){
            softAssert.assertTrue(element.isDisplayed(), "Not all checkboxes are displayed");
        }
    }

    public void checkUsers(List<List<String>> usersExpected){
        List<WebElement> usersActual = userTablePage.users;
        for (int i=1; i<=usersExpected.size()-1; i++){
            WebElement userActual = usersActual.get(i);
            List<String> userExpected = usersExpected.get(i);
            softAssert.assertTrue(userActual.findElement(By.linkText(userExpected.get(1))).isDisplayed());
            softAssert.assertEquals(userActual.findElement(By.cssSelector(".user-descr > span")).getText(), userExpected.get(2));
        }
    }

    public void checkUsersChecbox(String linkText){
        List<WebElement> users = userTablePage.users;
        WebElement checkBox = null;
        for (WebElement user: users){
            try {
                setDriverTimeout(0);
                user.findElement(By.linkText(linkText));
            } catch (org.openqa.selenium.NoSuchElementException ex){
                continue;
            }
            checkBox = user.findElement(By.xpath("//input[@type='checkbox']"));
            checkBox.click();
            setInitialDriverTimeout();
            break;
        }
        softAssert.assertNotNull(checkBox, "Checbox not found");
    }

    public void clickUserDropdown(String linkText) {
        List<WebElement> users = userTablePage.users;
        for (WebElement user: users){
            try {
                setDriverTimeout(0);
                user.findElement(By.linkText(linkText));
            } catch (org.openqa.selenium.NoSuchElementException ex){
                continue;
            }
            options = user.findElements(By.tagName("option"));
            setInitialDriverTimeout();
            break;
        }
    }

    public void checkOptions(List<String> optionsExpected){
        Assert.assertNotNull(options, "No option elements to check");
        for (WebElement option: options){
            String a = option.getText();
            softAssert.assertTrue(optionsExpected.contains(option.getText()),
                    String.format("Option %s was not found", option.getText()));
        }
    }

    public void checkLogText(Integer rowNum, String expectedText) {
        String actualText = userTablePage.logPanel.findElements(By.tagName("li"))
                .get(rowNum-1).getText().replaceAll("[0-9]+", "").replace(":: ", "");
        softAssert.assertEquals(actualText, expectedText,
                String.format("Expected log text should be: '%s'. Got: '%s'", expectedText, actualText));
    }
}
