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

    // Sidebar logout button
    private By sidebarLogoutLink =
            By.xpath("//div[contains(@class,'list-group')]//a[text()='Logout']");

    // ===== CLICK LOGOUT FROM SIDEBAR =====
    public void clickSidebarLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement logoutBtn =
                wait.until(ExpectedConditions.elementToBeClickable(sidebarLogoutLink));

        // Scroll to the logout link to avoid "element click intercepted" error
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", logoutBtn);

        try { Thread.sleep(300); } catch (InterruptedException ignored) {}

        logoutBtn.click();
    }

    // ===== RETURN PAGE TITLE =====
    public String getPageTitle() {
        return driver.getTitle().trim();
    }
}
