package com.test.base;

import com.pages.CreateAccountPage;
import com.pages.HomePage;
import com.reports.ExtentLogger;
import net.bytebuddy.utility.RandomString;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidateCreateNewAccountTest extends BaseTest {


    private static final String REGISTRATION_HEADER = "Loo konto";

    @Test(dataProvider = "TestData")
    public void validateNewAccountCreation(String email, String pass, String firstName, String surName, boolean agreeTerms, boolean agreeInfo) throws InterruptedException {

        String title = new HomePage().clickLoginOrRegister().clickRegistration()
                .clickForJobSeekers().clickCreateAccountByEmail()
                .getHeaderTitle();
        ExtentLogger.info("Verify Registration page title");

        if(title.equalsIgnoreCase(REGISTRATION_HEADER)){
            ExtentLogger.pass("User is successfully navigated to Create Account Page");
        }
        else {
            ExtentLogger.fail("Error!");
        }

        int errorCount = new CreateAccountPage().verifyUserAccountCreation(email, pass, firstName, surName, agreeTerms, agreeInfo);
        if(errorCount>0){
            ExtentLogger.pass("New account has created successfully");
        }
        else {
            ExtentLogger.fail("Error! New account has not created");
        }
    }

    @DataProvider(name = "TestData")
    public Object[][] testData() {
        String random = RandomString.make(5).toLowerCase();
        return new Object[][]{
                {random+"@gmail.com", "password123", "John", "Doe", true, true},
                {"@gmail.com", "password123", "John", "Doe", true, true},
                {random+"gmail.com", "password123", "John", "Doe", true, true},
                {random+"@gmailcom", "password123", "John", "Doe", true, true},
                {"", "password123", "John", "Doe", true, true},
                {random+"@gmail.com", "", "John", "Doe", true, true},
                {random+"@gmail.com", "1", "John", "Doe", true, true},
                {random+"@gmail.com", "1a", "John", "Doe", true, true},
                {random+"@gmail.com", "1@3", "John", "Doe", true, true},
                {random+"@gmail.com", "1234", "John", "Doe", true, true},
                {random+"@gmail.com", "abcde", "John", "Doe", true, true},
                {random+"@gmail.com", "abc123", "", "Doe", true, true},
                {random+"@gmail.com", "password123", "John", "", true, true},
                {random + "@gmail.com", "password123", "John", "Doe", false, true},
                {random + "@gmail.com", "password123", "John", "Doe", true, false}
        };
    }
}
