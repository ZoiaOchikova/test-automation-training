package hw4.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageSelenide {

    @FindBy(css = "#user-icon")
    public SelenideElement userIcon;

    @FindBy(css = "#name")
    public SelenideElement name;

    @FindBy(css = "#password")
    public SelenideElement password;

    @FindBy(css = "#login-button")
    public SelenideElement loginButton;

    @FindBy(css = "#user-name")
    public SelenideElement userName;

    @FindBy(css = "#mCSB_1")
    public SelenideElement leftSection;

    @FindBy(css = "#mCSB_2")
    public SelenideElement rightSection;

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 > li.dropdown")
    public SelenideElement servicesDropdown;

    @FindBy(linkText = "Service")
    public SelenideElement sideBarServiceDropdown;

    @FindBy(css = ".menu-title")
    public ElementsCollection menuTitles;
}
