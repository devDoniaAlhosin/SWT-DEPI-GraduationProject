package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test
    public void testAddProductToCart() {
        cartPage.clickAddToCart();
        Assert.assertTrue(cartPage.isSuccessMessageDisplayed(), "Product was NOT added to cart!");
    }

    @Test
    public void testMiniCartAndClickViewCart() {
        cartPage.clickAddToCart();
        cartPage.openMiniCart();
        cartPage.clickViewCart();

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout/cart"), "http://localhost/opencartproject/index.php?route=checkout/cart&language=en-gb");
    }

    @Test
    public void testUpdateQuantity() {
        cartPage.clickAddToCart();
        cartPage.openMiniCart();
        cartPage.clickViewCart();

        cartPage.updateQuantity("2");
        Assert.assertTrue(cartPage.isSuccessMessageDisplayed(), "Quantity update failed!");
    }

    @Test
    public void testRemoveProduct() {
        cartPage.clickAddToCart();
        cartPage.openMiniCart();
        cartPage.clickViewCart();

        cartPage.removeProduct();
        Assert.assertTrue(cartPage.isCartEmpty(), "Cart is NOT empty after removal!");
    }
}
