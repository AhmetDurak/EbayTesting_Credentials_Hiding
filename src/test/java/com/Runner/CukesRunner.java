package com.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/test-report.html",
                "rerun:target/rerun.txt",
                "json:target/test-report-for-jira.json",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",
        glue = "com/StepDefinitions",
        dryRun = false,
        tags = "",
        publish = false
)
public class CukesRunner {
}
