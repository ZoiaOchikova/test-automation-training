package Selenium.hw2;

import Selenium.hw1.LoginPageHelper;
import Selenium.hw1.Utils;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Ex23 {
    private Utils utils;
    private RemoteWebDriver driver;
    private SoftAssert softAssert;
    private LoginPageHelper pageLoginPageHelper;
    private ArrayList<String> headers;
    private ArrayList<String> indexPageElements;
    private Integer indexPageElementsNumber;
    private String expMainTitle;
    private String expMainTitleText;
    private String subHeaderTitle;
    private String subHeaderUrl;

    @BeforeMethod(groups = {"Smoke", "Regression"})
    public void setUp(){
        utils = new Utils();
        driver = utils.getDriver("chrome");
        softAssert = new SoftAssert();
        pageLoginPageHelper = new LoginPageHelper(driver, softAssert);
        headers = new ArrayList<String>(Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));
        indexPageElementsNumber = 4;
        indexPageElements = new ArrayList<String>(Arrays.asList("To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"));
        expMainTitle = "EPAM FRAMEWORK WISHES…";
        expMainTitleText = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        subHeaderTitle = "JDI GITHUB";
        subHeaderUrl = "https://github.com/epam/JDI";
        utils.setUpSuite("http://epam.github.io/JDI/index.html", 1000, TimeUnit.MILLISECONDS);
    }

    @AfterMethod(groups = {"Smoke", "Regression"})
    public void teardown(){
        driver.close();
        softAssert.assertAll();
    }

    @Test(groups = {"Regression"})
    public void loginTest31(){
        pageLoginPageHelper.checkPageTitle("Home Page");
        pageLoginPageHelper.login("epam", "1234");
        pageLoginPageHelper.checkUserName("PITER CHAILOVSKII");
        pageLoginPageHelper.checkPageTitle("Home Page");
        pageLoginPageHelper.checkHeadersSection(headers);
        pageLoginPageHelper.checkIndexPageImages(indexPageElementsNumber);
        pageLoginPageHelper.checkIndexPageTexts(indexPageElements);
        pageLoginPageHelper.checkTitles(expMainTitle, expMainTitleText);
        pageLoginPageHelper.checkIFrameExistence();
        pageLoginPageHelper.switchToIFrame();
        pageLoginPageHelper.checkIFrameLogoExistence();
        pageLoginPageHelper.switchToParentFrame();
        pageLoginPageHelper.checkSubHeader(subHeaderTitle, subHeaderUrl);
        pageLoginPageHelper.checkLeftSectionExistence();
        pageLoginPageHelper.checkFooterExistence();
    }

    @Test(groups = {"Smoke"})
    public void loginTest32(){
        pageLoginPageHelper.checkPageTitle("Home Page");
        pageLoginPageHelper.login("epam", "1234");
        pageLoginPageHelper.checkUserName("PITER CHAILOVSKII");
        pageLoginPageHelper.checkPageTitle("Home Page");
        pageLoginPageHelper.checkHeadersSection(headers);
        pageLoginPageHelper.checkIndexPageImages(indexPageElementsNumber);
        pageLoginPageHelper.checkIndexPageTexts(indexPageElements);
        pageLoginPageHelper.checkTitles(expMainTitle, expMainTitleText);
        pageLoginPageHelper.checkIFrameExistence();
        pageLoginPageHelper.switchToIFrame();
        pageLoginPageHelper.checkIFrameLogoExistence();
        pageLoginPageHelper.switchToParentFrame();
        pageLoginPageHelper.checkSubHeader(subHeaderTitle, subHeaderUrl);
        pageLoginPageHelper.checkLeftSectionExistence();
        pageLoginPageHelper.checkFooterExistence();
    }

    @Test(groups = {"Regression"})
    public void loginTest33(){
        pageLoginPageHelper.checkPageTitle("Home Page");
        pageLoginPageHelper.login("epam", "1234");
        pageLoginPageHelper.checkUserName("PITER CHAILOVSKII");
        pageLoginPageHelper.checkPageTitle("Home Page");
        pageLoginPageHelper.checkHeadersSection(headers);
        pageLoginPageHelper.checkIndexPageImages(indexPageElementsNumber);
        pageLoginPageHelper.checkIndexPageTexts(indexPageElements);
        pageLoginPageHelper.checkTitles(expMainTitle, expMainTitleText);
        pageLoginPageHelper.checkIFrameExistence();
        pageLoginPageHelper.switchToIFrame();
        pageLoginPageHelper.checkIFrameLogoExistence();
        pageLoginPageHelper.switchToParentFrame();
        pageLoginPageHelper.checkSubHeader(subHeaderTitle, subHeaderUrl);
        pageLoginPageHelper.checkLeftSectionExistence();
        pageLoginPageHelper.checkFooterExistence();
    }
}
