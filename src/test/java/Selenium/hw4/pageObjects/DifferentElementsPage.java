package Selenium.hw4.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class DifferentElementsPage {

    @FindAll(@FindBy(css = "input[type='checkbox']"))
    public ElementsCollection checkBoxesByType;

    @FindAll(@FindBy(css = ".label-checkbox"))
    public ElementsCollection checkBoxesByClass;

    @FindAll(@FindBy(css = "input[type='radio']"))
    public ElementsCollection radiosByType;

    @FindAll(@FindBy(css = ".label-radio"))
    public ElementsCollection radiosByClass;

    @FindAll(@FindBy(xpath = "//div[contains(@class,'main-content-hg')]//select"))
    public ElementsCollection selects;

    @FindAll(@FindBy(xpath = "//div[contains(@class,'main-content-hg')]//button"))
    public ElementsCollection buttonsByTag;

    @FindAll(@FindBy(css = ".panel-body-list.logs > li"))
    public ElementsCollection logs;


    @FindAll(@FindBy(css = ".uui-form-element > option"))
    public ElementsCollection selects2;

    @FindAll(@FindBy(css = "input[type='button']"))
    public ElementsCollection buttonsByType;

}
