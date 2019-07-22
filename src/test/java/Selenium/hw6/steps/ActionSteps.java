package Selenium.hw6.steps;

import cucumber.api.java.en.When;

public class ActionSteps extends BaseStep{

    @When("I click on 'Service' button in Header")
    public void iClickOnButtonInHeader(){
        pageLoginPageHelper.clickServiceDropDown();
    }

    @When("I click on '([^\"]*)' button in Service dropdown")
    public void iClickOnButtonInServiceDropdown(String linkText){
        pageLoginPageHelper.clickServiceLink(linkText.toUpperCase());
    }

    @When("I select 'vip' checkbox for '([^\"]*)'")
    public void iSelectChckboxForUser(String userName){
        userTablePageHelper.checkUsersChecbox(userName);
    }

    @When("I click on dropdown in column Type for user '([^\"]*)'")
    public void iClickDropdownInColumnType(String userName){
        userTablePageHelper.clickUserDropdown(userName);
    }
}
