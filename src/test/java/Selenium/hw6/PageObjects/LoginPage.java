package Selenium.hw6.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    public LoginPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#user-icon")
    public WebElement userIcon;

    @FindBy(css = "#name")
    public WebElement name;

    @FindBy(css = "#password")
    public WebElement password;

    @FindBy(css = "#login-button")
    public WebElement loginButton;

    @FindBy(css = "#user-name")
    public WebElement userName;

    @FindBy(css = "[name='main-title']")
    public WebElement mainTitle;

    @FindBy(css = "[name='jdi-text']")
    public WebElement mainTitleText;

    @FindBy(css = "#iframe")
    public WebElement iFrame;

    @FindBy(css = "#epam_logo")
    public WebElement iFrameLogo;

    @FindBy(linkText = "JDI GITHUB")
    public WebElement subHeader;

    @FindBy(css = "#mCSB_1")
    public WebElement leftSection;

    @FindBy(css = ".footer-content")
    public WebElement footerSection;

    @FindAll(@FindBy(css = ".ul.uui-navigation.nav.navbar-nav.m-l8 > li"))
    public List<WebElement> headerSections;

    @FindAll(@FindBy(css = ".main-content > div > div"))
    public List<WebElement> indexPageElements;

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 > li.dropdown")
    public WebElement servicesDropdown;

}

