package com.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "com/StepDefinitions",
        glue = "@target/rerun.txt"
)
public class FailedTestRunner {
}
