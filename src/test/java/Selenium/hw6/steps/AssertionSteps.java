package Selenium.hw6.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

import java.util.List;

public class AssertionSteps extends BaseStep{

    @Then("'([^\"]*)' page is opened")
    public void pageIsOpened(String pageTitle){
        pageLoginPageHelper.checkPageTitle(pageTitle);
    }

    @Then("([0-9]*) NumberType Dropdowns are displayed on User Table Page")
    public void NumberTypeDropdownsAreDisplayed(Integer dropdownNum){
        userTablePageHelper.checkDropdowns(dropdownNum);
    }

    @Then("([0-9]*) User names are displayed on User Table Page")
    public void userNamesAreDisplayed(Integer namesNum){
        userTablePageHelper.checkNames(namesNum);
    }

    @Then("([0-9]*) Description images are displayed on User Table Page")
    public void descriptionImagesAreDisplayes(Integer imagesNum){
        userTablePageHelper.checkImages(imagesNum);
    }

    @Then("([0-9]*) Description texts under images are displayed on User Table Page")
    public void descriptionTextsAreDisplayed(Integer textsNum){
        userTablePageHelper.checkTexts(textsNum);
    }

    @Then("([0-9]*) checkboxes are displayed on User Table Page")
    public void checkboxesAreDisplayed(Integer checkboxesNum){
        userTablePageHelper.checkCheckboxes(checkboxesNum);
    }

    @Then("User table contains following values:")
    public void userTableContains(DataTable args){
        List<List<String>> values = args.asLists(String.class);
        userTablePageHelper.checkUsers(values);
    }

    @Then("droplist contains values")
    public void droplistContainsValues(DataTable args){
        List<String> values = args.asList(String.class);
        userTablePageHelper.checkOptions(values);
    }

    @Then("([0-9]*) log row has '([^\"]*)' text in log section")
    public void firstLogRowHasText(Integer rowNum, String text){
        userTablePageHelper.checkLogText(rowNum, text);
    }
}
