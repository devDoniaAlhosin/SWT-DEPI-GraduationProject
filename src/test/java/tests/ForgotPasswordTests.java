package tests;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.ForgotPasswordPage;
import utils.TestDataUtil;
import utils.LogUtil;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTests extends BaseTest {

    @Test(priority = 1)
    public void testForgotPasswordFlow() throws InterruptedException {

        LogUtil.info("Starting Test: Forgot Password");

        // Step 1: Go to Login Page
        HomePage home = new HomePage(driver);
        home.clickLogin();
        Thread.sleep(800);

        LoginPage loginPage = new LoginPage(driver);

        // Step 2: Click Forgotten Password
        loginPage.clickForgotPassword();
        Thread.sleep(800);

        ForgotPasswordPage forgotPage = new ForgotPasswordPage(driver);

        // Step 3: Assert correct page title
        Assert.assertTrue(
                forgotPage.getPageTitle().contains("Forgot Your Password"),
                "Incorrect page title: " + forgotPage.getPageTitle()
        );

        // Step 4: Enter Email
        String email = TestDataUtil.getValue("login.valid.email");
        LogUtil.info("Entering email: " + email);
        forgotPage.enterEmail(email);

        // Step 5: Click Continue
        forgotPage.clickContinue();
        Thread.sleep(1000);

        // Step 6: Validate Success Alert (back on Login Page)
        String successMsg = forgotPage.getSuccessMessage();
        LogUtil.info("Success Message: " + successMsg);

        Assert.assertTrue(
                successMsg.toLowerCase().contains("success") ||
                        successMsg.toLowerCase().contains("text_success"),
                "Success message not shown."
        );

        LogUtil.info("Forgot Password Test PASSED");
    }
}
