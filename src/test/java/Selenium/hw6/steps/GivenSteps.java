package Selenium.hw6.steps;

import cucumber.api.java.en.Given;
import Selenium.hw1.enums.Urls;
import Selenium.hw1.enums.Users;
import Selenium.hw6.hooks.TestContext;

public class GivenSteps extends BaseStep{

    @Given("I am on 'Home Page'")
    public void iAmOnTheJdiIndexPage() {
        TestContext.getDriver().get(Urls.JDI.getUrl());
    }

    @Given("I login as user '([^\"]*)'")
    public void iLoginAsUser(String userName){
        Users user = Users.valueOf(userName.toUpperCase().replace(' ', '_'));
        pageLoginPageHelper.login(user.getLogin(), user.getPassword());
    }

}
