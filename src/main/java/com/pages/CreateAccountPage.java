/*
 * CreateAccountPage.java
 *
 * This class represents the page for creating a new account.
 * It includes methods to interact with elements on the create account page and verify user account creation.
 */

package com.pages;

import com.reports.ExtentLogger;
import org.openqa.selenium.By;

public class CreateAccountPage extends BasePage {

    // Locators for elements on the create account page
    private final By txtTitle = By.xpath("//span[text()='Loo konto']");
    private final By txtEmail = By.name("email");
    private final By txtPassword = By.name("password");
    private final By txtFirstName = By.name("firstName");
    private final By txtSurName = By.name("lastName");
    private final By chkAgreeTerms = By.xpath("//input[@name='agreeTerms']/..//span[1]");
    private final By chkAgreeInfo = By.xpath("//input[@name='agreeGdpr']/..//span[1]");
    private final By btnRegister = By.xpath("//span[text()='Registreeri']");
    private final By invalidEmail = By.xpath("//span[text()='Sisesta kehtiv e-posti aadress']");
    private final By invalidPassword = By.xpath("//span[text()='Liiga lühike sisend.']");
    private final By invalidFirstName = By.xpath("//input[@name='firstName']/ancestor::label[contains(@class,'input-text--state-error')]");
    private final By invalidSurName = By.xpath("//input[@name='lastName']/ancestor::label[contains(@class,'input-text--state-error')]");
    private final By errChkAgreeTerms = By.xpath("//input[@name='agreeTerms']/following-sibling::span[contains(@class,'input-checkbox__icon--error')]");
    private final By errChkAgreeInfo = By.xpath("//input[@name='agreeGdpr']/following-sibling::span[contains(@class,'input-checkbox__icon--error')]");

    // Method to get the header title of the create account page
    public String getHeaderTitle() {
        return getTitle(txtTitle);
    }

    // Method to enter email in the create account form
    public CreateAccountPage enterEmail(String email) {
        enterText(txtEmail, email, "Email");
        return this;
    }

    // Method to enter password in the create account form
    public CreateAccountPage enterPassword(String password) {
        enterText(txtPassword, password, "Password");
        return this;
    }

    // Method to enter first name in the create account form
    public CreateAccountPage enterFirstName(String firstName) {
        enterText(txtFirstName, firstName, "First Name");
        return this;
    }

    // Method to enter surname in the create account form
    public CreateAccountPage enterSurName(String surName) {
        enterText(txtSurName, surName, "Surname");
        return this;
    }

    // Method to check the Agree Terms checkbox in the create account form
    public CreateAccountPage checkAgreeTerms(boolean chk_AgreeTerms) {
        if (chk_AgreeTerms) {
            click(chkAgreeTerms, "Agree Terms Checkbox");
        } else {
            ExtentLogger.info("Agree Terms Checkbox is not checked");
        }
        return this;
    }

    // Method to check the Agree Info checkbox in the create account form
    public CreateAccountPage checkAgreeInfo(boolean chk_AgreeInfo) {
        if (chk_AgreeInfo) {
            click(chkAgreeInfo, "Agree Info Checkbox");
        } else {
            ExtentLogger.info("Agree Info Checkbox is not checked");
        }
        return this;
    }

    // Method to click the Register button in the create account form and navigate to the registration success page
    public RegistrationSuccessPage clickRegister() {
        click(btnRegister, "Register button");
        return new RegistrationSuccessPage();
    }

    // Method to verify user account creation
    public int verifyUserAccountCreation(String email, String password, String firstname, String surname, boolean agreeTerms, boolean agreeInfo) throws InterruptedException {
        int count = enterEmail(email).enterPassword(password).enterFirstName(firstname).enterSurName(surname)
                .checkAgreeTerms(agreeTerms).checkAgreeInfo(agreeInfo).clickRegister().getTitle();

        verifyError(invalidEmail, "Email", false);
        verifyError(invalidPassword, "Password", false);
        verifyError(invalidFirstName, "First name", false);
        verifyError(invalidSurName, "Surname", false);
        verifyError(errChkAgreeTerms, "Agree terms", true);
        verifyError(errChkAgreeInfo, "Agree info", true);

        return count;
    }

    // Method to verify errors on the create account form
    public void verifyError(By by, String fieldName, boolean isCheckbox) {

        if (!element(by).isEmpty() && element(by).getFirst().isDisplayed()) {
            String errorMessage = isCheckbox ? fieldName + " should be checked" : "Enter valid " + fieldName;
            ExtentLogger.fail(errorMessage);
        }
    }
}
