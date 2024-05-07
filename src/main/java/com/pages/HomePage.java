/*
 * HomePage.java
 *
 * This class represents the home page of the application.
 * It includes methods to interact with elements on the home page.
 */

package com.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    // Locator for the Login or Register button
    private final By btnLoginOrRegister = By.xpath("//span[text()='Logi sisse / registreeri']/ancestor::button");

    // Method to click the Login or Register button and navigate to the registration page
    public RegistrationPage clickLoginOrRegister() {
        click(btnLoginOrRegister, "Login Or Register button");
        return new RegistrationPage();
    }
}
