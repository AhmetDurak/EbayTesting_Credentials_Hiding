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

    @FindBy(id = "login")
    public WebElement username;


    @FindBy(id = "password")
    public WebElement password;

    @FindBy(css = "button[type='submit']")
    public WebElement loginBtn;


    /**
     * This method will return a valid credential as a tester
     */
    public void credentials(){
        /*secret-key --> selman*/
        String username = EncryptionUtils.decrypt(GetCredentials.get("username"), "secret-key");
        String password = EncryptionUtils.decrypt(GetCredentials.get("password"), "secret-key");
        this.username.sendKeys(username);
        this.password.sendKeys(password + Keys.ENTER);


        //System.out.println("LOOK AT HERE !!!!!!!!!!!!!!!!!!!");
        //System.out.println(GetCredentials.get(username));
        //System.out.println(GetCredentials.get(password));



    }
}
