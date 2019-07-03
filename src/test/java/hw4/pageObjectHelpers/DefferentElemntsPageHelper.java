package hw4.pageObjectHelpers;

import com.codeborne.selenide.SelenideElement;
import hw4.Utils;
import hw4.enums.ElementTypes;
import hw4.pageObjects.DifferentElementsPage;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DefferentElemntsPageHelper {

    private WebDriver driver;
    private Utils utils;
    private SoftAssert softAssert;
    private DifferentElementsPage differentElementsPage;

    public DefferentElemntsPageHelper(SoftAssert softAssert, Utils utils){
        driver = getWebDriver();
        this.utils = utils;
        this.softAssert = softAssert;
        differentElementsPage = page(DifferentElementsPage.class);
    }

    public void checkCheckboxes(Integer numCheckboxes){
        softAssert.assertTrue(differentElementsPage.checkBoxesByType.size() == numCheckboxes,
                String.format("Number of checkboxes is incorrect. Should be %s, got %s.",
                        numCheckboxes, differentElementsPage.checkBoxesByType.size()));
    }

    public void checkRadios(Integer numRadios){
        softAssert.assertTrue(differentElementsPage.radiosByType.size() == numRadios,
                String.format("Number of radios is incorrect. Should be %s, got %s.",
                        numRadios, differentElementsPage.radiosByType.size()));
    }

    public void checkDropdowns(Integer numDropdowns){
        softAssert.assertTrue(differentElementsPage.selects.size() == numDropdowns,
                String.format("Number of selects is incorrect. Should be %s, got %s.",
                        numDropdowns, differentElementsPage.selects.size()));
    }

    public void checkButtons(Integer numButtons){
        Integer actualNumButtons = differentElementsPage.buttonsByTag.size() +
                differentElementsPage.buttonsByType.size();
        softAssert.assertTrue(actualNumButtons.equals(numButtons),
                String.format("Number of buttons is incorrect. Should be %s, got %s.",
                        numButtons, actualNumButtons));
    }

    public void clickRadio(String radioText){
        SelenideElement radio = differentElementsPage.radiosByClass.findBy(exactText(radioText));
        softAssert.assertTrue(radio.isDisplayed(),
                String.format("Can't find element by text: '%s'.", radioText));
        radio.click();
        softAssert.assertTrue(radio.isEnabled(),
                String.format("Radio '%s' is not selected.", radioText));
    }


    public void clickCheckbox(String checkboxText){
        SelenideElement checkbox = differentElementsPage.checkBoxesByClass.findBy(exactText(checkboxText));
        softAssert.assertTrue(checkbox.isDisplayed(),
                String.format("Can't find element by text: '%s'.", checkboxText));
        checkbox.click();
        softAssert.assertTrue(checkbox.isEnabled(),
                String.format("Checkbox '%s' is not selected.", checkboxText));
    }

    public void clickSelects(){
        differentElementsPage.selects.get(0).click();
    }

    public void clickSelection(String selectText){
        SelenideElement selection = differentElementsPage.selects2.findBy(exactText(selectText));
        softAssert.assertTrue(selection.isDisplayed());
        selection.click();
    }

    public void checkLogRow(ElementTypes type, Boolean selected, String name){
        String logText = utils.getLogRow(type, selected, name);
        softAssert.assertTrue(differentElementsPage.logs.findBy(text(logText)).isDisplayed());
    }

}
