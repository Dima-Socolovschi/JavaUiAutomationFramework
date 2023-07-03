package org.opencart.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.opencart.managers.DriverManager;
import org.opencart.managers.FakeDataManager;
import org.opencart.pageobjects.HomePage;
import org.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

public class RegisterPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage  registerPage = new RegisterPage(driver);

    @When("the registration form is completed with valid random data")
    public void theRegisterFormIsCompletedWithValidData(){
        String fakeName = FakeDataManager.generateFakeName();
        String fakeLastName = FakeDataManager.generateFakeName();
        String fakeEmail = FakeDataManager.generateFakeEmail();
        String fakePassword = FakeDataManager.generateFakePassword(10,25);

        registerPage.fillTheRegisterForm(fakeName, fakeLastName, fakeEmail, fakePassword);
    }

    @And("the privacyPolicyToggle is enabled")
    public void thePrivacyToggleIsEnabled(){
        try{
            registerPage.switchOnThePrivacyToggle(driver);
        } catch (InterruptedException e) {
            System.out.println("Error");;
        }
    }

    @And("continueButton is clicked")
    public void theContinueButtonIsClicked() throws InterruptedException {
        registerPage.clickOnContinueButton(driver);
    }
}
