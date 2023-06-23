package org.opencart.pageobjects;

import org.opencart.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends Page {
    public RegisterPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstNameInput;
    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameInput;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@name='agree']")
    private WebElement privacyToggle;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    public void fillTheRegisterForm(String firstName, String lastName, String email, String password){
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }

    public void switchOnThePrivacyToggle(WebDriver driver) throws InterruptedException{
        ScrollManager.scrollToElement(driver, privacyToggle);
        privacyToggle.click();
    }

    public void clickOnContinueButton(){
        submitButton.click();
    }
}
