package org.opencart;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/org/opencart/features",
        glue = "org.opencart.stepdefinitions",
        tags = "",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class CucumberTestRunner {
}
