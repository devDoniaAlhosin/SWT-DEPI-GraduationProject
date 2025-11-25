package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {

    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }
    private By orderHistoryLink = By.linkText("Order History");

    // ===== RETURN PAGE TITLE =====
    public String getPageTitle() {
        return driver.getTitle().trim();
    }

    public void clickOrderHistory() {
        driver.findElement(orderHistoryLink).click();
    }
}
