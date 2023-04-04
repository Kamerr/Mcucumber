package com.pages;


import com.utilities.BrowserUtils;
import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = "nav>ul>li")
    public List<WebElement> tabNames;

    @FindBy(xpath = "//span[text()='Login']")
    public WebElement loginBtn;

    public void navigateTabAndModule(String tabName, String moduleName){
        WebElement tab = Driver.get().findElement(By.xpath("//span[.='"+tabName+"']"));
        tab.click();
        WebElement module = Driver.get().findElement(By.xpath("//span[.='" + moduleName + "']"));
        BrowserUtils.clickWithJS(module);
    }

    public void navigateTab(String tabName){
        WebElement tab = Driver.get().findElement(By.xpath("//li//button[.='"+tabName+"']"));
        tab.click();
    }

    public void logoutAndNavigateToLoginPage(String userName){
        navigateTabAndModule(userName,"Sign Out");
        loginBtn.click();
    }
}