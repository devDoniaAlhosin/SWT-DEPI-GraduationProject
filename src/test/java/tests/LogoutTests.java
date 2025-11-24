package tests;

import base.BaseTest;
import pages.HomePage;
import utils.LogUtil;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTests extends BaseTest {

    @Test(priority = 1)
    public void testLogoutFromDropdown() throws InterruptedException {

        LogUtil.info("Starting Test: Logout from Top Navbar Dropdown");

        HomePage home = new HomePage(driver);

        // Click Logout
        home.clickLogoutDropdown();
        Thread.sleep(1000);

        String title = driver.getTitle();
        LogUtil.info("Page Title After Logout: " + title);

        Assert.assertTrue(
                title.contains("Account Logout") ||
                        driver.getPageSource().contains("You have been logged off"),
                "Logout failed — Title: " + title
        );

        LogUtil.info("Logout from Dropdown Test PASSED");
    }
}
