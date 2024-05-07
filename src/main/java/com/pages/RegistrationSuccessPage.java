/*
 * RegistrationSuccessPage.java
 *
 * This class represents the registration success page of the application.
 * It includes methods to interact with elements on the registration success page.
 */

package com.pages;

import org.openqa.selenium.By;

public class RegistrationSuccessPage extends BasePage{

    // Locator for the registration success message
    private final By txtRegistrationSuccess = By.xpath("//div[contains(@class,'email-registration-success__text')]");

    // Method to get the title count of the registration success page
    public int getTitle() throws InterruptedException {
        Thread.sleep(2000);
        return element(txtRegistrationSuccess).size();
    }
}
