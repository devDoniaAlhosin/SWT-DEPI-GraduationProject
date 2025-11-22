package tests;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.AccountPage;
import utils.TestDataUtil;
import utils.LogUtil;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTests extends BaseTest {

    // Helper method: perform valid login
    private void performValidLogin() throws InterruptedException {
        LogUtil.info("Performing valid login before logout test");

        // Always reset session
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        Thread.sleep(1000);

        // Navigate to login page
        HomePage home = new HomePage(driver);
        home.clickLogin();

        // Enter credentials
        LoginPage login = new LoginPage(driver);
        login.enterEmail(TestDataUtil.getValue("login.valid.email"));
        login.enterPassword(TestDataUtil.getValue("login.valid.password"));
        login.clickLogin();

        // Wait for redirect
        Thread.sleep(1500);

        // Validate login succeeded
        Assert.assertTrue(driver.getTitle().contains("My Account"),
                "Login failed — cannot continue logout test.");
    }

    @Test(priority = 1)
    public void testLogoutFromAccountPage() throws InterruptedException {

        LogUtil.info("Starting Test: Logout from My Account Page");

        // 1. LOGIN FIRST
        performValidLogin();

        // 2. NOW YOU ARE ON "MY ACCOUNT" PAGE
        AccountPage accountPage = new AccountPage(driver);

        // 3. CLICK LOGOUT FROM LEFT MENU
        accountPage.clickSidebarLogout();

        Thread.sleep(1000);

        LogUtil.info("Page Title After Logout: " + accountPage.getPageTitle());

        // 4. ASSERT LOGOUT SUCCESS PAGE
        Assert.assertTrue(
                accountPage.getPageTitle().contains("Account Logout") ||
                        driver.getPageSource().contains("You have been logged off"),
                "Logout failed. Title was: " + accountPage.getPageTitle()
        );

        LogUtil.info("Logout from My Account Page Test PASSED");
    }
}
