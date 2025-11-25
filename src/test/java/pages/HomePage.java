package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    By firstProduct = By.cssSelector(".product-thumb h4 a");

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
    public void openFirstProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement firstProduct = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-thumb h4 a"))
        );

        // Scroll smoothly
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", firstProduct);

        // لو في Sticky Header فوق.. ننزل شوية
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -120);");

        // انتظر لحد ما يبقى Clickable فعلاً
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct));

        try {
            firstProduct.click();
        } catch (Exception e) {
            // لو لسه فيه عنصر مغطيه → نستخدم JS Click
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstProduct);
        }
    }



}