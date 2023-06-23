package org.opencart;

import org.opencart.managers.DriverManager;
import org.opencart.managers.FakeDataManager;
import org.opencart.pageobjects.AccountCreatedPage;
import org.opencart.pageobjects.HomePage;
import org.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

public class TestRunner {
    public static <StaleElementException extends Throwable> void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverManager.getInstance().getDriver();
        driver.get("https://andreisecuqa.host/");

        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();


        String fakeName = FakeDataManager.generateFakeName();
        String fakeLastName = FakeDataManager.generateFakeName();
        String fakeEmail = FakeDataManager.generateFakeEmail();
        String fakePassword = FakeDataManager.generateFakePassword(10,25);

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillTheRegisterForm(fakeName, fakeLastName, fakeEmail, fakePassword);
        registerPage.switchOnThePrivacyToggle(driver);
        registerPage.clickOnContinueButton(driver);

        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        accountCreatedPage.clickLogoutButton(driver);

        driver.quit();

        System.out.println("The driver is closed.");


    }
}