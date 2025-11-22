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

    private By myAccountDropdown = By.xpath(
            "//a[contains(@class,'dropdown-toggle') and contains(.,'My Account')]"
    );

    private By loginLink = By.xpath(
            "//a[@class='dropdown-item' and text()='Login']"
    );

    public WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void openMyAccountMenu() {
        driver.findElement(myAccountDropdown).click();
    }

    public void clickLogin() {
        openMyAccountMenu();

        // WAIT ONLY FOR LOGIN LINK TO BE VISIBLE
        getWait().until(ExpectedConditions.visibilityOfElementLocated(loginLink));

        driver.findElement(loginLink).click();
    }

}
