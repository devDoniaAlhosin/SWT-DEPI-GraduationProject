package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WishlistPage {

    private WebDriver driver;

    public WishlistPage(WebDriver driver) {
        this.driver = driver;
    }

    // TOP NAV wishlist button
    private By wishlistNavLink = By.id("wishlist-total");

    private By productNames = By.cssSelector("tbody tr td:nth-child(2) a");
    private By successMessage = By.cssSelector(".alert-success");

    private WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(7));
    }

    public void openWishlistPage() {

        WebElement wishlistBtn = getWait().until(
                ExpectedConditions.elementToBeClickable(wishlistNavLink)
        );

        try {
            wishlistBtn.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", wishlistBtn);
        }
    }

    public boolean isProductInWishlist(String productName) {
        List<WebElement> items = driver.findElements(productNames);

        for (WebElement item : items) {
            if (item.getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void removeItem(String productName) {
        String removeXpath = "//a[text()='" + productName + "']/ancestor::tr//a[contains(@href,'wishlist.remove')]";

        WebElement removeBtn = getWait().until(
                ExpectedConditions.elementToBeClickable(By.xpath(removeXpath))
        );

        try {
            removeBtn.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", removeBtn);
        }
    }


    public void addItemToCart(String productName) {
        String addXpath = "//a[text()='" + productName + "']/../../td[last()]//button[contains(@form,'form-product')]";
        driver.findElement(By.xpath(addXpath)).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }
}
