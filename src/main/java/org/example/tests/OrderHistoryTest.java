package org.example.tests;

import org.example.pages.BaseTest;
import org.example.pages.OrderHistoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderHistoryTest extends BaseTest {
    @Test
    public void testOrderHistory() {

        driver.get("https://demo.opencart.com/index.php?route=account/order");

        OrderHistoryPage orders = new OrderHistoryPage(driver);
        Assert.assertTrue(orders.getOrderCount() >= 1, "No orders found!");
    }
}
