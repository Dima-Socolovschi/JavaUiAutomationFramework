package org.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {
    public Page(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[text() = 'My Account']")
    protected WebElement myAccountButton;

    @FindBy(xpath = "//a[text() = 'Register']")
    protected WebElement registerButton;

    public void navigateToRegisterPage(){
        myAccountButton.click();
        registerButton.click();
    }
}
