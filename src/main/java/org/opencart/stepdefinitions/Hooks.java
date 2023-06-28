package org.opencart.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.opencart.managers.DriverManager;

public class Hooks {
    static int counter = 0;

    @BeforeAll
    public static void beforeAll(){
        System.out.println("The execution of feature is started.");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("The execution of feature is finished.");
    }

    @Before
    public static void beforeTest(){
        counter++;
        System.out.println("Test "+ counter + " started.");
    }

    @After
    public static void afterTest(){
        DriverManager.getInstance().quiteDriver();
        System.out.println("Test "+ counter + " finished.");
    }
}
