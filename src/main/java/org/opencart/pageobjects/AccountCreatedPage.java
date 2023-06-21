package org.opencart.pageobjects;

import org.opencart.managers.ScrollManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends Page{
    public AccountCreatedPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[text() = 'Logout' and @class='list-group-item']")
    private WebElement logoutButton;

    @FindBy(xpath = "//a[text() = 'Account']")
    private WebElement accountTab;

    public void clickLogoutButton(WebDriver driver) throws InterruptedException {
        Thread.sleep(500);
        accountTab.click();
        ScrollManager.scrollToElement(driver,logoutButton);
        Thread.sleep(500);
        logoutButton.click();
    }

}
