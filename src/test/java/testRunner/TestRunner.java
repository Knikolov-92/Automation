package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/features"},
                glue = {"stepdefs"},
                tags = {"@DebugTest"},
                plugin = {"pretty", "html:target/cucumber-pretty"},
                monochrome = true
                )

public class TestRunner extends AbstractTestNGCucumberTests {
}
