package com.StepDefinitions;

import com.Utilities.ConfigurationReader;
import com.Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp(){
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @After
    public void tearDown(){
      //Driver.closeDriver();
    }
}
