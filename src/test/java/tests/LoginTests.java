package tests;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.TestDataUtil;
import utils.LogUtil;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    private LoginPage goToLoginPage() {
        LogUtil.info("Navigating to Login page");

        HomePage home = new HomePage(driver);
        home.clickLogin();

        LogUtil.info("Login page opened successfully");
        return new LoginPage(driver);
    }

    // ========================================
    // 1. INVALID EMAIL
    // ========================================
    @Test(priority = 1)
    public void testInvalidEmail() {
        LogUtil.info("Starting Test: Invalid Email");

        LoginPage login = goToLoginPage();

        login.enterEmail(TestDataUtil.getValue("login.invalidEmail.email"));
        login.enterPassword(TestDataUtil.getValue("login.invalidEmail.password"));
        login.clickLogin();

        Assert.assertTrue(login.getWarningMessage().contains("Warning"));
        LogUtil.info("Invalid Email Test Passed");
    }

    // ========================================
    // 2. INVALID PASSWORD
    // ========================================
    @Test(priority = 2)
    public void testInvalidPassword() {
        LogUtil.info("Starting Test: Invalid Password");

        LoginPage login = goToLoginPage();

        login.enterEmail(TestDataUtil.getValue("login.invalidPassword.email"));
        login.enterPassword(TestDataUtil.getValue("login.invalidPassword.password"));
        login.clickLogin();

        Assert.assertTrue(login.getWarningMessage().contains("Warning"));
        LogUtil.info("Invalid Password Test Passed");
    }

    // ========================================
    // 3. INVALID BOTH
    // ========================================
    @Test(priority = 3)
    public void testInvalidBoth() {
        LogUtil.info("Starting Test: Invalid Email + Invalid Password");

        LoginPage login = goToLoginPage();

        login.enterEmail(TestDataUtil.getValue("login.invalidBoth.email"));
        login.enterPassword(TestDataUtil.getValue("login.invalidBoth.password"));
        login.clickLogin();

        Assert.assertTrue(login.getWarningMessage().contains("Warning"));
        LogUtil.info("Invalid Both Test Passed");
    }

    // ========================================
    // 4. EMPTY EMAIL + EMPTY PASSWORD
    // ========================================
    @Test(priority = 4)
    public void testEmptyFields() {
        LogUtil.info("Starting Test: Empty Email & Empty Password");

        LoginPage login = goToLoginPage();

        login.enterEmail(TestDataUtil.getValue("login.empty.email"));
        login.enterPassword(TestDataUtil.getValue("login.empty.password"));
        login.clickLogin();

        Assert.assertTrue(login.getWarningMessage().contains("Warning"));
        LogUtil.info("Empty Fields Login Test Passed");
    }

    // ========================================
    // 5. VALID LOGIN (RUN LAST)
    // ========================================
    @Test(priority = 5)
    public void testValidLogin() throws InterruptedException {
        LogUtil.info("Starting Test: Valid Login");

        // Reset session BEFORE valid login
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        Thread.sleep(1000);

        LoginPage login = goToLoginPage();

        login.enterEmail(TestDataUtil.getValue("login.valid.email"));
        login.enterPassword(TestDataUtil.getValue("login.valid.password"));
        login.clickLogin();

        // Wait for page navigation
        Thread.sleep(1500);

        LogUtil.info("Page Title After Login: " + driver.getTitle());

        Assert.assertTrue(driver.getTitle().contains("My Account"),
                "Login failed. Title is: " + driver.getTitle());

        LogUtil.info("Valid Login Test Passed");
    }
}
