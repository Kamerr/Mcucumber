package com.pages;

import com.pages.BasePage;
import com.utilities.BrowserUtils;
import com.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends BasePage {

    @FindBy(xpath = "//button[.='Overview']")
    public WebElement overviewPageSubTitle;

    public void navigateUserProfileTabs(String tabName) {
        WebElement profileTab = Driver.get().findElement(By.xpath("//li//button[.='" + tabName + "']"));
        BrowserUtils.clickWithJS(profileTab);
    }

    public String addedEducationName(String schoolName) {
        return Driver.get().findElement(By.xpath("//input[.='" + schoolName + "']")).getText();
    }

    public void deleteEducation(String schoolName) {

        WebElement deleteIcon = Driver.get().findElement(By.xpath("//tr[@id='itemedu-704']//span"));
        BrowserUtils.waitForClickablility(deleteIcon, 5);
        BrowserUtils.clickWithJS(deleteIcon);
        Alert alert = Driver.get().switchTo().alert();
        alert.accept();
    }

}