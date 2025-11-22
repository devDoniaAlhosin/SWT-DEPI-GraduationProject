package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {

    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Logout link ONLY in the Account Page sidebar menu
    private By sidebarLogoutLink =
            By.xpath("//div[contains(@class,'list-group')]//a[text()='Logout']");

    // ACTION: Logout from the Account Page (stable & safe)
    public void clickSidebarLogout() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Wait for the sidebar logout to be clickable
        WebElement logoutBtn =
                wait.until(ExpectedConditions.elementToBeClickable(sidebarLogoutLink));

        // Scroll the element into view to avoid interception
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", logoutBtn);

        // Small pause for scroll to finish
        try { Thread.sleep(300); } catch (Exception e) {}

        // Click safely
        logoutBtn.click();
    }

    // Helper: Get current page title
    public String getPageTitle() {
        return driver.getTitle().trim();
    }
}
