package org.opencart;

import org.opencart.managers.DriverManager;
import org.opencart.managers.ScrollManager;
import org.opencart.managers.FakeDataManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        DriverManager manager = DriverManager.getInstance();
        WebDriver driver = manager.getDriver();

        String currentWindow = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://andreisecuqa.host/");
        System.out.println("Current URL is: " + driver.getCurrentUrl());

        WebElement myAccountDropdownList = driver.findElement(By.xpath("//span[text()='My Account']"));
        myAccountDropdownList.click();

        WebElement createNewAccount = driver.findElement(By.xpath("//a[text()='Register']"));
        createNewAccount.click();

        System.out.println("Current URL is: " + driver.getCurrentUrl());

        WebElement firstNameField = driver.findElement(By.xpath("//input[@name='firstname']"));
        String fakeName = FakeDataManager.generateFakeName();
        System.out.println("Fake name is: " + fakeName);
        firstNameField.sendKeys(fakeName);

        WebElement lastNameField = driver.findElement(By.xpath("//input[@name='lastname']"));
        String fakeLastName = FakeDataManager.generateFakeName();
        System.out.println("Fake name is: " + fakeLastName);
        lastNameField.sendKeys(fakeLastName);

        WebElement emailField = driver.findElement(By.xpath("//input[@name='email']"));
        String fakeEmail = FakeDataManager.generateFakeEmail();
        System.out.println("Fake name is: " + fakeEmail);
        emailField.sendKeys(fakeEmail);

        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        String fakePassword = FakeDataManager.generateFakePassword(10,25);
        System.out.println("Fake name is: " + fakePassword);
        passwordField.sendKeys(fakePassword);

        WebElement privacyPolicy = driver.findElement(By.xpath("//input[@name='agree']"));
        ScrollManager.scrollToElement(driver, privacyPolicy);
        privacyPolicy.click();

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        System.out.println("Current URL is: " + driver.getCurrentUrl());

        driver.close();

        driver.switchTo().window(currentWindow);
        driver.get("https://andreisecuqa.host/");

        System.out.println("Current URL is: " + driver.getCurrentUrl());

        driver.quit();

        System.out.println("The driver is closed.");


    }
}