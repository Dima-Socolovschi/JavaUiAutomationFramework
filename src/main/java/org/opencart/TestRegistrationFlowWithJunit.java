package org.opencart;

import jdk.jfr.Name;
import org.junit.jupiter.api.*;
import org.opencart.managers.DriverManager;
import org.opencart.managers.FakeDataManager;
import org.opencart.pageobjects.AccountCreatedPage;
import org.opencart.pageobjects.HomePage;
import org.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;

public class TestRegistrationFlowWithJunit {
    private WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;
    AccountCreatedPage accountCreatedPage;

    @BeforeAll
    public static void beforAll(){
        System.out.println("This test is before all.");
    }

    @BeforeEach
    public void beforeEach(){
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://andreisecuqa.host/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
    }

    @AfterEach
    public void afterEach(){
        DriverManager.getInstance().quiteDriver();
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("This text is after all.");
    }

    @Test
    @Order(1)
    @DisplayName("Register user test.")
    public void registerUserTest() throws InterruptedException {
        homePage.navigateToRegisterPage();

        String fakeName = FakeDataManager.generateFakeName();
        String fakeLastName = FakeDataManager.generateFakeName();
        String fakeEmail = FakeDataManager.generateFakeEmail();
        String fakePassword = FakeDataManager.generateFakePassword(10,25);

        registerPage.fillTheRegisterForm(fakeName, fakeLastName, fakeEmail, fakePassword);
        registerPage.switchOnThePrivacyToggle(driver);
        registerPage.clickOnContinueButton(driver);

        Thread.sleep(1000);
        boolean urlContainsSuccessKeyword = driver.getCurrentUrl().contains("success");
        Assertions.assertTrue(urlContainsSuccessKeyword);
    }

    @Test
    @Order(2)
    @DisplayName("Register user test without privacy button.")
    public void registerUserWithoutLastNameTest() throws InterruptedException {
        homePage.navigateToRegisterPage();

        String fakeName = FakeDataManager.generateFakeName();
        String fakeLastName = "";
        String fakeEmail = FakeDataManager.generateFakeEmail();
        String fakePassword = FakeDataManager.generateFakePassword(10,25);

        registerPage.fillTheRegisterForm(fakeName, fakeLastName, fakeEmail, fakePassword);
        registerPage.switchOnThePrivacyToggle(driver);
        registerPage.clickOnContinueButton(driver);


        Thread.sleep(1000);
        boolean urlContainsSuccessKeyword = driver.getCurrentUrl().contains("success");
        Assertions.assertFalse(urlContainsSuccessKeyword);
    }
}
