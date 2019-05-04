package com.exercise1.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( plugin = {
        "html:target/default-cucumber-report"},

        features ="src/test/resources/values",
        glue = "com/exercise1/step_definitions/", dryRun = false)


public class ProblemNo1Runner {
}
