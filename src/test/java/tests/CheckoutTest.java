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

        // ✅ 1) تأكد إن مافيش سشن ولا لوجين
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 2. Open first product
        home.openFirstProduct();

        // 3. Add product
        product.addToCart();

        // 4. Click cart link on success popup
        product.clickSuccessCartLink();

        // 5. Go to checkout
        cart.clickCheckout();

        // 6. Fill billing + shipping as GUEST
        checkout.fillBillingDetails();

        // 7. Finish checkout
        checkout.completeCheckout();

        wait.until(ExpectedConditions.visibilityOf(checkout.getPageHeader()));
        String header = checkout.getPageHeader().getText();

        Assert.assertFalse(
                header.contains("Your order has been placed"),
                "Order should NOT be placed because user was registered instead!"
        );

        Assert.assertFalse(
                header.contains("Shopping Cart"),
                "Shopping Cart page was NOT displayed!"
        );
    }


}
