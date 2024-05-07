/*
 * BasePage.java
 *
 * This class serves as the base page for all page classes in the framework.
 * It includes methods for common actions performed on web elements such as waiting for elements, entering text, clicking, and retrieving element text.
 */

package com.pages;

import com.constants.FrameworkConstants;
import com.driver.DriverManager;
import com.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    // Method to wait for an element to be visible
    protected WebElement waitForElement(By by) {
        return new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getWait())
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // Method to enter text into a field
    protected void enterText(By by, String text, String elementName) {
        waitForElement(by).sendKeys(text);
        waitForElement(by).sendKeys(Keys.TAB);
        ExtentLogger.pass(text + " is entered in " + elementName + " field");
    }

    // Method to click on an element
    protected void click(By by, String elementName) {
        waitForElement(by).click();
        ExtentLogger.pass(elementName + " is clicked");
    }

    // Method to get the text of an element
    protected String getTitle(By by) {
        return waitForElement(by).getText();
    }

    // Method to find multiple elements
    protected List<WebElement> element(By by) {
        return DriverManager.getDriver().findElements(by);
    }

}
