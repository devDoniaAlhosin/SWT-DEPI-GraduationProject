package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.OrderHistoryPage;

public class OrderHistoryTest extends BaseTest {

    @Test
    public void testOrderHistory() throws InterruptedException {

        // Login first
        doLogin();

        // Now we are on My Account Page (default after login)
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickOrderHistory();

        // Order History page object
        OrderHistoryPage orderPage = new OrderHistoryPage(driver);

        // Assertions
        Assert.assertEquals(orderPage.getHeaderText(), "Orders", "❌ Orders page not opened!");

        Assert.assertTrue(
                orderPage.getNoOrdersMessage().contains("You have not made any previous orders"),
                "❌ No orders message NOT visible!"
        );
    }
}
