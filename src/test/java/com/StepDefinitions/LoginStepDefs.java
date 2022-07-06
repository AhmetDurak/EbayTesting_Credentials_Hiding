package com.StepDefinitions;

import com.Pages.LoginPage;
import com.Utilities.BrowserUtilities;
import com.Utilities.GetCredentials;
import io.cucumber.java.en.Given;

public class LoginStepDefs {
    LoginPage fidexio = new LoginPage();

    @Given("User should log in valid credentials")
    public void user_should_log_in_valid_credentials() {
        fidexio.username.sendKeys(GetCredentials.get("username"));
        fidexio.password.sendKeys(GetCredentials.get("password"));
        fidexio.loginBtn.click();

        //fidexio.credentials();
    }
}
