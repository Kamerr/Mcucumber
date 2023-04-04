package com.step_defs;

import com.pages.AddEducation;
import com.pages.OverviewPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MyProfile_Stepdefs {
    OverviewPage overviewPage=new OverviewPage();
    AddEducation addEducation=new AddEducation();
    @Then("The user should be able to see overviewpage")
    public void theUserShouldBeAbleToSeeOverviewpage() {
        Assert.assertTrue(overviewPage.overviewPageSubTitle.isDisplayed());
    }

    @When("The user navigate to profile tab:{string}")
    public void theUserNavigateToProfileTab(String tab) {
        overviewPage.navigateToModule(tab);
    }

    @When("The user fill the form with followings:{string},{string},{string},{string},{string},{string}")
    public void theUserFillTheFormWithFollowings(String schoolName, String degree, String study, String fromDate, String toDate, String programDescription) {
     addEducation.addEducation(schoolName,degree,study,fromDate,toDate,programDescription);
    }

    @Then("The user should be added record with:{string}")
    public void theUserShouldBeAddedRecordWith(String expectedSchoolName) {
    String actualSchoolName= overviewPage.addedEducationName(expectedSchoolName);
    Assert.assertEquals(expectedSchoolName,actualSchoolName);}

    @And("The user should be able to delete last added record with:{string}")
    public void theUserShouldBeAbleToDeleteLastAddedRecordWith(String schoolName) {
        overviewPage.deleteEducation(schoolName);
    }
}
