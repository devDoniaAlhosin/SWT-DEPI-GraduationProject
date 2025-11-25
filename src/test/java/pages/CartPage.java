package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    By checkoutBtn = By.linkText("Checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

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
