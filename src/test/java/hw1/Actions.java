package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Actions {
    RemoteWebDriver driver;
    SoftAssert softAssert;

    public Actions(RemoteWebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;

    }

    public void checkPageTitle(String pageTile) {
        Assert.assertEquals(driver.getTitle(),pageTile);
    }

    public void login(String user, String pwd){
        driver.findElementById("user-icon").click();
        driver.findElementById("name").sendKeys(user);
        driver.findElementById("password").sendKeys(pwd);
        driver.findElementById("login-button").click();
    }

    public String getUserName(){
        return driver.findElementById("user-name").getText();

    }

    public List<WebElement> getHeaderSections(){
        return driver.findElements(By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8 > li"));
    }

    public List<WebElement> getIndexPageElements(){
        return driver.findElements(By.cssSelector(".main-content > div > div"));
    }

    public WebElement getMainTitle(){
        return driver.findElement(By.name("main-title"));
    }

    public WebElement getMainTitleText(){
        return driver.findElement(By.name("jdi-text"));
    }

    public WebElement getIFrame(){
        return driver.findElementById("iframe");
    }

    public void switchToIFrame(){
        driver.switchTo().frame(getIFrame());
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public WebElement getIFrameLogo(){
        return driver.findElement(By.id("epam_logo"));
    }

    public WebElement getSubHeader(String title){
        return driver.findElementByLinkText(title);
    }

    public WebElement getLeftSection(){
        return driver.findElementById("mCSB_1");
    }

    public WebElement getFooterSection(){
        return driver.findElementByClassName("footer-content");
    }

    public void checkUserName(String userName) {
        softAssert.assertEquals(getUserName(), userName);
    }

    public void checkHeadersSection(List<String> expectedHeaders) {
        for (WebElement element: getHeaderSections()) {
            softAssert.assertTrue(element.isDisplayed());
            softAssert.assertTrue(expectedHeaders.contains(element.getText()));
        }
    }

    public void checkIndexPageImages(Integer expectedIndexPageElementsNumber) {
        List<WebElement> actualIndexPageElements = getIndexPageElements();
        WebElement elementImg;
        softAssert.assertTrue(actualIndexPageElements.size() == expectedIndexPageElementsNumber);
        for (WebElement element: actualIndexPageElements){
            elementImg = element.findElement(By.className("benefit-icon"));
            softAssert.assertTrue(elementImg.isDisplayed());
        }
    }

    public void checkIndexPageTexts(List<String> expectedIndexPageElements) {
        List<WebElement> actualIndexPageElements = getIndexPageElements();
        WebElement elementTxt;
        softAssert.assertEquals(actualIndexPageElements.size(), expectedIndexPageElements.size());
        for (WebElement element: actualIndexPageElements){
            elementTxt = element.findElement(By.className("benefit-txt"));
            softAssert.assertTrue(elementTxt.isDisplayed());
            softAssert.assertTrue(expectedIndexPageElements.contains(element.getText()));
        }
    }

    public void checkTitles(String expMainTitle, String expMainTitleText){
        WebElement mainTitle = getMainTitle();
        WebElement mainTitleText = getMainTitleText();
        softAssert.assertTrue(mainTitle.isDisplayed());
        softAssert.assertEquals(mainTitle.getText(), expMainTitle);
        softAssert.assertTrue(mainTitleText.isDisplayed());
        softAssert.assertEquals(mainTitleText.getText(), expMainTitleText);
    }

    public void checkIFrameExistence(){
        softAssert.assertTrue(getIFrame().isDisplayed());
    }

    public void checkIFrameLogoExistence(){
        softAssert.assertTrue(getIFrameLogo().isDisplayed());
    }

    public void checkSubHeader(String title, String url){
        WebElement subHeader = getSubHeader(title);
        softAssert.assertTrue(subHeader.isDisplayed());
        softAssert.assertEquals(subHeader.getText(), title);
        softAssert.assertTrue(subHeader.isDisplayed());
        softAssert.assertTrue(subHeader.isEnabled());
        softAssert.assertEquals(subHeader.getAttribute("href"), url);
    }

    public void checkLeftSectionExistence(){
        softAssert.assertTrue(getLeftSection().isDisplayed());
    }

    public void checkFooterExistence(){
        softAssert.assertTrue(getFooterSection().isDisplayed());
    }

}
