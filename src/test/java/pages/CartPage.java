package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    By checkoutBtn = By.linkText("Checkout");

    public void clickCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By checkoutBtnLocator = By.xpath("//a[contains(@href,'route=checkout/checkout')]");

        WebElement checkoutBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(checkoutBtnLocator)
        );

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'})", checkoutBtn);

        // Small wait after scroll
        try { Thread.sleep(300); } catch (Exception ignored) {}

        // Try normal click
        try {
            wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
        } catch (Exception e) {
            // Fallback: JS click — solves 100% of intercept issues
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkoutBtn);
        }
    }


}
