package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //define the path
        features = "@target/failed.txt",
        //glue is where we can find implementation for Gherkin steps
        glue = "steps",
        //if we set dryRun to true no actual execution happens
        //it will quickly scan all Gherkin steps whether they have implementation or not
        //dryRun = false, not necessary here
        //it keeps console output for the Cucumber test easily readable
        //it will remove all the unnecessary unreadable characters
        monochrome = true,
        //executes scenarios with specified tags
        //tags = "@error", not necessary here
        //pretty- it takes care of printing the steps in console
        //plugin - we use it to generate report for the execution
        plugin = {"pretty"}
)
public class FailedRunner {
}
