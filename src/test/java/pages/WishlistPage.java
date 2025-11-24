package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage {

    private WebDriver driver;

    // Constructor
    public WishlistPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By wishlistLink = By.linkText("Wish List"); // رابط صفحة الـ Wishlist
    private By productNameInWishlist = By.cssSelector(".table-responsive td a"); // اسم المنتج
    private By successMessageLocator = By.cssSelector(".alert-success"); // رسالة النجاح

    // Methods
    public void openWishlistPage() {
        driver.findElement(wishlistLink).click();
    }

    public boolean isProductInWishlist(String productName) {
        try {
            return driver.findElement(productNameInWishlist).getText().equals(productName);
        } catch (Exception e) {
            return false;
        }
    }

    public void removeItem(String productName) {
        String removeButtonXpath = "//a[text()='" + productName + "']/../following-sibling::td/button[@data-original-title='Remove']";
        driver.findElement(By.xpath(removeButtonXpath)).click();
    }

    public void addItemToCart(String productName) {
        String addToCartXpath = "//a[text()='" + productName + "']/../following-sibling::td/button[@data-original-title='Add to Cart']";
        driver.findElement(By.xpath(addToCartXpath)).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return driver.findElement(successMessageLocator).isDisplayed();
    }
}
