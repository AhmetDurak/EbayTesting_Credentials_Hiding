package com.StepDefinitions;

import com.Pages.LoginPage;
import com.Utilities.BrowserUtilities;
import io.cucumber.java.en.Given;

public class LoginStepDefs {
    LoginPage ebay;

    @Given("User should log in valid credentials")
    public void user_should_log_in_valid_credentials() {
        BrowserUtilities.waitFor(3);
        ebay = new LoginPage();
        BrowserUtilities.waitFor(3);
        ebay.consent.click();
        ebay.login.click();


        ebay.credentials();
    }
}
