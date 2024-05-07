/*
 * RegistrationPage.java
 *
 * This class represents the registration page of the application.
 * It includes methods to interact with elements on the registration page.
 */

package com.pages;

import org.openqa.selenium.By;

public class RegistrationPage extends BasePage {

    // Locators for elements on the registration page
    private final By btnRegistration = By.xpath("//span[text()='Registreerimine']/ancestor::button");
    private final By btnForJobSeekers = By.xpath("//span[text()='Tööotsijatele']/ancestor::button");
    private final By btnCreateAccountByEmail = By.xpath("//span[text()='Loo konto e-mailiga']/ancestor::button");

    // Method to click the Registration button
    public RegistrationPage clickRegistration() {
        click(btnRegistration, "Registration button");
        return this;
    }

    // Method to click the For Job Seekers button
    public RegistrationPage clickForJobSeekers() {
        click(btnForJobSeekers, "JobSeekers button");
        return this;
    }

    // Method to click the Create Account by Email button and navigate to the create account page
    public CreateAccountPage clickCreateAccountByEmail() {
        click(btnCreateAccountByEmail, "CreateAccountByEmail button");
        return new CreateAccountPage();
    }
}
