package com.step_defs;

import com.pages.AddEducationPage;
import com.pages.OverviewPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class MyProfile_Stepdefs {
    OverviewPage overviewPage=new OverviewPage();
    AddEducationPage addEducation=new AddEducationPage();
    @Then("The user should be able to see overviewpage")
    public void theUserShouldBeAbleToSeeOverviewpage() {
        Assert.assertTrue(overviewPage.overviewPageSubTitle.isDisplayed());
    }

    @When("The user navigate to profile tab:{string}")
    public void theUserNavigateToProfileTab(String tab) {
        overviewPage.navigateTab(tab);
    }

    @When("The user fill the form with followings:{string},{string},{string},{string},{string},{string}")
    public void theUserFillTheFormWithFollowings(String schoolName, String degree, String study, String fromDate, String toDate, String programDescription) {
     addEducation.addEducation(schoolName,degree,study,fromDate,toDate,programDescription);
    }



//    @And("The user should be able to delete last added record with:{string}")
//    public void theUserShouldBeAbleToDeleteLastAddedRecordWith(String schoolName) {
//        overviewPage.deleteEducation(schoolName);
//    }
    @When("The user fill the form with followings with list:")
    public void theUserFillTheFormWithFollowingsWithList(List<String> educationInfos){
        addEducation.addEducation(educationInfos.get(0),educationInfos.get(1),educationInfos.get(2),educationInfos.get(3),educationInfos.get(4),educationInfos.get(5));

    }
}
