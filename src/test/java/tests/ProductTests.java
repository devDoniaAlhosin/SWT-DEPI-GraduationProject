package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.WishlistPage;

public class ProductTests extends BaseTest {

    @Test
    public void verifyProductDetails() {
        ProductPage product = new ProductPage(driver);

        product.openProductPage("MacBook");

        Assert.assertTrue(product.getProductName().contains("MacBook"), "Product name is incorrect");
        Assert.assertTrue(product.getProductPrice().startsWith("$"), "Price format incorrect");
        Assert.assertTrue(product.isProductImageDisplayed(), "Product image not visible");
    }

    @Test
    public void addProductToCart() {
        ProductPage product = new ProductPage(driver);

        product.openProductPage("MacBook");
        product.addToCart();

        Assert.assertTrue(product.isSuccessMessageDisplayed(), "Success message not shown");
    }

    @Test
    public void addProductToWishlist() {
        ProductPage product = new ProductPage(driver);
        WishlistPage wishlist = new WishlistPage(driver);

        product.openProductPage("MacBook");
        product.addToWishlist();

        Assert.assertTrue(product.isSuccessMessageDisplayed(), "Success message not displayed");

        wishlist.openWishlistPage();
        Assert.assertTrue(wishlist.isProductInWishlist("MacBook"), "Product not found in wishlist");
    }

}
