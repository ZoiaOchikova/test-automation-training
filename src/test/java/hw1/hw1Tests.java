package hw1;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class hw1Tests {
    private Utils utils;
    private RemoteWebDriver driver;
    private SoftAssert softAssert;
    private Actions pageActions;
    private ArrayList<String> headers;
    private ArrayList<String> indexPageElements;
    private Integer indexPageElementsNumber;
    private String expMainTitle;
    private String expMainTitleText;
    private String subHeaderTitle;
    private String subHeaderUrl;

    @BeforeClass
    public void setUp(){
        utils = new Utils();
        driver = utils.getDriver("chrome");
        softAssert = new SoftAssert();
        pageActions = new Actions(driver, softAssert);
        headers = new ArrayList<String>(Arrays.asList("HOME", "CONACT FORM", "SERVICE", "METALS & COLORS"));
        indexPageElementsNumber = 4;
        indexPageElements = new ArrayList<String>(Arrays.asList("To incude good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"));
        expMainTitle = "EPAM FRAMEWORK WISHES…";
        expMainTitleText = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        subHeaderTitle = "JDI GITHUB";
        subHeaderUrl = "https://github.com/epam/JDI";
        utils.setUpSuite("http://epam.github.io/JDI/index.html", 1000, TimeUnit.MILLISECONDS);
    }

    @AfterClass
    public void teardown(){
        driver.close();
        softAssert.assertAll();
    }

    @Test
    public void loginTest(){
        pageActions.checkPageTitle("Home Page");
        pageActions.login("epam", "1234");
        pageActions.checkUserName("PITER CHAILOVSKII");
        pageActions.checkPageTitle("Home Page");
        pageActions.checkHeadersSection(headers);
        pageActions.checkIndexPageImages(indexPageElementsNumber);
        pageActions.checkIndexPageTexts(indexPageElements);
        pageActions.checkTitles(expMainTitle, expMainTitleText);
        pageActions.checkIFrameExistence();
        pageActions.switchToIFrame();
        pageActions.checkIFrameLogoExistence();
        pageActions.switchToParentFrame();
        pageActions.checkSubHeader(subHeaderTitle, subHeaderUrl);
        pageActions.checkLeftSectionExistence();
        pageActions.checkFooterExistence();
    }
}
