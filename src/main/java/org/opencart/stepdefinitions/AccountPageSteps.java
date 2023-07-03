package org.opencart.stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.opencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;

public class AccountPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    @Then("the new page url contains {string} keyword")
    public void theNewPageUrlContainsKeyword(String collectingStringValue) throws InterruptedException {
        Thread.sleep(1000);
        boolean urlContainsSuccessKeyword = driver.getCurrentUrl().contains(collectingStringValue);
        Assertions.assertTrue(urlContainsSuccessKeyword, "The " + collectingStringValue + " is present on the URL.");
    }
}
