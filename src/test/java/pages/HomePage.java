package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Top nav dropdown: My Account
    private By myAccountDropdown = By.xpath(
            "//a[contains(@class,'dropdown-toggle') and contains(.,'My Account')]"
    );

    // Login inside dropdown
    private By loginMenuLink = By.xpath(
            "//ul[contains(@class,'dropdown-menu')]//a[text()='Login']"
    );

    // My Account inside dropdown
    private By myAccountMenuLink = By.xpath(
            "//ul[contains(@class,'dropdown-menu')]//a[text()='My Account']"
    );

    // Logout inside dropdown
    private By logoutMenuLink = By.xpath(
            "//ul[contains(@class,'dropdown-menu')]//a[text()='Logout']"
    );

    private WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    // Open Dropdown
    public void openMyAccountMenu() {
        driver.findElement(myAccountDropdown).click();
    }

    // Click Login
    public void clickLogin() {
        openMyAccountMenu();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(loginMenuLink));
        driver.findElement(loginMenuLink).click();
    }

    // Click My Account
    public void clickMyAccount() {
        openMyAccountMenu();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(myAccountMenuLink));
        driver.findElement(myAccountMenuLink).click();
    }
    // ⭐ Click Logout from Dropdown
    public void clickLogoutDropdown() {
        openMyAccountMenu();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(logoutMenuLink));
        driver.findElement(logoutMenuLink).click();
    }
}