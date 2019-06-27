package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class LoginPageHelper {
    private RemoteWebDriver driver;
    private SoftAssert softAssert;
    private LoginPage loginPage;

    public LoginPageHelper(RemoteWebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        loginPage = new LoginPage(driver);

    }

    public void checkPageTitle(String pageTile) {
        Assert.assertEquals(driver.getTitle(),pageTile);
    }

    public void login(String user, String pwd){
        loginPage.userIcon.click();
        loginPage.name.sendKeys(user);
        loginPage.password.sendKeys(pwd);
        loginPage.loginButton.click();
    }

    public String getUserName(){
        return loginPage.userName.getText();

    }

    public List<WebElement> getIndexPageElements(){
        return driver.findElements(By.cssSelector(".main-content > div > div"));
    }

    public void switchToIFrame(){
        driver.switchTo().frame(loginPage.iFrame);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }


    public void checkUserName(String userName) {
        softAssert.assertEquals(getUserName(), userName);
    }

    public void checkHeadersSection(List<String> expectedHeaders) {
        for (WebElement element: loginPage.headerSections) {
            softAssert.assertTrue(element.isDisplayed());
            softAssert.assertTrue(expectedHeaders.contains(element.getText()));
        }
    }

    public void checkIndexPageImages(Integer expectedIndexPageElementsNumber) {
        WebElement elementImg;
        softAssert.assertTrue(loginPage.indexPageElements.size() == expectedIndexPageElementsNumber);
        for (WebElement element: loginPage.indexPageElements){
            elementImg = element.findElement(By.className("benefit-icon"));
            softAssert.assertTrue(elementImg.isDisplayed());
        }
    }

    public void checkIndexPageTexts(List<String> expectedIndexPageElements) {
        WebElement elementTxt;
        softAssert.assertEquals(loginPage.indexPageElements.size(), expectedIndexPageElements.size());
        for (WebElement element: loginPage.indexPageElements){
            elementTxt = element.findElement(By.className("benefit-txt"));
            softAssert.assertTrue(elementTxt.isDisplayed());
            softAssert.assertTrue(expectedIndexPageElements.contains(element.getText()));
        }
    }

    public void checkTitles(String expMainTitle, String expMainTitleText){
        WebElement mainTitle = loginPage.mainTitle;
        WebElement mainTitleText = loginPage.mainTitleText;
        softAssert.assertTrue(mainTitle.isDisplayed());
        softAssert.assertEquals(mainTitle.getText(), expMainTitle);
        softAssert.assertTrue(mainTitleText.isDisplayed());
        softAssert.assertEquals(mainTitleText.getText(), expMainTitleText);
    }

    public void checkIFrameExistence(){
        softAssert.assertTrue(loginPage.iFrame.isDisplayed());
    }

    public void checkIFrameLogoExistence(){
        softAssert.assertTrue(loginPage.iFrameLogo.isDisplayed());
    }

    public void checkSubHeader(String title, String url){
        WebElement subHeader = loginPage.subHeader;
        softAssert.assertTrue(subHeader.isDisplayed());
        softAssert.assertEquals(subHeader.getText(), title);
        softAssert.assertTrue(subHeader.isDisplayed());
        softAssert.assertTrue(subHeader.isEnabled());
        softAssert.assertEquals(subHeader.getAttribute("href"), url);
    }

    public void checkLeftSectionExistence(){
        softAssert.assertTrue(loginPage.leftSection.isDisplayed());
    }

    public void checkFooterExistence(){
        softAssert.assertTrue(loginPage.footerSection.isDisplayed());
    }

}
