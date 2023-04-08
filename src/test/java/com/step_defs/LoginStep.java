package com.step_defs;

import com.pages.AddEducationPage;
import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class LoginStep {
    LoginPage loginPage=new LoginPage();
    DashboardPage dashboardPage=new DashboardPage();
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


    @Then("The user type in valid credentials via map and verify success login")
    public void theUserTypeInValidCredentialsViaMapAndVerifySuccessLogin(Map<String,String> userInfo) {
        loginPage.loginWithCredentialsMtd(userInfo.get("userEmail"),userInfo.get("pass"));
        Assert.assertEquals(userInfo.get("name"),dashboardPage.userName.getText());
    }

    @Then("The user type in valid credentials via list and verify success login")
    public void theUserTypeInValidCredentialsViaListAndVerifySuccessLogin(List<String> userInfo){
        loginPage.loginWithCredentialsMtd(userInfo.get(0),userInfo.get(1));
        Assert.assertEquals(userInfo.get(2),dashboardPage.userName.getText());
    }
}
