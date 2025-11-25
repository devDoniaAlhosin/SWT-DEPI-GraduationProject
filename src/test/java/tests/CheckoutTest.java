package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductPage;

import java.time.Duration;

public class CheckoutTest extends BaseTest {

    @Test
    public void testGuestCheckout() {

        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1. Open first product
        home.openFirstProduct();

        // 2. Add product
        product.addToCart();

        // 3. Click cart link on success popup
        product.clickSuccessCartLink();

        // 4. Go to checkout
        cart.clickCheckout();

        // 5. Fill billing + shipping
        checkout.fillBillingDetails();

        // 6. Finish checkout
        checkout.completeCheckout();

        wait.until(ExpectedConditions.visibilityOf(checkout.getPageHeader()));
        String header = checkout.getPageHeader().getText();
        Assert.assertFalse(
                header.contains("Your order has been placed"),
                "Order should NOT be placed because user was registered instead!"
        );

        Assert.assertTrue(
                header.contains("Shopping Cart"),
                "Shopping Cart page was NOT displayed!"
        );



    }

}
