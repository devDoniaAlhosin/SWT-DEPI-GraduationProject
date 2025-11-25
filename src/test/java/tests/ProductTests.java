package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.WishlistPage;
import utils.TestDataUtil;

public class ProductTests extends BaseTest {

    @Test
    public void verifyProductDetails() {
        ProductPage product = new ProductPage(driver);

        String productName = TestDataUtil.getValue("test.products.macbook");

        product.openProductPage(productName);

        Assert.assertTrue(product.getProductName().contains(productName), "Product name is incorrect");
        Assert.assertTrue(product.getProductPrice().startsWith("$"), "Price format incorrect");
        Assert.assertTrue(product.isProductImageDisplayed(), "Product image not visible");
    }

    @Test
    public void addProductToCart() {
        ProductPage product = new ProductPage(driver);

        String productName = TestDataUtil.getValue("test.products.macbook");

        product.openProductPage(productName);
        product.addToCart();

        Assert.assertTrue(product.isSuccessMessageDisplayed(), "Success message not shown");
    }

    @Test
    public void addProductToWishlist() throws InterruptedException {

        doLogin(); // login is required for wishlist

        ProductPage product = new ProductPage(driver);
        WishlistPage wishlist = new WishlistPage(driver);

        String productName = TestDataUtil.getValue("test.products.macbook");

        product.openProductPage(productName);
        product.addToWishlist();

        Assert.assertTrue(product.isSuccessMessageDisplayed(), "Success message not displayed");

        wishlist.openWishlistPage();

        Assert.assertTrue(wishlist.isProductInWishlist(productName),
                "Product not found in wishlist");
    }
}
