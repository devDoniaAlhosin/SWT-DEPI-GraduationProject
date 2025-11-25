package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    // /////////////////////// Locators ///////////////////////

    private final WebDriver driver;

    private final By addToCartButton = By.id("button-cart");
    private final By miniCartButton = By.xpath("//*[@id=\"cart\"]/div/button");
    private final By viewCartLink = By.xpath("//*[@id=\"top\"]/div/div/div[2]/ul/li[4]/a");
    private final By quantityInput = By.xpath("//*[@id=\"output-cart\"]/table/tbody/tr/td[3]/form/div/input[1]");
    private final By updateButton = By.xpath("//*[@id=\"output-cart\"]/table/tbody/tr/td[3]/form/div/button");
    private final By removeButton = By.xpath("//*[@id=\"output-cart\"]/table/tbody/tr/td[3]/form/div/a");
    private final By successMessage = By.cssSelector(".alert-success");
    private final By emptyCartText = By.xpath("//p[contains(text(),'Your shopping cart is empty!')]");

    // /////////////////////// Constructor ///////////////////////

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // /////////////////////// Actions ///////////////////////

    // Add product to cart
    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    // Open mini cart
    public void openMiniCart() {
        driver.findElement(miniCartButton).click();
    }

    // Click "View Cart"
    public void clickViewCart() {
        driver.findElement(viewCartLink).click();
    }

    // Update product quantity
    public void updateQuantity(String qty) {
        driver.findElement(quantityInput).clear();
        driver.findElement(quantityInput).sendKeys(qty);
        driver.findElement(updateButton).click();
    }

    // Remove product from cart
    public void removeProduct() {
        driver.findElement(removeButton).click();
    }

    // /////////////////////// Assertion ///////////////////////

    // Check if success message displayed
    public boolean isSuccessMessageDisplayed() {
        return driver.findElement(successMessage).isDisplayed();
    }

    // Check if cart is empty
    public boolean isCartEmpty() {
        return !driver.findElements(emptyCartText).isEmpty();
    }
}
