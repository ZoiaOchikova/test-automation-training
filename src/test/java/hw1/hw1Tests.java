package hw1;

import hw1.enums.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class hw1Tests {
    private Utils utils;
    private RemoteWebDriver driver;
    private SoftAssert softAssert;
    private LoginPageHelper pageLoginPageHelper;
    private ArrayList<String> headers;
    private ArrayList<String> indexPageElements;
    private Integer indexPageElementsNumber;


    @BeforeSuite
    public void setUpSuite(){
        utils = new Utils();
    }

    @BeforeClass
    public void setUp(){
        headers = new ArrayList<String>(Arrays.asList(HeadersSection.HOME.getName(),
                HeadersSection.CONTACT_FORM.getName(),
                HeadersSection.SERVICE.getName(),
                HeadersSection.METALS_AND_COLORS.getName()));
        indexPageElementsNumber = 4;
        indexPageElements = new ArrayList<String>(Arrays.asList(PageTexts.TO_INCLUDE_GOOD_PRACTICES.getText(),
                PageTexts.TO_BE_FLEXIBLE.getText(),
                PageTexts.TO_BE_MULTIPLATFORM.getText(),
                PageTexts.ALREADY_HAVEGOOD_BASE.getText()));
    }

    @BeforeMethod
    public void setUpMethod(){
        driver = utils.getDriver("chrome");
        softAssert = new SoftAssert();
        pageLoginPageHelper = new LoginPageHelper(driver, softAssert);
        utils.setUpSuite(Urls.JDI.getUrl(), 1000, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void teardown(){
        driver.close();
        softAssert.assertAll();
    }

    @Test
    public void loginTest(){
        pageLoginPageHelper.checkPageTitle(Titeles.HOME_PAGE.getTitle());
        pageLoginPageHelper.login(Users.PITER_CHAILOVSKII.getLogin(), Users.PITER_CHAILOVSKII.getPassword());
        pageLoginPageHelper.checkUserName(Users.PITER_CHAILOVSKII.getName());
        pageLoginPageHelper.checkPageTitle(Titeles.HOME_PAGE.getTitle());
        pageLoginPageHelper.checkHeadersSection(headers);
        pageLoginPageHelper.checkIndexPageImages(indexPageElementsNumber);
        pageLoginPageHelper.checkIndexPageTexts(indexPageElements);
        pageLoginPageHelper.checkTitles(Titeles.EPAM_FRAMEWORK_WISHES.getTitle(), PageTexts.LOREM_IPSUM.getText());
        pageLoginPageHelper.checkIFrameExistence();
        pageLoginPageHelper.switchToIFrame();
        pageLoginPageHelper.checkIFrameLogoExistence();
        pageLoginPageHelper.switchToParentFrame();
        pageLoginPageHelper.checkSubHeader(Titeles.JDI_GITHUB.getTitle(), Urls.GITHUB_JDI.getUrl());
        pageLoginPageHelper.checkLeftSectionExistence();
        pageLoginPageHelper.checkFooterExistence();
    }
}
