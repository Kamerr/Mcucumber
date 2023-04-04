package com.step_defs;

import com.pages.DashboardPage;
import com.utilities.BrowserUtils;
import com.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class DashBoard {
    DashboardPage dashboardPage=new DashboardPage();
   @Then("The user should be able to login succesfuly")
    public void the_user_should_be_able_to_login_succesfuly() {

       Assert.assertEquals("should be same", ConfigurationReader.get("userName"),dashboardPage.userName.getText());

    }

    @Then("The user should be able to see userName:{string}")
    public void theUserShouldBeAbleToSeeUserName(String expectedUserName) {
       String actualUserName=dashboardPage.userName.getText();
       Assert.assertEquals("should be same", expectedUserName,actualUserName);
    }


    @When("The user navigate to {string} and {string}")
    public void theUserNavigateToAnd(String tab, String module) {
       dashboardPage.navigateTabAndModule(tab, module);
    }

    @When("The user type in valid credentials:{string} and {string}")
    public void theUserTypeInValidCredentialsAnd(String tab, String module) {
       dashboardPage.navigateTabAndModule(tab, module);
    }

    @And("The user should be able to see all tabs that shown on the dashboard page")
    public void theUserShouldBeAbleToSeeAllTabsThatShownOnTheDashboardPage(List<String> expectedTabName) {
      List<String> actualTabNames= BrowserUtils.getElementsText(dashboardPage.tabNames);
      Assert.assertEquals(expectedTabName,actualTabNames);
        System.out.println("actualTabNames = " + actualTabNames);
        System.out.println("expectedTabName = " + expectedTabName);
    }
}
