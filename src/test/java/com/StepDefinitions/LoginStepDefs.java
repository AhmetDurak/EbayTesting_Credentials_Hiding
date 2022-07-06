package com.StepDefinitions;

import com.Pages.LoginPage;

import io.cucumber.java.en.Given;

public class LoginStepDefs {
    LoginPage fidexio = new LoginPage();

    @Given("User should log in valid credentials")
    public void user_should_log_in_valid_credentials() {

        fidexio.credentials();
    }
}
