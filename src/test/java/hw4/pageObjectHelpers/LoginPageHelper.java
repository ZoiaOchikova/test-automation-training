package hw4.pageObjectHelpers;

import hw4.pageObjects.LoginPageSelenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginPageHelper {
    private WebDriver driver;
    private SoftAssert softAssert;
    private LoginPageSelenide loginPage;

    public LoginPageHelper(SoftAssert softAssert) {
        driver = getWebDriver();
        this.softAssert = softAssert;
        loginPage = page(LoginPageSelenide.class);

    }

    @Step("Check page title equals '{0}'")
    public void checkPageTitle(String pageTile) {
        Assert.assertEquals(driver.getTitle(),pageTile);
    }

    @Step("Login as '{0}'")
    public void login(String user, String pwd){
        loginPage.userIcon.click();
        loginPage.name.sendKeys(user);
        loginPage.password.sendKeys(pwd);
        loginPage.loginButton.click();
    }

    public String getUserName(){
        return loginPage.userName.getText();

    }

    @Step("Check user name: '{0}'")
    public void checkUserName(String userName) {
        softAssert.assertEquals(getUserName(), userName);
    }

    @Step("Click service dropdown at header")
    public  void clickServiceDropDown(){
        loginPage.servicesDropdown.click();
    }

    @Step("Check service's dropdown content at header")
    public void checkServiceDropdown(List<String> textsList){
        for (String text: textsList){
            Assert.assertTrue(loginPage.servicesDropdown.$(By.linkText(text)).isDisplayed(),
                    String.format("Can't find element by link text: '%s'.", text));
        }
    }

    @Step("Click service dropdown at side bar")
    public  void clickSideBarService(){
        loginPage.sideBarServiceDropdown.click();
    }

    @Step("Check service's dropdown content at side bar")
    public void checkSideBarServiceDropdown(List<String> textsList){
        for (String text: textsList){
            Assert.assertTrue(loginPage.menuTitles.get(0).$(By.linkText(text)).isDisplayed(),
                    String.format("Can't find element by link text: '%s'.", text));
        }
    }

    @Step("Click service's link text: '{0}'")
    public void clickServiceLink(String linkText){
        Assert.assertTrue(loginPage.servicesDropdown.$(By.linkText(linkText)).isDisplayed(),
                String.format("Can't find element by link text: '%s'.", linkText));
        loginPage.servicesDropdown.$(By.linkText(linkText)).click();
    }

    @Step("Check left section existence")
    public void checkLeftSectionExistence(){ softAssert.assertTrue(loginPage.leftSection.isDisplayed()); }

    @Step("Check right section existence")
    public void checkRightSectionExistence(){
        softAssert.assertTrue(loginPage.rightSection.isDisplayed());
    }

}
