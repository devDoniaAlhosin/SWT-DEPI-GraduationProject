package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.WishlistPage;

public class WishlistTests {

    @Test
    public void addProductToWishlist() {
        ProductPage product = new ProductPage(driver);
        WishlistPage wishlist = new WishlistPage(driver);

        // Open any product page
        product.openProductPage("MacBook");

        // Add to wishlist
        product.addToWishlist();

        // Verify success
        Assert.assertTrue(product.isSuccessMessageDisplayed(),
                "Success message not displayed after adding product to wishlist");

        // Open wishlist
        wishlist.openWishlistPage();

        // Verify product is added
        Assert.assertTrue(wishlist.isProductInWishlist("MacBook"),
                "Product not found in wishlist");
    }

    @Test
    public void removeProductFromWishlist() {
        ProductPage product = new ProductPage(driver);
        WishlistPage wishlist = new WishlistPage(driver);

        // Add a product first
        product.openProductPage("iPhone");
        product.addToWishlist();

        // Open wishlist
        wishlist.openWishlistPage();
        Assert.assertTrue(wishlist.isProductInWishlist("iPhone"),
                "Product should be in wishlist before removing");

        // Remove product
        wishlist.removeItem("iPhone");

        // Verify removed
        Assert.assertFalse(wishlist.isProductInWishlist("iPhone"),
                "Product still appears in wishlist after removal");
    }

    @Test
    public void addWishlistItemToCart() {
        ProductPage product = new ProductPage(driver);
        WishlistPage wishlist = new WishlistPage(driver);

        // Add product to wishlist
        product.openProductPage("Canon");
        product.addToWishlist();

        // Open wishlist
        wishlist.openWishlistPage();
        Assert.assertTrue(wishlist.isProductInWishlist("Canon"),
                "Product not added to wishlist");

        // Add to cart from wishlist
        wishlist.addItemToCart("Canon");

        // Verify success message
        Assert.assertTrue(wishlist.isSuccessMessageDisplayed(),
                "Success message for adding to cart from wishlist not displayed");
    }
}
