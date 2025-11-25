package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductPage;
import pages.WishlistPage;
import utils.LogUtil;
import utils.TestDataUtil;

public class WishlistTests extends BaseTest {

    @Test
    public void addProductToWishlist() throws InterruptedException {
        doLogin();
        LogUtil.info("=== TEST: Add Product To Wishlist ===");

        ProductPage product = new ProductPage(driver);
        WishlistPage wishlist = new WishlistPage(driver);

        String productName = TestDataUtil.getValue("test.products.iphone");

        product.openProductPage(productName);
        product.addToWishlist();

        Assert.assertTrue(product.isSuccessMessageDisplayed(),
                "❌ Success message not displayed!");

        wishlist.openWishlistPage();

        Assert.assertTrue(wishlist.isProductInWishlist(productName),
                "❌ Product NOT found in wishlist!");
    }


    @Test
    public void removeProductFromWishlist() {

        LogUtil.info("=== TEST: Remove Product From Wishlist ===");

        ProductPage product = new ProductPage(driver);
        WishlistPage wishlist = new WishlistPage(driver);

        String productName = TestDataUtil.getValue("test.products.macbook");

        product.openProductPage(productName);
        product.addToWishlist();

        wishlist.openWishlistPage();
        Assert.assertTrue(wishlist.isProductInWishlist(productName));

        wishlist.removeItem(productName);

        Assert.assertTrue(wishlist.isSuccessMessageDisplayed(),
                "❌ No success message after removal!");

        wishlist.openWishlistPage(); // avoid redirect
        Assert.assertFalse(wishlist.isProductInWishlist(productName),
                "❌ Product still appears after removal!");
    }


    @Test
    public void addWishlistItemToCart() {

        LogUtil.info("=== TEST: Add Wishlist Item To Cart ===");

        ProductPage product = new ProductPage(driver);
        WishlistPage wishlist = new WishlistPage(driver);

        String productName = TestDataUtil.getValue("test.products.iphone");

        product.openProductPage(productName);
        product.addToWishlist();

        wishlist.openWishlistPage();
        Assert.assertTrue(wishlist.isProductInWishlist(productName));

        wishlist.addItemToCart(productName);

        Assert.assertTrue(wishlist.isSuccessMessageDisplayed(),
                "❌ Success message for add-to-cart NOT shown!");
    }
}
