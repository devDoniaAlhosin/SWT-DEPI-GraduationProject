package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage {

    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // ===== CORRECT LOCATORS FOR LOCALHOST =====
    private By successMessage = By.cssSelector(".alert-success");
    private By addToCartButton = By.id("button-cart");

    private By addToWishlistButton = By.cssSelector("button[formaction*='wishlist.add']");


    private By productNameLocator = By.cssSelector("h1");
    private By productPriceLocator = By.cssSelector(".list-unstyled h2, .price");
    private By productImageLocator = By.cssSelector("img.img-fluid, img.img-thumbnail");

    private WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(8));
    }

    // ===== OPEN PRODUCT PAGE ON LOCALHOST =====
    public void openProductPage(String productName) {

        // Search first
        driver.get("http://localhost/opencartproject/index.php?route=product/search&search=" + productName);

        By productLink = By.linkText(productName);

        getWait().until(ExpectedConditions.presenceOfElementLocated(productLink));

        WebElement link = driver.findElement(productLink);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);

        getWait().until(ExpectedConditions.elementToBeClickable(productLink));

        try {
            link.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
        }
    }

    public String getProductName() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(productNameLocator));
        return driver.findElement(productNameLocator).getText().trim();
    }

    public String getProductPrice() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(productPriceLocator));
        return driver.findElement(productPriceLocator).getText().trim();
    }

    public boolean isProductImageDisplayed() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(productImageLocator));
        return driver.findElement(productImageLocator).isDisplayed();
    }

    public void addToCart() {
        getWait().until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public void addToWishlist() {
        getWait().until(ExpectedConditions.elementToBeClickable(addToWishlistButton)).click();
    }

    public boolean isSuccessMessageDisplayed() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return driver.findElement(successMessage).isDisplayed();
    }
}
