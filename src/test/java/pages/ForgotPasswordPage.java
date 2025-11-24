package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Locators
    private By emailField = By.id("input-email");
    private By continueButton = By.xpath("//button[@type='submit' and text()='Continue']");
    private By successAlert = By.cssSelector(".alert-success");

    // Actions
    public void enterEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    // Assertions
    public String getPageTitle() {
        return driver.getTitle().trim();
    }

    public String getSuccessMessage() {
        return driver.findElement(successAlert).getText().trim();
    }
}
