package org.example.tests;

import org.example.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    @Test
    public void testGuestCheckout() throws InterruptedException {
        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        home.openFirstProduct();
        product.addToCart();
        product.clickSuccessCartLink();
        cart.clickCheckout();

        checkout.fillBillingDetails();
        checkout.completeCheckout();

        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("Your order has been placed!"));
    }

}
