package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

    private WebDriver driver;

    // Constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By productNameLocator = By.cssSelector("h1");
    private By productPriceLocator = By.cssSelector(".list-unstyled h2");
    private By productImageLocator = By.cssSelector(".img-thumbnail");
    private By addToCartButton = By.id("button-cart");
    private By successMessageLocator = By.cssSelector(".alert-success");
    private By addToWishlistButton = By.cssSelector("button[data-original-title='Add to Wish List']");

    // Methods
    public void openProductPage(String productName) {
        driver.get("https://demo.opencart.com/index.php?route=product/search&search=" + productName);
        driver.findElement(By.linkText(productName)).click();
    }

    public String getProductName() {
        return driver.findElement(productNameLocator).getText();
    }

    public String getProductPrice() {
        return driver.findElement(productPriceLocator).getText();
    }

    public boolean isProductImageDisplayed() {
        return driver.findElement(productImageLocator).isDisplayed();
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void addToWishlist() {
        driver.findElement(addToWishlistButton).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return driver.findElement(successMessageLocator).isDisplayed();
    }

}
