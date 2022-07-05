package com.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Utilities.*;

public class PageBase {
    public PageBase(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "gdpr-banner-accept")
    public WebElement consent;

    @FindBy(css = "#gh-ug>a")
    public WebElement login;

    @FindBy(id = "userid")
    public WebElement username;

    @FindBy(id = "signin-continue-btn")
    public WebElement continueBtn;

    @FindBy(id = "pass")
    public WebElement password;


    /**
     * This method will return a valid credential as a tester
     */
    public void credentials(){
        String username = "extendyoursenses@gmail.com";
        this.username.sendKeys(GetCredentials.get("username"));
        this.continueBtn.click();
        this.password.sendKeys(GetCredentials.get("password") + Keys.ENTER);


    }
}
