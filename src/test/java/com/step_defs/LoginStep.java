package com.step_defs;

import com.pages.AddEducation;
import com.pages.LoginPage;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStep {
    LoginPage loginPage=new LoginPage();
    AddEducation addEducation=new AddEducation();
    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));

    }
    @When("The user type in Kamer's credentials")
    public void the_user_type_in_Kamer_s_credentials() {
       loginPage.login();
    }

    @When("The user type in valid credentials:{string}and {string}")
    public void theUserTypeInValidCredentialsAnd(String userEmail, String password) {
        loginPage.login(userEmail, password);
    }

    @Then("The user should be able to see {string} button")
    public void theUserShouldBeAbleToSeeButton(String buttonName) {
        Assert.assertTrue(addEducation.addEducationBtn.isDisplayed());
    }
}
