package org.opencart;

import org.opencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) {
        DriverManager manager = DriverManager.getInstance();
        WebDriver driver = manager.getDriver();

        String currentWindow = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/5.3.3");
        driver.close();

        driver.switchTo().window(currentWindow);
        manager.getDriver().get("https://www.w3schools.com");
        driver.quit();

        System.out.println("The driver is closed.");
    }
}