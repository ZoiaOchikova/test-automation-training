package hw4;

import hw1.enums.*;
import hw4.enums.*;
import hw4.pageObjectHelpers.DefferentElemntsPageHelper;
import hw4.pageObjectHelpers.LoginPageHelper;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex1 {

    private Utils utils;
    private SoftAssert softAssert;
    private LoginPageHelper pageLoginPageHelper;
    private DefferentElemntsPageHelper defferentElemntsHelper;
    private ArrayList<String> services;
    private ArrayList<String> sideBarServices;

    @BeforeSuite
    public void setUpSuite(){
        utils = new Utils();
    }

    @BeforeClass
    public void setUp(){
        services = new ArrayList<String>(Arrays.asList(
                ServiceTexts.SUPPORT.getText(),
                ServiceTexts.DATES.getText(),
                ServiceTexts.COMPLEX_TABLE.getText(),
                ServiceTexts.SIMPLE_TABLE.getText(),
                ServiceTexts.TABLES_WITH_PAGES.getText(),
                ServiceTexts.DIFFERENT_ELEMENTS.getText()));
        sideBarServices = new ArrayList<String>(Arrays.asList(
                ServiceTexts.SIDEBARSUPPORT.getText(),
                ServiceTexts.SIDEBARDATES.getText(),
                ServiceTexts.SIDEBARCOMPLEX_TABLE.getText(),
                ServiceTexts.SIDEBARSIMPLE_TABLE.getText(),
                ServiceTexts.SIDEBARTABLES_WITH_PAGES.getText(),
                ServiceTexts.SIDEBARDIFFERENT_ELEMENTS.getText()));
    }

    @BeforeMethod
    public void setUpMethod(){
        softAssert = new SoftAssert();
        utils.setUpSuite("chrome", Urls.JDI.getUrl(), 4000, 100);
        pageLoginPageHelper = new LoginPageHelper(softAssert);
        defferentElemntsHelper = new DefferentElemntsPageHelper(softAssert, utils);
    }

    @AfterMethod
    public void teardown(){
        softAssert.assertAll();
    }

    @Test
    public void hw4Test(){
        pageLoginPageHelper.checkPageTitle(Titeles.HOME_PAGE.getTitle());
        pageLoginPageHelper.login(Users.PITER_CHAILOVSKII.getLogin(), Users.PITER_CHAILOVSKII.getPassword());
        pageLoginPageHelper.checkUserName(Users.PITER_CHAILOVSKII.getName());
        pageLoginPageHelper.checkPageTitle(Titeles.HOME_PAGE.getTitle());
        pageLoginPageHelper.clickServiceDropDown();
        pageLoginPageHelper.checkServiceDropdown(services);
        pageLoginPageHelper.clickSideBarService();
        pageLoginPageHelper.checkSideBarServiceDropdown(sideBarServices);
        pageLoginPageHelper.clickServiceDropDown();
        pageLoginPageHelper.clickServiceLink(ServiceTexts.SUPPORT.getText());
        pageLoginPageHelper.clickServiceDropDown();
        pageLoginPageHelper.clickServiceLink(ServiceTexts.DIFFERENT_ELEMENTS.getText());
        defferentElemntsHelper.checkCheckboxes(4);
        defferentElemntsHelper.checkRadios(4);
        defferentElemntsHelper.checkDropdowns(1);
        defferentElemntsHelper.checkButtons(2);
        pageLoginPageHelper.checkLeftSectionExistence();
        pageLoginPageHelper.checkRightSectionExistence();
        defferentElemntsHelper.clickCheckbox(Checkboxes.WATER.getText());
        defferentElemntsHelper.clickCheckbox(Checkboxes.WIND.getText());
        defferentElemntsHelper.checkLogRow(ElementTypes.CHECKBOX, true, Checkboxes.WATER.getText());
        defferentElemntsHelper.checkLogRow(ElementTypes.CHECKBOX, true, Checkboxes.WIND.getText());
        defferentElemntsHelper.clickRadio(Radios.SELEN.getText());
        defferentElemntsHelper.checkLogRow(ElementTypes.RADIO, true, Radios.SELEN.getText());
        defferentElemntsHelper.clickCheckbox(Checkboxes.WATER.getText());
        defferentElemntsHelper.clickCheckbox(Checkboxes.WIND.getText());
        defferentElemntsHelper.checkLogRow(ElementTypes.CHECKBOX, false, Checkboxes.WATER.getText());
        defferentElemntsHelper.checkLogRow(ElementTypes.CHECKBOX, false, Checkboxes.WIND.getText());
        defferentElemntsHelper.clickSelection(Selects.YELLOW.getText());
        defferentElemntsHelper.checkLogRow(ElementTypes.DROPDOWN, true, Selects.YELLOW.getText());
    }
}
