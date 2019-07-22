package Selenium.hw6.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserTablePage {

    public UserTablePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindAll(@FindBy(xpath = "//div[contains(@class,'main-content-hg')]//select"))
    public List<WebElement> selects;


    @FindAll(@FindBy(xpath = "//div[contains(@class,'main-content-hg')]//a"))
    public List<WebElement> names;


    @FindAll(@FindBy(xpath = "//div[contains(@class,'main-content-hg')]//img"))
    public List<WebElement> images;


    @FindAll(@FindBy(xpath = "//div[contains(@class,'main-content-hg')]//span"))
    public List<WebElement> texts;


    @FindAll(@FindBy(xpath = "//div[contains(@class,'main-content-hg')]//input[@type='checkbox']"))
    public List<WebElement> checkboxes;


    @FindAll(@FindBy(xpath = "//div[contains(@class,'main-content-hg')]//tr"))
    public List<WebElement> users;

    @FindBy(css = ".info-panel-body.info-panel-body-log")
    public WebElement logPanel;
}
