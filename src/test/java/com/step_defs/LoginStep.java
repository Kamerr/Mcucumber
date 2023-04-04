package com.step_defs;

import com.pages.AddEducationPage;
import com.pages.LoginPage;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class LoginStep {
    LoginPage loginPage=new LoginPage();
    AddEducationPage addEducation=new AddEducationPage();
    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));

    }
    @When("The user type in Kamer's credentials")
    public void the_user_type_in_Kamer_s_credentials() {
       loginPage.loginMtd();
    }

    @When("The user type in valid credentials:{string}and {string}")
    public void theUserTypeInValidCredentialsAnd(String userEmail, String password) {
        loginPage.loginWithCredentialsMtd(userEmail, password);
    }

    @Then("The user should be able to see {string} button")
    public void theUserShouldBeAbleToSeeButton(String buttonName) {
        Assert.assertTrue(addEducation.addEducationBtn.isDisplayed());
    }


}
